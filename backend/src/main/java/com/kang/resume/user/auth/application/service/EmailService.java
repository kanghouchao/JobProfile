package com.kang.resume.user.auth.application.service;

import java.util.Locale;

public interface EmailService {
    /**
     * Sends a verification email to the specified recipient.
     *
     * @param to The recipient's email address.
     * @param verificationLink The verification link to be included in the email.
     * @param locale The locale to use for email content localization.
     */
    void sendVerificationEmail(final String to, final String verificationLink, final Locale locale);
}
