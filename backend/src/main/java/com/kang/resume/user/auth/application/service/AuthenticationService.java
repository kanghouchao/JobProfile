package com.kang.resume.user.auth.application.service;

import com.kang.resume.user.auth.domain.vo.Email;
import com.kang.resume.user.auth.infrastructure.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    @Transactional(readOnly = true)
    /**
     * Authenticates a user with the provided email and password.
     *
     * @param emailStr The email address of the user.
     * @param password The password of the user.
     * @return A JWT token if authentication is successful.
     */
    public String authenticate(final String emailStr, final String password) {
        final Email email = Email.of(emailStr);

        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(email.getValue(), password)
        );

        final UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        return jwtService.generateToken(userDetails);
    }
}
