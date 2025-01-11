package com.kang.jobprofile.mail.application;

import com.kang.jobprofile.mail.infrastructure.TokenRepository;
import com.kang.jobprofile.mail.model.RegistrationToken;
import com.kang.jobprofile.mail.model.TokenFactory;

/**
 * @author kanghouchao
 */
public class TokenHandle {

    private TokenRepository tokenRepository;

    public RegistrationToken createRegistrationToken() {
        RegistrationToken registrationToken = TokenFactory.createToken();
        this.tokenRepository.save(registrationToken);
        return registrationToken;
    }

    public boolean isExpired(String token) {
        RegistrationToken registrationToken = this.tokenRepository.findByToken(token);
        return registrationToken.isExpired();
    }
}
