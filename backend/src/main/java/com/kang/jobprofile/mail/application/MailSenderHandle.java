package com.kang.jobprofile.mail.application;

import com.kang.jobprofile.mail.infrastructure.I18nMessageFinder;
import com.kang.jobprofile.mail.infrastructure.MailSender;
import com.kang.jobprofile.mail.infrastructure.TemplateProcess;
import lombok.RequiredArgsConstructor;

/**
 *
 *
 * @author kanghouchao
 */
@RequiredArgsConstructor
public class MailSenderHandle {

    private final String fromAddress;

    private final I18nMessageFinder i18nMessageFinder;

    private final MailSender mailSender;

    private final TemplateProcess templateProcess;

    public void sendRegisterMail(String email, String registrationLink) {

    }

}
