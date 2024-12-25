package com.kang.job.config.authentication;

import com.kang.job.auth.unit.TokenProvider;
import jakarta.servlet.FilterChain;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.io.IOException;
import java.util.Collections;

/**
 * @author kanghouchao
 */
@Slf4j
public class LoginAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final TokenProvider tokenProvider;

    public LoginAuthenticationFilter(AntPathRequestMatcher antPathRequestMatcher, TokenProvider tokenProvider,
                                     AuthenticationManager authenticationManager) {
        super(authenticationManager);
        super.setRequiresAuthenticationRequestMatcher(antPathRequestMatcher);
        this.tokenProvider = tokenProvider;
    }

    @Override
    protected void successfulAuthentication(
        HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) {
        String token = tokenProvider.generateToken(authResult.getName(), Collections.emptyList());

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.setStatus(HttpServletResponse.SC_OK);
        try {
            response.getWriter().write("{\"token\": \"" + token + "\"}");
        } catch (IOException e) {
            log.error("Failed to write token to response body", e);
        }
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response,
                                              AuthenticationException failed) {
        log.warn("Authentication failed for request: {}", request.getRequestURI(), failed);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        try {
            response.getWriter().write("{\"message\": \"Authentication failed: " + failed.getMessage() + "\"}");
        } catch (IOException e) {
            log.error("Failed to write error response", e);
        }
    }
}