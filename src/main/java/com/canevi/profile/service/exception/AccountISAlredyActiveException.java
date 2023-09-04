package com.canevi.profile.service.exception;

public class AccountISAlredyActiveException extends RuntimeException {
    public static String message = "This account is already active";

    public AccountISAlredyActiveException() {
        super(message);
    }
}
