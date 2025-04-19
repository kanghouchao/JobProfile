package com.kang.resume.user.auth.application.service;

import com.kang.resume.common.config.SiteProperties;
import com.kang.resume.common.util.MessageSourceUtil;
import com.kang.resume.user.auth.domain.entity.User;
import com.kang.resume.user.auth.domain.repository.UserRepository;
import com.kang.resume.user.auth.domain.vo.Email;
import lombok.RequiredArgsConstructor;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class RegistrationService {

    private final UserRepository userRepository;
    private final EmailService emailService;
    private final PasswordEncoder passwordEncoder;
    private final MessageSourceUtil messageSource;
    private final SiteProperties siteProperties;

    @Transactional
    public void initiateRegistration(String emailStr) {
        Email email = Email.of(emailStr);
        
        User user = userRepository.findByEmail(email)
                .map(existingUser -> {
                    if (existingUser.isEnabled()) {
                        throw new IllegalStateException(messageSource.getMessage("error.auth.email.registered"));
                    }
                    existingUser.refreshVerificationToken();
                    return existingUser;
                })
                .orElseGet(() -> User.createUnverifiedUser(email));

        userRepository.save(user);
        
        String verificationLink = siteProperties.buildRegisterVerificationUrl(
            user.getEmail().getValue(), 
            user.getVerificationToken()
        );
        
        emailService.sendVerificationEmail(
            user.getEmail().getValue(), 
            verificationLink, 
            LocaleContextHolder.getLocale()
        );
    }

    @Transactional
    public void completeRegistration(String email, String token, String password) {
        User user = userRepository.findByEmailAndVerificationToken(Email.of(email), token)
                .orElseThrow(() -> new IllegalStateException(messageSource.getMessage("error.auth.token.invalid")));

        if (user.getTokenExpiryTime().isBefore(LocalDateTime.now())) {
            throw new IllegalStateException(messageSource.getMessage("registration.token.expired"));
        }

        user.setPassword(passwordEncoder.encode(password));
        user.setEnabled(true);
        user.setEmailVerified(true);
        user.setVerificationToken(null);
        user.setTokenExpiryTime(null);
        
        userRepository.save(user);
    }
}
