package com.canevi.profile.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.canevi.profile.domain.request.AccountCreateRequest;
import com.canevi.profile.domain.response.AccountResponse;
import com.canevi.profile.domain.response.BaseResponse;
import com.canevi.profile.service.orchestration.CreateAccountOrchestrationService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/account", produces = "application/json")
public class CreateAccountController {
    private final CreateAccountOrchestrationService createAccountService;

    @PostMapping(path = "/create")
    public AccountResponse createAccount(@RequestBody AccountCreateRequest request) {
        return createAccountService.createAccount(request);
    }

    @PostMapping(path = "/validate")
    public BaseResponse validateAccount(@RequestBody String token) {
        return createAccountService.validateAccount(token);
    }
}
