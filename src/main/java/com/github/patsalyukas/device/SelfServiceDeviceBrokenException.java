package com.github.patsalyukas.device;

public class SelfServiceDeviceBrokenException extends Exception {

    public SelfServiceDeviceBrokenException() {
    }

    public SelfServiceDeviceBrokenException(String message) {
        super(message);
    }

    public SelfServiceDeviceBrokenException(String message, Throwable cause) {
        super(message, cause);
    }

    public SelfServiceDeviceBrokenException(Throwable cause) {
        super(cause);
    }

    public SelfServiceDeviceBrokenException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }


}
