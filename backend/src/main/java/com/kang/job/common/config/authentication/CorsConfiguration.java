package com.kang.job.common.config.authentication;

import com.kang.job.common.config.JobProfileConfigurationProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

/**
 * @author kanghouchao
 */
@Configuration
@RequiredArgsConstructor
public class CorsConfiguration {

    private final JobProfileConfigurationProperties properties;

    private static final List<String> ALLOWED_HEADERS = List.of("Content-Type", "Authorization", "X-XSRF-TOKEN");

    private static final List<String> ALLOWED_METHODS = List.of("POST", "GET", "DELETE", "PUT", "PATCH", "OPTIONS");

    private static final List<String> ALLOWED_EXPOSE = List.of("X-XSRF-TOKEN");

    private static final Long MAX_AGE = 18000L;


    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        final org.springframework.web.cors.CorsConfiguration configuration = new org.springframework.web.cors.CorsConfiguration();
        configuration.addAllowedOriginPattern(properties.getSiteScheme() + "://" + properties.getSiteDomain());
        configuration.setExposedHeaders(ALLOWED_EXPOSE);
        configuration.setAllowedMethods(ALLOWED_METHODS);
        configuration.setAllowedHeaders(ALLOWED_HEADERS);
        configuration.setMaxAge(MAX_AGE);
        configuration.setAllowCredentials(true);
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}
