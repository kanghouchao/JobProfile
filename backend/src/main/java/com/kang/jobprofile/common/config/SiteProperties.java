package com.kang.jobprofile.common.config;

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

    public String buildRegisterVerificationUrl(String email, String token) {
        return String.format("%s://%s%s?email=%s&token=%s",
                scheme, domain, registerPath, email, token);
    }
}
