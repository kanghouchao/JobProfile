package com.kang.jobprofile.user.auth.application;

import com.kang.jobprofile.user.auth.domain.RegistrationMailSendEvent;
import com.kang.jobprofile.user.auth.domain.RegistrationToken;
import com.kang.jobprofile.user.auth.domain.RegistrationTokenFactory;
import com.kang.jobprofile.user.auth.infrastructure.TokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;

/**
 * @author kanghouchao
 */
@RequiredArgsConstructor
public class RegistrationService {

    private final TokenRepository tokenRepository;

    private final ApplicationEventPublisher applicationEventPublisher;

    public void mailVerification(String email) {
        RegistrationToken token = RegistrationTokenFactory.create(email);
        this.tokenRepository.save(token);
        this.applicationEventPublisher.publishEvent(new RegistrationMailSendEvent(token.email(), token.token()));
    }
}
