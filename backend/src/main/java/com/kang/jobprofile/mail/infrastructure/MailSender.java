package com.kang.jobprofile.mail.infrastructure;

import com.kang.jobprofile.mail.model.Mail;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

/**
 * @author kanghouchao
 */
public class MailSender {

    private JavaMailSender javaMailSender;

    public void sendMail(Mail mail) throws MessagingException {
        final MimeMessage mimeMessage = this.javaMailSender.createMimeMessage();
        final MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true);
        messageHelper.setFrom(mail.from());
        messageHelper.setTo(mail.to());
        messageHelper.setSubject(mail.subject());
        messageHelper.setText(mail.content(), true);
        this.javaMailSender.send(mimeMessage);
    }
}
