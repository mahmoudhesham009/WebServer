package com.mahmoudH.Exception;

public class NullConfigurationException extends RuntimeException {
    public NullConfigurationException() {
    }

    public NullConfigurationException(String message) {
        super(message);
    }

    public NullConfigurationException(String message, Throwable cause) {
        super(message, cause);
    }

    public NullConfigurationException(Throwable cause) {
        super(cause);
    }
}
