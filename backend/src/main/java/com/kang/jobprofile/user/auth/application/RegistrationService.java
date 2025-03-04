package com.kang.jobprofile.user.auth.application;

import com.kang.jobprofile.user.auth.domain.RegistrationMailSendEvent;
import com.kang.jobprofile.user.auth.domain.RegistrationToken;
import com.kang.jobprofile.user.auth.domain.RegistrationTokenFactory;
import com.kang.jobprofile.user.auth.infrastructure.TokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * @author kanghouchao
 */
@RequiredArgsConstructor
public class RegistrationService {

    private final TokenRepository tokenRepository;

    private final ApplicationEventPublisher applicationEventPublisher;

    public void mailVerification(String email, String activationLink) {
        if (Objects.nonNull(this.tokenRepository.findFirstByEmailAndExpiryTimeAfter(email, LocalDateTime.now()))) {
            throw new IllegalArgumentException(email + " is not verify now, please try again");
        }
        final RegistrationToken token = RegistrationTokenFactory.create(email);
        this.tokenRepository.save(token);
        this.applicationEventPublisher.publishEvent(
            new RegistrationMailSendEvent(token.getEmail(), activationLink + token.getToken())
        );
    }
}
