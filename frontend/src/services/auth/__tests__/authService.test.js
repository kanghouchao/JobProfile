import createAuthService from "../index";

const mockHttpClient = {
    post: jest.fn(),
    put: jest.fn(),
};

const authService = createAuthService(mockHttpClient);

describe("authService", () => {
    beforeEach(() => {
        jest.clearAllMocks();
        localStorage.clear();
    });

    describe("login", () => {
        it("should store token in localStorage on successful login", async () => {
            const mockResponse = { token: "test-token" };
            mockHttpClient.post.mockResolvedValue(mockResponse);

            const response = await authService.login("test@example.com", "password123");

            expect(mockHttpClient.post).toHaveBeenCalledWith("/auth/login", {
                email: "test@example.com",
                password: "password123",
            });
            expect(localStorage.getItem("token")).toBe("test-token");
            expect(response).toEqual(mockResponse);
        });

        it("should handle login failure correctly", async () => {
            const errorMessage = "Invalid credentials";
            mockHttpClient.post.mockRejectedValue(new Error(errorMessage));

            await expect(authService.login("test@example.com", "wrong-password"))
                .rejects
                .toThrow(errorMessage);

            expect(localStorage.getItem("token")).toBeNull();
        });
    });

    describe("initiateRegistration", () => {
        it("should call the correct API endpoint with email", async () => {
            mockHttpClient.put.mockResolvedValue({ success: true });

            const response = await authService.initiateRegistration("test@example.com");

            expect(mockHttpClient.put).toHaveBeenCalledWith("/auth/register/initiate", {
                email: "test@example.com",
            });
            expect(response).toEqual({ success: true });
        });
    });

    describe("completeRegistration", () => {
        it("should call the correct API endpoint with email, token, and password", async () => {
            mockHttpClient.post.mockResolvedValue({ success: true });

            const response = await authService.completeRegistration("test@example.com", "test-token", "password123");

            expect(mockHttpClient.post).toHaveBeenCalledWith("/auth/register/complete", {
                email: "test@example.com",
                token: "test-token",
                password: "password123",
            });
            expect(response).toEqual({ success: true });
        });
    });

    describe("logout", () => {
        it("should remove token from localStorage", () => {
            localStorage.setItem("token", "test-token");
            authService.logout();
            expect(localStorage.getItem("token")).toBeNull();
        });
    });

    describe("getCurrentUser", () => {
        it("should return parsed user from localStorage", () => {
            const mockUser = { id: 1, name: "Test User" };
            localStorage.setItem("user", JSON.stringify(mockUser));

            const user = authService.getCurrentUser();

            expect(user).toEqual(mockUser);
        });
    });

    describe("getToken", () => {
        it("should return token from localStorage", () => {
            localStorage.setItem("token", "test-token");

            const token = authService.getToken();

            expect(token).toBe("test-token");
        });
    });

    describe("isAuthenticated", () => {
        it("should return true if token exists in localStorage", () => {
            localStorage.setItem("token", "test-token");

            const isAuthenticated = authService.isAuthenticated();

            expect(isAuthenticated).toBe(true);
        });

        it("should return false if token does not exist in localStorage", () => {
            const isAuthenticated = authService.isAuthenticated();

            expect(isAuthenticated).toBe(false);
        });
    });
});
