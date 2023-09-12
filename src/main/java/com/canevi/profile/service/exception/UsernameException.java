package com.canevi.profile.service.exception;

public class UsernameException extends RuntimeException {
    public static String message = "Username cannot be changed";

    public UsernameException() {
        super(message);
    }
}
