package com.kang.jobprofile.mail.model;

/**
 * @author kanghouchao
 */
public class MailFactory {

    public static Mail createRegistrationMail(String from, String to, String content) {
        return new Mail(from, to, new Subject(""), content);
    }
}
