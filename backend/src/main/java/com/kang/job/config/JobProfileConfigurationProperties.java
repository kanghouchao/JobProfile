package com.kang.job.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author kanghouchao
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "job-profile")
public class JobProfileConfigurationProperties {

    private Long registerTokenExpirationSeconds = 15 * 60L;

    private String siteDomain = "https://www.job-profile.com";

    private String registerVerifyEmailBaseLink = siteDomain + "/password-settings?token=";

    private Long loginTokenExpirationMills = 60 * 60 * 1000L;

}
