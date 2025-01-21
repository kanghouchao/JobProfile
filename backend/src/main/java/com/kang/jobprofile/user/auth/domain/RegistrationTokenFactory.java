package com.kang.jobprofile.user.auth.domain;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * @author kanghouchao
 */
public class RegistrationTokenFactory {

    public static RegistrationToken create(String email) {
        RegistrationToken registrationToken = new RegistrationToken();
        registrationToken.setEmail(email);
        registrationToken.setToken(UUID.randomUUID().toString());
        registrationToken.setExpiryTime(LocalDateTime.now().plusMinutes(15));
        return registrationToken;
    }
}
