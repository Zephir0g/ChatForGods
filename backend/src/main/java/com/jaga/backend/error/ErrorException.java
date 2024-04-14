package com.jaga.backend.error;

import lombok.Getter;
import org.springframework.http.HttpStatus;

public class ErrorException extends Exception {
    @Getter
    private String destination;
    private int status;

    public ErrorException(String message, String destination, int status) {
        super(message);
        this.destination = destination;
        this.status = status;
    }

    public ErrorException(String message, Throwable cause) {
        super(message, cause);
    }

    public ErrorException(Throwable cause) {
        super(cause);
    }

    public ErrorException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }


}
