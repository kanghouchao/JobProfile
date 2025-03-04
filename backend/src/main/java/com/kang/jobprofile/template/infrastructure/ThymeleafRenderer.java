package com.kang.jobprofile.template.infrastructure;

import com.kang.jobprofile.i18n.infrastructure.ResourceBundleHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.context.i18n.LocaleContextHolder;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.HashMap;
import java.util.Map;

/**
 * @author kanghouchao
 */
@RequiredArgsConstructor
public class ThymeleafRenderer {

    private final TemplateEngine templateEngine;

    private final ResourceBundleHandler resourceBundleHandler;

    public String render(String templateName, Map<String, Object> model) {
        Context context = new Context();
        context.setVariables(model);
        return templateEngine.process(templateName, context);
    }

    public String getRegistrationMailCount(String link) {
        final Map<String, Object> model = new HashMap<>();
        model.put("lang", LocaleContextHolder.getLocale().getLanguage());
        model.put("subject", resourceBundleHandler.getRegistrationMailSubject());
        model.put("title", resourceBundleHandler.getRegistrationMailTitle());
        model.put("greeting", resourceBundleHandler.getRegistrationMailGreeting());
        model.put("body", resourceBundleHandler.getRegistrationMailBody());
        model.put("link", link);
        model.put("button", resourceBundleHandler.getRegistrationMailButton());
        model.put("notice", resourceBundleHandler.getRegistrationMailNotice());
        model.put("footer", resourceBundleHandler.getRegistrationMailFooter());
        return this.render("registration-mail-template", model);
    }
}
