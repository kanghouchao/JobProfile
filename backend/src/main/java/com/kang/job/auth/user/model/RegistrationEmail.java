package com.kang.job.auth.user.model;

import com.kang.job.auth.mail.model.Content;
import com.kang.job.auth.mail.model.From;
import com.kang.job.auth.mail.model.InternationalizationMail;
import com.kang.job.auth.mail.model.Subject;
import com.kang.job.auth.mail.model.To;
import jakarta.validation.constraints.NotNull;
import lombok.Value;

import java.util.Locale;

/**
 * @author kanghouchao
 */
@Value
public class RegistrationEmail implements InternationalizationMail {

    private RegistrationToken registrationToken;

    @NotNull
    private From from;

    @NotNull
    private To to;

    @NotNull
    private Subject subject;

    @NotNull
    private Content content;

    @NotNull
    private Locale locale;


    @Override
    public From getFrom() {
        return this.from;
    }

    @Override
    public To getTo() {
        return this.to;
    }

    @Override
    public Subject getSubject() {
        return this.subject;
    }

    @Override
    public Content getContent() {
        return this.content;
    }

    @Override
    public Locale getLocale() {
        return this.locale;
    }
}
