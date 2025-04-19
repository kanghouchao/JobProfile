package com.kang.resume.user.auth.infrastructure.email;

import com.kang.resume.common.util.MessageSourceUtil;
import com.kang.resume.user.auth.application.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import java.util.Locale;

@Service
@RequiredArgsConstructor
public class SpringEmailService implements EmailService {

    private final JavaMailSender mailSender;
    private final SpringTemplateEngine templateEngine;
    private final MessageSourceUtil messageSource;

    @Value("${app.mail.from}")
    private String fromEmail;

    @Override
    @Async
    public void sendVerificationEmail(String to, String verificationLink, Locale locale) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

            Context context = new Context(locale);
            context.setVariable("verificationLink", verificationLink);

            String content = templateEngine.process("verification-email", context);

            helper.setFrom(fromEmail);
            helper.setTo(to);
            helper.setSubject(messageSource.getMessage("email.verification.subject"));
            helper.setText(content, true);

            mailSender.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException("Failed to send verification email", e);
        }
    }
}
