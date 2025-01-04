package com.kang.job.auth.service.impl;

import com.kang.job.auth.user.model.RegistrationToken;
import com.kang.job.auth.infrastructure.repository.EmailVerificationTokenRepository;
import com.kang.job.auth.service.EmailVerificationTokenService;
import com.kang.job.common.config.JobProfileConfigurationProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

/**
 * @author kanghouchao
 */
@Service
@RequiredArgsConstructor
public class EmailVerificationTokenServiceImpl implements EmailVerificationTokenService {

    private final JobProfileConfigurationProperties properties;

    private final EmailVerificationTokenRepository tokenRepository;

    @Override
    @Transactional
    public RegistrationToken createNewToken(String email, String token) {
        LocalDateTime now = LocalDateTime.now();
        RegistrationToken verificationToken = new RegistrationToken();
        verificationToken.setEmail(email);
        verificationToken.setToken(token);
        verificationToken.setRequestTime(now);
        verificationToken.setIsUsed(Boolean.FALSE);
        verificationToken.setExpirationTime(now.plusSeconds(properties.getRegisterTokenExpirationSeconds()));
        return this.tokenRepository.save(verificationToken);
    }

    @Override
    public RegistrationToken findByToken(String token) {
        return this.tokenRepository.findByToken(token);
    }

    @Override
    public void setToUsed(RegistrationToken token) {
        this.tokenRepository.setToUsed(token.getToken());
    }
}
