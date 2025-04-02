package com.kang.jobprofile.config;

import com.kang.jobprofile.common.config.SiteProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.NonNull;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
public class WebConfig implements WebMvcConfigurer {

    private final SiteProperties siteProperties;

    @Override
    public void addCorsMappings(@NonNull CorsRegistry registry) {
        String origin = String.format("%s://%s", siteProperties.getScheme(), siteProperties.getDomain());
        
        registry.addMapping("/api/**")
                .allowedOrigins(origin)
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedHeaders("*")
                .allowCredentials(true)
                .maxAge(3600);
    }
}
