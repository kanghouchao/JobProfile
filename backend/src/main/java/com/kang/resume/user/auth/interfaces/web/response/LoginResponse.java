package com.kang.resume.user.auth.interfaces.web.response;

public record LoginResponse(
    String token,
    String tokenType
) {
    /**
     * Creates a new LoginResponse instance with the given token.
     *
     * @param token The JWT token.
     * @return A new LoginResponse instance.
     */
    public static LoginResponse of(final String token) {
        return new LoginResponse(token, "Bearer");
    }
}
