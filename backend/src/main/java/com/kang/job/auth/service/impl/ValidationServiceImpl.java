package com.kang.job.auth.service.impl;

import com.kang.job.auth.user.model.RegistrationToken;
import com.kang.job.auth.domain.exception.EmailAlreadyRegisteredException;
import com.kang.job.auth.domain.exception.TokenHasExpiredException;
import com.kang.job.auth.domain.exception.TokenHasUsedException;
import com.kang.job.auth.service.EmailVerificationTokenService;
import com.kang.job.auth.service.UserService;
import com.kang.job.auth.service.ValidationService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * @author kanghouchao
 */
@Service
@RequiredArgsConstructor
public class ValidationServiceImpl implements ValidationService {

    private final UserService userService;

    private final EmailVerificationTokenService tokenService;

    private final MessageSource messageSource;

    @Override
    public void isEmailNotRegistered(String email) throws EmailAlreadyRegisteredException {
        if (this.userService.existsByEmail(email)) {
            throw new EmailAlreadyRegisteredException(
                this.messageSource.getMessage("error.EmailAlreadyRegisteredException",
                    new Object[]{email},
                    LocaleContextHolder.getLocale()));
        }
    }

    @Override
    public void isTokenOK(String token) {
        RegistrationToken verificationToken = this.tokenService.findByToken(token);
        if (verificationToken.getIsUsed()) {
            throw new TokenHasUsedException(
                this.messageSource.getMessage("error.TokenHasUsedException",
                    null, LocaleContextHolder.getLocale())
            );
        } else if (verificationToken.getExpirationTime().isBefore(LocalDateTime.now())) {
            throw new TokenHasExpiredException(
                this.messageSource.getMessage("error.TokenHasExpiredException",
                    null, LocaleContextHolder.getLocale())
            );
        }
    }
}
