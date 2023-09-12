package com.canevi.profile.service.exception;

public class PasswordException extends RuntimeException {
    public static String message = "Password cannot be changed";

    public PasswordException(String errorMessage) {
        super(message + ": " + errorMessage);
    }
}
