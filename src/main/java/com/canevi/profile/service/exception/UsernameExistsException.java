package com.canevi.profile.service.exception;

public class UsernameExistsException extends RuntimeException {
    public static String message = "Username already exists";

    public UsernameExistsException() {
        super(message);
    }
}
