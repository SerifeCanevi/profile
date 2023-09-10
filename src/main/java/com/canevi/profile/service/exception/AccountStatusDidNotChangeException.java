package com.canevi.profile.service.exception;

public class AccountStatusDidNotChangeException extends RuntimeException {
    public static String message = "Account status did not change";

    public AccountStatusDidNotChangeException() {
        super(message);
    }
}
