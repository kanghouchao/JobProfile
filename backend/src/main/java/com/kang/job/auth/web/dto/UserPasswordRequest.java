package com.kang.job.auth.web.dto;

import jakarta.validation.constraints.NotBlank;

/**
 * @author kanghouchao
 */
public record UserPasswordRequest(@NotBlank String token, @NotBlank String password) {
}
