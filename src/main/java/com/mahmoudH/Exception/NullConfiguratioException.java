package com.mahmoudH.Exception;

public class NullConfiguratioException extends RuntimeException {
    public NullConfiguratioException() {
    }

    public NullConfiguratioException(String message) {
        super(message);
    }

    public NullConfiguratioException(String message, Throwable cause) {
        super(message, cause);
    }

    public NullConfiguratioException(Throwable cause) {
        super(cause);
    }
}
