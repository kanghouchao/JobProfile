package com.kang.job.auth.model;

import jakarta.validation.constraints.NotBlank;

/**
 * @author kanghouchao
 */
public record PasswordSettingRequest(@NotBlank String token, @NotBlank String password) {
}
