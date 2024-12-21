package com.kang.job.auth.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

/**
 * @author kanghouchao
 */
public record LoginRequest(@NotBlank @Email String email,
                           @NotBlank String password) {

}
