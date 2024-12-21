package com.kang.job.auth.exception;

import com.kang.job.exception.ServiceException;

/**
 * @author kanghouchao
 */
public class TokenHasUsedException extends ServiceException {
    public TokenHasUsedException(String message) {
        super(message);
    }
}
