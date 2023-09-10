package com.canevi.profile.service.orchestration;

import org.springframework.stereotype.Service;

import com.canevi.profile.service.impl.AccountRelatedEmailServiceImpl;
import com.canevi.profile.service.intf.CreateAccountService;
import com.canevi.profile.util.generate.TokenGenerator;
import com.canevi.profile.util.validator.AccountValidator;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CreateAccountOrchestrationService {
    private final TokenGenerator tokenGenerator;
    private final AccountValidator accountValidator;
    private final CreateAccountService createAccountService;
    private final AccountRelatedEmailServiceImpl accountRelatedEmailService;
}
