package com.kang.job.auth.service;

import com.kang.job.auth.exception.EmailAlreadyRegisteredException;

/**
 * @author kanghouchao
 */
public interface ValidationService {

    /**
     * @param email
     * @throws EmailAlreadyRegisteredException
     */
    void isEmailNotRegistered(String email) throws EmailAlreadyRegisteredException;

    void isTokenOK(String token);
}
