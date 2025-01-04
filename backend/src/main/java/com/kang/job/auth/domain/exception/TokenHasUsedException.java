package com.kang.job.auth.domain.exception;

import com.kang.job.common.exception.ServiceException;

/**
 * @author kanghouchao
 */
public class TokenHasUsedException extends ServiceException {
    public TokenHasUsedException(String message) {
        super(message);
    }
}
