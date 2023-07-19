package com.daonplace.springbootweb.handler.ex;

public class NotMatchException extends RuntimeException {

    public NotMatchException() {
        super();
    }

    public NotMatchException(String message) {
        super(message);
    }

    public NotMatchException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotMatchException(Throwable cause) {
        super(cause);
    }

}
