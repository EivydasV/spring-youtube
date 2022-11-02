package com.project.youtube.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class UniqueConstrainsException extends RuntimeException {
    public UniqueConstrainsException() {
        super();
    }

    public UniqueConstrainsException(String message, Throwable cause) {
        super(message, cause);
    }

    public UniqueConstrainsException(Throwable cause) {
        super(cause);
    }

    protected UniqueConstrainsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public UniqueConstrainsException(String message) {
        super(message);
    }

}
