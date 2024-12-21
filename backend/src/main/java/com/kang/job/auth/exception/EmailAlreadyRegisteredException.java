package com.kang.job.auth.exception;

import com.kang.job.exception.ServiceException;

/**
 * @author kanghouchao
 */
public class EmailAlreadyRegisteredException extends ServiceException {

    /**
     * @param message
     */
    public EmailAlreadyRegisteredException(String message) {
        super(message);
    }
}
