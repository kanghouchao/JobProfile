package com.kang.resume.common.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "app.site")
@Getter
@Setter
public class SiteProperties {
    private String scheme;
    private String domain;
    private String registerPath;

    /**
     * Builds the complete URL for user registration verification.
     *
     * @param email The email address of the user.
     * @param token The verification token.
     * @return The complete registration verification URL.
     */
    public String buildRegisterVerificationUrl(final String email, final String token) {
        return String.format("%s://%s%s?email=%s&token=%s",
                scheme, domain, registerPath, email, token);
    }
}
