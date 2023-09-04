package com.canevi.profile.service.exception;

public class AccountNotFoundException extends RuntimeException {
    public static String message = "Account not found";

    public AccountNotFoundException() {
        super(message);
    }
}
