package com.canevi.profile.service.exception;

public class TimeoutException extends RuntimeException {
    public static String message = "This request is expired";

    public TimeoutException() {
        super(message);
    }
}
