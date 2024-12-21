package com.kang.job.auth.exception;

import com.kang.job.exception.ServiceException;

/**
 * @author kanghouchao
 */
public class TokenNotExistedException extends ServiceException {
    public TokenNotExistedException(String message) {
        super(message);
    }
}
