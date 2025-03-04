package com.kang.jobprofile.common.infrastructure;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author kanghouchao
 */
@Getter
@AllArgsConstructor
@ConfigurationProperties(prefix = "job.profile.site")
public class WebsiteProperties {

    private final String domain;

    private final String scheme;

}
