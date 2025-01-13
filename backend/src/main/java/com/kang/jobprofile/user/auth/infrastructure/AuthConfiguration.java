package com.kang.jobprofile.user.auth.infrastructure;

import com.kang.jobprofile.mail.application.MailSenderHandle;
import com.kang.jobprofile.user.auth.application.RegistrationService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author kanghouchao
 */
@Configuration
public class AuthConfiguration {

    @Bean
    public RegistrationService registrationService(MailSenderHandle mailSenderHandle, TokenRepository tokenRepository) {
        return new RegistrationService(mailSenderHandle, tokenRepository);
    }

}
