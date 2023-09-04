package com.canevi.profile.service.exception;

public class AccountInActiveOrNotExistException extends RuntimeException {
    public static String message = "This user is not exist or inactive";

    public AccountInActiveOrNotExistException() {
        super(message);
    }
}
