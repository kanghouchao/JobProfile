package com.kang.jobprofile.i18n.infrastructure;

import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

/**
 * @author kanghouchao
 */
@RequiredArgsConstructor
public class ResourceBundleHandler {

    private final MessageSource messageSource;

    public String getMessage(String code, Object... args) {
        return this.messageSource.getMessage(code, args, LocaleContextHolder.getLocale());
    }

    public String getRegistrationMailSubject() {
        return this.getMessage("registration.mail.subject");
    }

    public String getRegistrationMailGreeting() {
        return this.getMessage("registration.mail.greeting");
    }

    public String getRegistrationMailBody() {
        return this.getMessage("registration.mail.body");
    }

    public String getRegistrationMailNotice() {
        return this.getMessage("registration.mail.notice");
    }

    public String getRegistrationMailFooter() {
        return this.getMessage("registration.mail.footer");
    }

    public String getRegistrationMailTitle() {
        return this.getMessage("registration.mail.title");
    }

    public String getRegistrationMailButton() {
        return this.getMessage("registration.mail.button");
    }
}
