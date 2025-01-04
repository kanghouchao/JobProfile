package com.kang.job.auth.service;

import com.kang.job.auth.domain.model.Account;

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

    Account createUser(String email, String password);
}
