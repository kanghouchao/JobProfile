package com.kang.jobprofile.user.auth.service;

import com.kang.jobprofile.user.auth.domain.UserFactory;
import com.kang.jobprofile.user.auth.domain.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author kanghouchao
 */
@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {

    private UserRepository userRepository;

    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.userRepository.getUserByEmail(username);
    }

    public void createUser(String email, String password) {
        this.userRepository.save(UserFactory.createUser(email, passwordEncoder.encode(password)));
    }
}
