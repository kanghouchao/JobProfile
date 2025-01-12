package com.kang.jobprofile.mail.application;

import com.kang.jobprofile.i18n.infrastructure.ResourceBundleHandler;
import com.kang.jobprofile.mail.infrastructure.MailSender;
import com.kang.jobprofile.mail.model.Mail;
import com.kang.jobprofile.template.infrastructure.ThymeleafRenderer;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;

/**
 * @author kanghouchao
 */
@RequiredArgsConstructor
public class MailSenderHandle {

    private final String fromAddress;

    private final MailSender mailSender;

    private final ResourceBundleHandler resourceBundleHandler;

    private final ThymeleafRenderer thymeleafRenderer;

    public void sendRegisterMail(String to, String token) throws MessagingException {
        final Mail mail = new Mail(this.fromAddress, to,
            this.resourceBundleHandler.getRegistrationMailSubject(),
            this.thymeleafRenderer.getRegistrationMailCount(token));
        this.mailSender.sendMail(mail);
    }

}
