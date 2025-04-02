package com.kang.jobprofile.user.auth.infrastructure.security;

import com.kang.jobprofile.common.util.MessageSourceUtil;
import com.kang.jobprofile.user.auth.domain.repository.UserRepository;
import com.kang.jobprofile.user.auth.domain.vo.Email;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;
    private final MessageSourceUtil messageSource;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(Email.of(email))
                .orElseThrow(() -> new UsernameNotFoundException(
                    messageSource.getMessage("error.auth.email.not.found", email)
                ));
    }
}
