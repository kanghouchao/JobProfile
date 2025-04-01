package com.kang.jobprofile.user.auth.service;

import com.kang.jobprofile.user.auth.domain.RegistrationToken;
import com.kang.jobprofile.user.auth.domain.RegistrationTokenFactory;
import com.kang.jobprofile.user.auth.infrastructure.TokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author kanghouchao
 */
@Service
@RequiredArgsConstructor
public class RegistrationTokenService {

    private final TokenRepository tokenRepository;

    private void emailIsNotRegistered(String email) {
        List<RegistrationToken> tokens = this.tokenRepository.findByEmail(email);
        tokens.stream()
            .filter(RegistrationToken::isNotExpired)
            .findAny()
            .ifPresent(
                token -> {
                    throw new IllegalArgumentException(email + " is already registered, please try again");
                }
            );
    }

    public void tokenIsExists(String token) {
        this.tokenRepository.findByToken(token).orElseThrow(() -> new IllegalArgumentException(token + " is not exists"));
    }

    public String save(String email) {
        this.emailIsNotRegistered(email);
        RegistrationToken registrationToken = RegistrationTokenFactory.create(email);
        this.tokenRepository.save(registrationToken);
        return registrationToken.getToken();
    }

    public void checkToken(String email, String token) {
        this.tokenRepository.findByEmailAndToken(email, token)
            .ifPresentOrElse(RegistrationToken::isNotExpired, () ->
                {
                    throw new IllegalArgumentException("token " + token + " is not exists");
                }
            );
    }

    public void deleteToken(String token) {
        this.tokenRepository.deleteByToken(token);
    }
}
