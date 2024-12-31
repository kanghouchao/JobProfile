package com.kang.job.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author kanghouchao
 */
@ResponseStatus(HttpStatus.CONFLICT)
public class ServiceException extends RuntimeException {

    public ServiceException() {
        super();
    }

    public ServiceException(String message) {
        super(message);
    }

}
