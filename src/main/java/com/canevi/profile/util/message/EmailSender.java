package com.canevi.profile.util.message;

import java.util.concurrent.TimeoutException;

import org.thymeleaf.context.Context;

import com.canevi.profile.service.intf.EmailService;

import jakarta.mail.MessagingException;

public interface EmailSender {
    default void sendEmail(String email, String title, String templateName, String token, EmailService emailService) 
        throws MessagingException, InterruptedException, TimeoutException {
        
        Context context = new Context();
        context.setVariable("name", "John");

        emailService.sendHtmlEmail(email, title, templateName, token, context);
    }
}
