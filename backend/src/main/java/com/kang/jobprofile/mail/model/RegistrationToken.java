package com.kang.jobprofile.mail.model;

import java.time.LocalDateTime;

/**
 * @author kanghouchao
 */
public record RegistrationToken(String token, LocalDateTime expiryTime) {

    public boolean isExpired() {
        return expiryTime.isBefore(LocalDateTime.now());
    }
}
