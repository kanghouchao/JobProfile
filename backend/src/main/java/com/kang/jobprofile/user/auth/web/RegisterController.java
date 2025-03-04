package com.kang.jobprofile.user.auth.web;

import com.kang.jobprofile.common.infrastructure.WebsiteProperties;
import com.kang.jobprofile.user.auth.application.RegistrationService;
import com.kang.jobprofile.user.auth.infrastructure.AuthProperties;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    private final AuthProperties authProperties;

    private final WebsiteProperties websiteProperties;

    @PutMapping("send-mail")
    void sendMail(@RequestParam @Email String email) {
        String activationLink = websiteProperties.getScheme() + "://" + websiteProperties.getRemote()
            +  authProperties.getRegisterPageUrl() + "?token=";
        this.registrationService.mailVerification(email, activationLink);
    }

    @PostMapping("setting-password")
    void settingPassword(String password) {

    }

}
