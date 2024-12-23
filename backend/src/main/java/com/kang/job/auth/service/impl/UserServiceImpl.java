package com.kang.job.auth.service.impl;

import com.kang.job.auth.entity.User;
import com.kang.job.auth.repository.UserRepository;
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

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    @Override
    public boolean existsByEmail(String email) {
        return this.userRepository.existsByEmail(email);
    }

    @Override
    public User createUser(String email, String password) {
        final User user = new User();
        user.setNickname(UUID.randomUUID().toString());
        user.setEmail(email);
        user.setPassword(this.passwordEncoder.encode(password));
        user.setEmailVerified(true);
        return this.userRepository.save(user);
    }
}
