package com.kang.job.auth.service.impl;

import com.kang.job.auth.entity.EmailVerificationToken;
import com.kang.job.auth.repository.EmailVerificationTokenRepository;
import com.kang.job.auth.service.EmailVerificationTokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

/**
 * @author kanghouchao
 */
@Service
@RequiredArgsConstructor
public class EmailVerificationTokenServiceImpl implements EmailVerificationTokenService {

    @Value("${register.token.time:3600}")
    private Long expirationTime;

    private final EmailVerificationTokenRepository tokenRepository;

    @Override
    @Transactional
    public EmailVerificationToken createNewToken(String email, String token) {
        LocalDateTime now = LocalDateTime.now();
        EmailVerificationToken verificationToken = new EmailVerificationToken();
        verificationToken.setEmail(email);
        verificationToken.setToken(token);
        verificationToken.setRequestTime(now);
        verificationToken.setIsUsed(Boolean.FALSE);
        verificationToken.setExpirationTime(now.plusSeconds(expirationTime));
        return this.tokenRepository.save(verificationToken);
    }

    @Override
    public EmailVerificationToken findByToken(String token) {
        return this.tokenRepository.findByToken(token);
    }
}
