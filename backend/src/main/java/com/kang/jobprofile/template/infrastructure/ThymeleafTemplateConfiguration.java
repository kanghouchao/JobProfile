package com.kang.jobprofile.template.infrastructure;

import com.kang.jobprofile.i18n.infrastructure.ResourceBundleHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.TemplateEngine;

/**
 * @author kanghouchao
 */
@Configuration
public class ThymeleafTemplateConfiguration {

    @Bean
    public ThymeleafRenderer thymeleafRenderer(TemplateEngine templateEngine, ResourceBundleHandler resourceBundleHandler) {
        return new ThymeleafRenderer(templateEngine, resourceBundleHandler);
    }
}
