package com.kang.jobprofile.user.auth.interfaces.web.response;

public record LoginResponse(
    String token,
    String tokenType
) {
    public static LoginResponse of(String token) {
        return new LoginResponse(token, "Bearer");
    }
}
