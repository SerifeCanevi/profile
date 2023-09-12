package com.canevi.profile.service.intf.email;

import java.util.concurrent.TimeoutException;

import org.thymeleaf.context.Context;

import jakarta.mail.MessagingException;

public interface EmailService {
    void sendHtmlEmail(String to, String subject, String templateName, String token, Context context)
            throws MessagingException, InterruptedException, TimeoutException;

    void sendEmail(String email, String title, String templateName, String token)
            throws MessagingException, InterruptedException, TimeoutException;
}
