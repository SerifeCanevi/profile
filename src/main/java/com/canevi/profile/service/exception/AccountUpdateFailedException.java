package com.canevi.profile.service.exception;

public class AccountUpdateFailedException extends RuntimeException {
    public static String message = "Account update failed";

    public AccountUpdateFailedException() {
        super(message);
    }
}
