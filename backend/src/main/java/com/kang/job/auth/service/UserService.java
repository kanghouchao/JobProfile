package com.kang.job.auth.service;

import com.kang.job.auth.entity.User;

/**
 * @author kanghouchao
 */
public interface UserService {

    /**
     *
     * @param email
     * @return
     */
    boolean existsByEmail(String email);

    User createNewUser(String email, String password);
}
