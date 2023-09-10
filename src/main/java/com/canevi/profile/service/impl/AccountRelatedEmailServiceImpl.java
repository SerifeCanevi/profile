package com.canevi.profile.service.impl;

import java.util.concurrent.TimeoutException;

import org.springframework.stereotype.Service;

import com.canevi.profile.dao.model.Account;
import com.canevi.profile.domain.dto.AccountDTO;
import com.canevi.profile.service.intf.EmailService;
import com.canevi.profile.util.message.EmailSender;

import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AccountRelatedEmailServiceImpl implements EmailSender {
    private final EmailService emailService;

    public void createAccount(AccountDTO accountDTO, String token) 
        throws MessagingException, InterruptedException, TimeoutException {
        sendEmail(accountDTO.getEmail(), "Welcome, " + accountDTO.getUsername(), "createAccount", token, emailService);
    }
}
