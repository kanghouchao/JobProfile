package com.kang.jobprofile.mail.model;

/**
 * @author kanghouchao
 */
public record Mail(String from, String to, Subject subject, Content content) {

}
