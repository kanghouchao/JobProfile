package com.kang.job.auth.mail.infrastructure;

import com.kang.job.auth.mail.model.Mail;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;

/**
 * @author kanghouchao
 */
@RequiredArgsConstructor
public class MailSender {

    private JavaMailSender javaMailSender;

    public void sendMail(Mail mail) {

    }
}
