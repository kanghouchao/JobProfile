package com.kang.jobprofile.mail.infrastructure;

import com.kang.jobprofile.i18n.infrastructure.ResourceBundleHandler;
import com.kang.jobprofile.mail.application.MailSenderHandle;
import com.kang.jobprofile.template.infrastructure.ThymeleafRenderer;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author kanghouchao
 */
@Configuration
@RequiredArgsConstructor
public class MailConfiguration {

    @Bean
    public MailSenderHandle mailSenderHandle(MailSender mailSender,
                                             MailProperties mailProperties,
                                             ResourceBundleHandler resourceBundleHandler,
                                             ThymeleafRenderer thymeleafRenderer) {
        return new MailSenderHandle(mailProperties.getUsername(), mailSender, resourceBundleHandler, thymeleafRenderer);
    }

    @Bean
    public MailSender mailSender() {
        return new MailSender();
    }

}
