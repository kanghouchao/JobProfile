package com.kang.jobprofile.user.auth.infrastructure;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author kanghouchao
 */
@Getter
@AllArgsConstructor
@ConfigurationProperties(prefix = "job.profile.auth")
public class AuthProperties {

    private final String registerRouter;
}
