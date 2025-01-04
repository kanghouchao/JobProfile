package com.kang.job.auth.domain.exception;

import com.kang.job.common.exception.ServiceException;

/**
 * @author kanghouchao
 */
public class TokenHasExpiredException extends ServiceException {
    public TokenHasExpiredException(String message) {
        super(message);
    }
}
