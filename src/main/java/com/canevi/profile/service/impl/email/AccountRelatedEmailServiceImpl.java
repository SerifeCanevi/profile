package com.canevi.profile.service.impl.email;

import java.util.concurrent.TimeoutException;

import org.springframework.stereotype.Service;

import com.canevi.profile.domain.dto.AccountDTO;
import com.canevi.profile.service.intf.email.EmailService;

import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AccountRelatedEmailServiceImpl {
    private final EmailService emailService;

    public void createAccount(AccountDTO accountDTO, String token) 
        throws MessagingException, InterruptedException, TimeoutException {
        emailService.sendEmail(accountDTO.getEmail(), "Welcome, " + accountDTO.getUsername(), "createAccount", token);
    }
}
