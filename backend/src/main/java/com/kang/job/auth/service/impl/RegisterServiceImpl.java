package com.kang.job.auth.service.impl;

import com.kang.job.auth.entity.EmailVerificationToken;
import com.kang.job.auth.entity.User;
import com.kang.job.auth.service.EmailSenderService;
import com.kang.job.auth.service.EmailVerificationTokenService;
import com.kang.job.auth.service.RegisterService;
import com.kang.job.auth.service.UserService;
import com.kang.job.auth.service.ValidationService;
import jakarta.mail.MessagingException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

/**
 * @author kanghouchao
 */
@Service
@AllArgsConstructor
public class RegisterServiceImpl implements RegisterService {

    private final EmailSenderService emailSenderService;

    private final EmailVerificationTokenService tokenService;

    private final ValidationService validationService;

    private final UserService userService;

    @Override
    @Transactional
    public void sendEmail(final String email) throws MessagingException {
        this.validationService.isEmailNotRegistered(email);
        final String token = UUID.randomUUID().toString();
        this.tokenService.createNewToken(email, token);
        this.emailSenderService.sendEmailForRegister(email, token);
    }

    @Override
    @Transactional
    public User createUser(final String token, final String password) {
        this.validationService.isTokenOK(token);
        final EmailVerificationToken evt = this.tokenService.findByToken(token);
        this.tokenService.setToUsed(evt);
        return this.userService.createUser(evt.getEmail(), password);
    }
}
