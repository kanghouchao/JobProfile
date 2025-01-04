package com.kang.job.auth.service;

import com.kang.job.auth.user.model.RegistrationToken;

/**
 * @author kanghouchao
 */
public interface EmailVerificationTokenService {

    /**
     * create new token by email
     *
     * @param email email
     * @param token
     */
    RegistrationToken createNewToken(String email, String token);

    RegistrationToken findByToken(String token);

    void setToUsed(RegistrationToken token);
}
