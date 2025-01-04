package com.kang.job.auth.mail.model;

/**
 * @author kanghouchao
 */
public interface Mail {

    public From getFrom();

    public To getTo();

    public Subject getSubject();

    public Content getContent();

}
