package com.mahmoudH.Exception;

public class HTTPConfigrationException extends RuntimeException{
    public HTTPConfigrationException() {
    }

    public HTTPConfigrationException(String message) {
        super(message);
    }

    public HTTPConfigrationException(String message, Throwable cause) {
        super(message, cause);
    }

    public HTTPConfigrationException(Throwable cause) {
        super(cause);
    }
}
