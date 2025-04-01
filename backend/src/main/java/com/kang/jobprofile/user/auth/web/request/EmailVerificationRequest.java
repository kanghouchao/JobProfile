package com.kang.jobprofile.user.auth.web.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Value;
import org.hibernate.validator.constraints.Length;

/**
 * @author kanghouchao
 */
public record EmailVerificationRequest(
    @NotBlank(message = "邮箱不能为空") @Email(message = "邮箱格式不正确") String email,
    @NotBlank(message = "token不能为空") String token,
    @Length(min = 6, max = 18, message = "") @NotBlank(message = "") String password) {

}
