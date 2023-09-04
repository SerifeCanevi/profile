package com.canevi.profile.service.exception;

public class InvalidAccountRoleException extends Exception {
    public static String message = "Invalid account role";
    
    public InvalidAccountRoleException() {
        super(message);
    }
}
