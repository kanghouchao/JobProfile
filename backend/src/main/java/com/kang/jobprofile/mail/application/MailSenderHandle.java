package com.kang.jobprofile.mail.application;

import com.kang.jobprofile.common.infrastructure.WebsiteProperties;
import com.kang.jobprofile.i18n.infrastructure.ResourceBundleHandler;
import com.kang.jobprofile.mail.infrastructure.MailSender;
import com.kang.jobprofile.mail.model.Mail;
import com.kang.jobprofile.template.infrastructure.ThymeleafRenderer;
import com.kang.jobprofile.user.auth.domain.RegistrationMailSendEvent;
import com.kang.jobprofile.user.auth.infrastructure.AuthProperties;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;

/**
 * @author kanghouchao
 */
@RequiredArgsConstructor
public class MailSenderHandle {

    private final String fromAddress;

    private final MailSender mailSender;

    private final ResourceBundleHandler resourceBundleHandler;

    private final ThymeleafRenderer thymeleafRenderer;

    private final AuthProperties authProperties;

    private final WebsiteProperties websiteProperties;

    //TODO activationLinkの生成の方法がちょっとおかしい
    @Async
    @EventListener
    public void sendRegisterMail(RegistrationMailSendEvent registrationMailSendEvent) throws MessagingException {
        String activationLink = websiteProperties.getScheme() + "://" + websiteProperties.getDomain()
            + authProperties.getRegisterRouter() + "?token=" + registrationMailSendEvent.token();
        final Mail mail = new Mail(this.fromAddress, registrationMailSendEvent.email(),
            this.resourceBundleHandler.getRegistrationMailSubject(),
            this.thymeleafRenderer.getRegistrationMailCount(activationLink));
        this.mailSender.sendMail(mail);
    }

}
