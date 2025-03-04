package com.kang.jobprofile.common.infrastructure;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author kanghouchao
 */
@Getter
@AllArgsConstructor
@ConfigurationProperties(prefix = "job.profile.website")
public class WebsiteProperties {

    private final String remote;

    private final String scheme;

}
