package com.canevi.profile.service.impl.email;

import java.util.concurrent.TimeoutException;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import com.canevi.profile.service.intf.email.EmailService;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {
    private final JavaMailSender javaMailSender;
    private final TemplateEngine templateEngine;

    @Override
    public void sendHtmlEmail(String to, String subject, String templateName, String token, Context context)
            throws MessagingException, InterruptedException, TimeoutException {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setTo(to);
        helper.setSubject(subject);

        String htmlContent = templateEngine.process(templateName, context);
        String newHtmlContent = htmlContent.replaceAll("token", token);
        helper.setText(newHtmlContent, true);

        javaMailSender.send(message);
    }

    @Override
    public void sendEmail(String email, String title, String templateName, String token) 
        throws MessagingException, InterruptedException, TimeoutException {
        
        Context context = new Context();
        context.setVariable("name", "John");

        sendHtmlEmail(email, title, templateName, token, context);
    }
}