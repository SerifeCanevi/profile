package com.canevi.profile.service.exception;

public class EmailException extends RuntimeException {
    public static String message = "Email cannot be changed";

    public EmailException() {
        super(message);
    }
}
