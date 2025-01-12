package com.kang.jobprofile.user.auth.domain;

import java.time.LocalDateTime;

/**
 * @author kanghouchao
 */
public record RegistrationToken(String token, LocalDateTime expiryTime) {

    public boolean isExpired() {
        return expiryTime.isBefore(LocalDateTime.now());
    }
}
