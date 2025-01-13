package com.kang.jobprofile.user.auth.domain;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * @author kanghouchao
 */
public class RegistrationTokenFactory {

    public static RegistrationToken create(String email) {
        return new RegistrationToken(email, UUID.randomUUID().toString(), LocalDateTime.now());
    }
}
