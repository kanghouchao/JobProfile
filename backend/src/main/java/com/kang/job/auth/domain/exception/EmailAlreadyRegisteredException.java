package com.kang.job.auth.domain.exception;

import com.kang.job.common.exception.ServiceException;

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
