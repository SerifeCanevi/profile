package com.canevi.profile.service.exception;

public class EmailExistsException extends RuntimeException {
    public static String message = "Email already exists";

    public EmailExistsException() {
        super(message);
    }
}
