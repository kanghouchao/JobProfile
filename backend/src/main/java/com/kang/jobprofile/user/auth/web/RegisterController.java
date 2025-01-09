package com.kang.jobprofile.user.auth.web;

import com.kang.jobprofile.mail.application.Sender;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kanghouchao
 */
@RestController
@AllArgsConstructor
class RegisterController {

    private final Sender sender;

    @PutMapping("auth/register")
    void sendMail(@RequestParam String email) {
        this.sender.sendRegisterMail(email);
    }

}
