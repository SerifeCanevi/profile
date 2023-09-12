package com.canevi.profile.service.orchestration;

import org.springframework.stereotype.Service;

import com.canevi.profile.service.impl.email.AccountRelatedEmailServiceImpl;
import com.canevi.profile.service.intf.account.UpdateAccountService;
import com.canevi.profile.util.generate.TokenGenerator;
import com.canevi.profile.util.validator.AccountValidator;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UpdateAccountOrchestrationService {
    private final TokenGenerator tokenGenerator;
    private final AccountValidator accountValidator;
    private final UpdateAccountService updateAccountService;
    private final AccountRelatedEmailServiceImpl accountRelatedEmailService;
}
