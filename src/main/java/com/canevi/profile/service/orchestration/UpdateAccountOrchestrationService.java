package com.canevi.profile.service.orchestration;

import org.springframework.stereotype.Service;

import com.canevi.profile.domain.request.RequestAccountId;
import com.canevi.profile.domain.request.RequestUpdateAccount;
import com.canevi.profile.domain.request.RequestUpdateAccountRole;
import com.canevi.profile.domain.response.BaseResponse;
import com.canevi.profile.domain.response.ResponseAccount;
import com.canevi.profile.service.impl.AccountRelatedEmailServiceImpl;
import com.canevi.profile.service.intf.UpdateAccountService;
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
    public ResponseAccount updateAccount(RequestUpdateAccount request) {
        return null;
    }

    public BaseResponse deleteAccount(RequestAccountId request) {
        return null;
    }

    public ResponseAccount updateAccountRole(RequestUpdateAccountRole request) {
        return null;
    }

    public ResponseAccount updateAccountStatusPassiveToActive(RequestAccountId request) {
        return null;
    }

}
