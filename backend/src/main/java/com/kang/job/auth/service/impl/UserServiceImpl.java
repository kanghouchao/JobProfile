package com.kang.job.auth.service.impl;

import com.kang.job.auth.domain.model.Account;
import com.kang.job.auth.infrastructure.repository.JpaUserRepository;
import com.kang.job.auth.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;


/**
 * @author kanghouchao
 */
@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final JpaUserRepository jpaUserRepository;

    private final PasswordEncoder passwordEncoder;

    @Override
    public boolean existsByEmail(String email) {
        return this.jpaUserRepository.existsByEmail(email);
    }

    @Override
    public Account createUser(String email, String password) {
        final Account account = new Account();
        account.setNickname(UUID.randomUUID().toString());
        account.setEmail(email);
        account.setPassword(this.passwordEncoder.encode(password));
        account.setEmailVerified(true);
        return this.jpaUserRepository.save(account);
    }
}
