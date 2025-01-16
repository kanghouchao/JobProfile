package com.kang.jobprofile.user.auth.domain;

import jakarta.persistence.Id;

import java.time.LocalDateTime;

/**
 * @author kanghouchao
 */
public record RegistrationToken(String email, @Id String token, LocalDateTime expiryTime) {

    public boolean isExpired() {
        return expiryTime.isBefore(LocalDateTime.now());
    }
}
