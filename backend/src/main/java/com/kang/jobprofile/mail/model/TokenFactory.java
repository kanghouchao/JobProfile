package com.kang.jobprofile.mail.model;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * @author kanghouchao
 */
public class TokenFactory {

    public static RegistrationToken createToken() {
        return new RegistrationToken(
            UUID.randomUUID().toString(),
            LocalDateTime.now().plusMinutes(15)
        );
    }
}
