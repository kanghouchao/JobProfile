package com.kang.resume.user.auth.interfaces.web.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import static com.kang.resume.common.constant.Constants.MIN_PASSWORD_LENGTH;

public record CompleteRegistrationRequest(
    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    String email,
    
    @NotBlank(message = "Token is required")
    String token,
    
    @NotBlank(message = "Password is required")
    @Size(min = MIN_PASSWORD_LENGTH, message = "Password must be at least " + MIN_PASSWORD_LENGTH + " characters long")
    String password
) { }
