package com.kang.jobprofile.mail.application;

import com.kang.jobprofile.i18n.infrastructure.ResourceBundleHandler;
import com.kang.jobprofile.mail.infrastructure.MailSender;
import com.kang.jobprofile.mail.model.Mail;
import com.kang.jobprofile.template.infrastructure.ThymeleafRenderer;
import com.kang.jobprofile.user.auth.domain.RegistrationMailSendEvent;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;

/**
 * @author kanghouchao
 */
@RequiredArgsConstructor
public class MailSenderHandle {

    private final String fromAddress;

    private final MailSender mailSender;

    private final ResourceBundleHandler resourceBundleHandler;

    private final ThymeleafRenderer thymeleafRenderer;

    @EventListener
    public void sendRegisterMail(RegistrationMailSendEvent registrationMailSendEvent) throws MessagingException {
        final Mail mail = new Mail(this.fromAddress, registrationMailSendEvent.email(),
            this.resourceBundleHandler.getRegistrationMailSubject(),
            this.thymeleafRenderer.getRegistrationMailCount(registrationMailSendEvent.email()));
        this.mailSender.sendMail(mail);
    }

}
