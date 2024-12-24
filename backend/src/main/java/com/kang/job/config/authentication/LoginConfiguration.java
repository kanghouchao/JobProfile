package com.kang.job.config.authentication;

import com.kang.job.auth.unit.TokenProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 * @author kanghouchao
 */
@Configuration
public class LoginConfiguration {

    @Bean
    public LoginAuthenticationFilter jwtAuthenticationFilter(TokenProvider tokenProvider, HttpSecurity http) throws Exception {
        return new LoginAuthenticationFilter(new AntPathRequestMatcher("/login", "POST"), tokenProvider, authenticationManager(http));
    }

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
        return http.getSharedObject(AuthenticationManagerBuilder.class).build();
    }
}
