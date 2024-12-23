package com.kang.job.auth.service;

import com.kang.job.auth.entity.User;
import jakarta.mail.MessagingException;

/**
 * @author kanghouchao
 */
public interface RegisterService {

    /**
     * send Email for register
     *
     * @param email user email
     * @throws MessagingException Mail Service ERROR
     */
    void sendEmail(String email) throws MessagingException;

    /**
     *
     * @param token
     * @param password
     * @return
     */
    User createUser(String token, String password);
}
