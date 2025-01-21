package com.kang.jobprofile.user.auth.application;

import com.kang.jobprofile.user.auth.domain.RegistrationMailSendEvent;
import com.kang.jobprofile.user.auth.domain.RegistrationToken;
import com.kang.jobprofile.user.auth.domain.RegistrationTokenFactory;
import com.kang.jobprofile.user.auth.infrastructure.TokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;

import java.util.Objects;

/**
 * @author kanghouchao
 */
@RequiredArgsConstructor
public class RegistrationService {

    private final TokenRepository tokenRepository;

    private final ApplicationEventPublisher applicationEventPublisher;

    public void mailVerification(String email) {
        RegistrationToken token = this.tokenRepository.findByEmail(email);
        if (Objects.nonNull(token)) {
            throw new IllegalArgumentException();
        }
        token = RegistrationTokenFactory.create(email);
        this.tokenRepository.save(token);
        this.applicationEventPublisher.publishEvent(new RegistrationMailSendEvent(token.getEmail(), token.getToken()));
    }
}
