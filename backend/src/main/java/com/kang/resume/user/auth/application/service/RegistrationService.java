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

    /**
     * Repository for user data access.
     */
    private final UserRepository userRepository;
    /**
     * Service for sending emails.
     */
    private final EmailService emailService;
    /**
     * Encoder for user passwords.
     */
    private final PasswordEncoder passwordEncoder;
    /**
     * Utility for retrieving internationalized messages.
     */
    private final MessageSourceUtil messageSource;
    /**
     * Properties related to the site, such as URLs.
     */
    private final SiteProperties siteProperties;

    /**
     * Initiates the user registration process.
     * If the email is already registered and verified, an exception is thrown.
     * If the email is registered but not verified, the verification token is refreshed.
     * Otherwise, a new unverified user is created.
     * A verification email is then sent to the user.
     *
     * @param emailStr The email address of the user to register.
     */
    @Transactional
    public void initiateRegistration(final String emailStr) {
        final Email email = Email.of(emailStr);

        final User user = userRepository.findByEmail(email)
                .map(existingUser -> {
                    if (existingUser.isEnabled()) {
                        throw new IllegalStateException(
                                messageSource.getMessage("error.auth.email.registered"));
                    }
                    existingUser.refreshVerificationToken();
                    return existingUser;
                })
                .orElseGet(() -> User.createUnverifiedUser(email));

        userRepository.save(user);

        final String verificationLink = siteProperties.buildRegisterVerificationUrl(
                user.getEmail().getValue(),
                user.getVerificationToken()
        );

        emailService.sendVerificationEmail(
                user.getEmail().getValue(),
                verificationLink,
                LocaleContextHolder.getLocale()
        );
    }

    /**
     * Completes the user registration process.
     * Verifies the provided email and token, then sets the user's password and enables the account.
     *
     * @param email The email address of the user.
     * @param token The verification token received by the user.
     * @param password The chosen password for the user's account.
     */
    @Transactional
    public void completeRegistration(final String email, final String token, final String password) {
        final User user = userRepository.findByEmailAndVerificationToken(Email.of(email), token)
                .orElseThrow(() -> new IllegalStateException(
                        messageSource.getMessage("error.auth.token.invalid")));

        if (user.getTokenExpiryTime().isBefore(LocalDateTime.now())) {
            throw new IllegalStateException(
                    messageSource.getMessage("registration.token.expired"));
        }

        user.setPassword(passwordEncoder.encode(password));
        user.setEnabled(true);
        user.setEmailVerified(true);
        user.setVerificationToken(null);
        user.setTokenExpiryTime(null);

        userRepository.save(user);
    }
}
