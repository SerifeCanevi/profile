package com.canevi.profile.service.orchestration;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.canevi.profile.domain.enums.Role;
import com.canevi.profile.domain.enums.Status;
import com.canevi.profile.domain.request.AccountCreateRequest;
import com.canevi.profile.domain.response.AccountResponse;
import com.canevi.profile.domain.response.BaseResponse;
import com.canevi.profile.service.impl.email.AccountRelatedEmailServiceImpl;
import com.canevi.profile.service.intf.account.CreateAccountService;
import com.canevi.profile.service.intf.accountrole.AccountRoleService;
import com.canevi.profile.service.intf.accountstatus.AccountStatusService;
import com.canevi.profile.util.generate.Token;
import com.canevi.profile.util.generate.TokenGenerator;
import com.canevi.profile.util.validator.AccountValidator;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class CreateAccountOrchestrationService {
    private final TokenGenerator tokenGenerator;
    private final AccountRoleService accountRoleService;
    private final AccountStatusService accountStatusService;
    private final CreateAccountService createAccountService;
    private final AccountValidator accountValidator;
    private final AccountRelatedEmailServiceImpl accountRelatedEmailService;

    private final String ACCOUNT_CREATION_FAILED = "Account creation failed";
    private final String ACCOUNT_VALIDATED = "Account validated";
    private final String ACCOUNT_VALIDATION_FAILED = "Account validation failed";

    public AccountResponse createAccount(AccountCreateRequest request) {
        try {
            AccountResponse response = createAccountService.createAccount(request);
            accountStatusService.createAccountStatus(response.getAccount().getAccountId(), Status.PENDING);
            Token token = new Token(response.getAccount().getAccountId().toString());
            String generatedToken = tokenGenerator.generateToken(token);
            accountRelatedEmailService.createAccount(response.getAccount(), generatedToken);
            return response;
        } catch (Exception e) {
            log.info(e.getMessage());
            return new AccountResponse(null,
                    ACCOUNT_CREATION_FAILED, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public BaseResponse validateAccount(String token) {
        try {
            Token decryptedToken = tokenGenerator.decryptToken(token);
            if (new Date().after(decryptedToken.getExpirationDate())) {
                return new BaseResponse(ACCOUNT_VALIDATION_FAILED);
            }
            Long accountId = Long.parseLong(decryptedToken.getData());
            accountValidator.validateAccount(accountId);
            accountStatusService.updateAccountStatus(accountId, Status.ACTIVE);
            accountRoleService.createAccountRole(accountId, Role.USER);
            return new BaseResponse(ACCOUNT_VALIDATED);
        } catch (Exception e) {
            log.info(e.getMessage());
            return new BaseResponse(ACCOUNT_VALIDATION_FAILED, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public List<AccountResponse> paralelCompletableFuture(AccountCreateRequest request) {
        try {
            List<AccountCreateRequest> list = Arrays.asList(request, request);
            List<CompletableFuture<AccountResponse>> futureList = list.stream().map(item -> 
                CompletableFuture.supplyAsync(() -> 
                    createAccountService.createAccount(item)))
            .toList();
            CompletableFuture<List<AccountResponse>> future = CompletableFuture
                    .allOf(futureList.toArray(new CompletableFuture[futureList.size()]))
                    .thenApply(a -> futureList.stream().map(CompletableFuture::join).toList());
            return future.get(10, TimeUnit.SECONDS);
        } catch (Exception e) {
            log.info(e.getMessage());
            return null;
        }
    }
}
