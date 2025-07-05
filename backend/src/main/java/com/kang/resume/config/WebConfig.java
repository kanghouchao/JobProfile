package com.kang.resume.config;

import com.kang.resume.common.config.SiteProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.NonNull;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import static com.kang.resume.common.constant.Constants.CORS_MAX_AGE_SECONDS;

@Configuration
@RequiredArgsConstructor
public class WebConfig implements WebMvcConfigurer {

    /**
     * Site properties for configuring CORS origins.
     */
    private final SiteProperties siteProperties;

    /**
     * Configures CORS mappings for the application.
     *
     * @param registry The CorsRegistry to configure.
     */
    @Override
    public void addCorsMappings(@NonNull final CorsRegistry registry) {
        final String origin = String.format("%s://%s", siteProperties.getScheme(), siteProperties.getDomain());

        registry.addMapping("/api/**")
                .allowedOrigins(origin)
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedHeaders("*")
                .allowCredentials(true)
                .maxAge(CORS_MAX_AGE_SECONDS);
    }
}
