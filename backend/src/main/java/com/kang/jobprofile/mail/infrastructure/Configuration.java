package com.kang.jobprofile.mail.infrastructure;

import com.kang.jobprofile.mail.application.Sender;

/**
 * @author kanghouchao
 */
@org.springframework.context.annotation.Configuration
public class Configuration {

    public Sender mailSender() {
        return new Sender();
    }
}
