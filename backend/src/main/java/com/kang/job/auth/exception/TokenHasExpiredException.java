package com.kang.job.auth.exception;

import com.kang.job.exception.ServiceException;

/**
 * @author kanghouchao
 */
public class TokenHasExpiredException extends ServiceException {
    public TokenHasExpiredException(String message) {
        super(message);
    }
}
