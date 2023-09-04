package com.canevi.profile.service.intf;

import java.util.concurrent.TimeoutException;

import org.thymeleaf.context.Context;

import com.canevi.profile.service.exception.AccountUpdateFailedException;

import jakarta.mail.MessagingException;

public interface EmailService {
    void sendHtmlEmail(String to, String subject, String templateName, String token, Context context) throws MessagingException, 
        InterruptedException, TimeoutException, AccountUpdateFailedException;
}
