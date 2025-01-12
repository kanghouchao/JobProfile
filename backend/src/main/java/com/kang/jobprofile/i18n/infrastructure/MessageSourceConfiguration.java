package com.kang.jobprofile.i18n.infrastructure;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author kanghouchao
 */
@Configuration
public class MessageSourceConfiguration {

    @Bean
    ResourceBundleHandler resourceBundleHandler(MessageSource messageSource) {
        return new ResourceBundleHandler(messageSource);
    }

}
