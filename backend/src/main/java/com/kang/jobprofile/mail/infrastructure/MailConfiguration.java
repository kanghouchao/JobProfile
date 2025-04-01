package com.kang.jobprofile.mail.infrastructure;

import com.kang.jobprofile.common.infrastructure.WebsiteProperties;
import com.kang.jobprofile.i18n.infrastructure.ResourceBundleHandler;
import com.kang.jobprofile.mail.application.MailSenderHandle;
import com.kang.jobprofile.template.infrastructure.ThymeleafRenderer;
import com.kang.jobprofile.user.auth.infrastructure.AuthProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;

/**
 * @author kanghouchao
 */
@Configuration
@RequiredArgsConstructor
public class MailConfiguration {

    private final MailProperties mailProperties;

    @Bean
    public MailSenderHandle mailSenderHandle(MailSender mailSender,
                                             ResourceBundleHandler resourceBundleHandler,
                                             ThymeleafRenderer thymeleafRenderer,
                                             AuthProperties authProperties,
                                             WebsiteProperties websiteProperties) {
        return new MailSenderHandle(this.mailProperties.getUsername(), mailSender,
            resourceBundleHandler, thymeleafRenderer, authProperties, websiteProperties);
    }

    @Bean(name = "myMailSender")
    public MailSender mailSender(JavaMailSender javaMailSender) {
        return new MailSender(javaMailSender);
    }

}
