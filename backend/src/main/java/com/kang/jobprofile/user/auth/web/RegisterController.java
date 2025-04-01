package com.kang.jobprofile.user.auth.web;

import com.kang.jobprofile.user.auth.application.RegistrationService;
import com.kang.jobprofile.user.auth.application.dto.UserCreatorDTO;
import com.kang.jobprofile.user.auth.web.request.EmailVerificationRequest;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kanghouchao
 */
@Validated
@RestController
@AllArgsConstructor
@RequestMapping("auth/register")
class RegisterController {

    private final RegistrationService registrationService;

    @PutMapping("send-mail")
    void sendMail(@RequestParam @Email String email) {
        this.registrationService.mailVerification(email);
    }

    @PostMapping("create-user")
    void settingPassword(@RequestBody @Valid EmailVerificationRequest request) {
        this.registrationService.createUser(new UserCreatorDTO(request.email(), request.token(), request.password()));
    }

}
