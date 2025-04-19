package com.kang.resume.user.auth.application.service;

import java.util.Locale;

public interface EmailService {
    void sendVerificationEmail(String to, String verificationLink, Locale locale);
}
