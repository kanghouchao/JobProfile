package com.kang.jobprofile.user.auth.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author kanghouchao
 */
@Data
@Entity
public class RegistrationToken {

    private String email;

    @Id
    private String token;

    private LocalDateTime expiryTime;

    public boolean isExpired() {
        return expiryTime.isBefore(LocalDateTime.now());
    }
}
