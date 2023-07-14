package com.daonplace.springbootweb.handler.ex;

public class DuplicateAdminException extends RuntimeException {

    public DuplicateAdminException() {
        super();
    }

    public DuplicateAdminException(String message) {
        super(message);
    }

    public DuplicateAdminException(String message, Throwable cause) {
        super(message, cause);
    }

    public DuplicateAdminException(Throwable cause) {
        super(cause);
    }

}
