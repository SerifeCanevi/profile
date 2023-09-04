package com.canevi.profile.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.canevi.profile.domain.request.RequestCreateAccount;
import com.canevi.profile.domain.request.RequestAccountId;
import com.canevi.profile.domain.request.RequestAccountUsername;
import com.canevi.profile.domain.request.RequestUpdateAccount;
import com.canevi.profile.domain.request.RequestUpdateAccountRole;
import com.canevi.profile.domain.response.BaseResponse;
import com.canevi.profile.domain.response.ResponseAccount;
import com.canevi.profile.domain.response.ResponseAccountRole;
import com.canevi.profile.domain.response.ResponseAccountStatus;
import com.canevi.profile.service.intf.ReadAccountService;
import com.canevi.profile.service.orchestration.CreateAccountOrchestrationService;
import com.canevi.profile.service.orchestration.UpdateAccountOrchestrationService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/account")
public class AccountController {
    private final ReadAccountService readAccountService;
    private final CreateAccountOrchestrationService createAccountOrchestrationService;
    private final UpdateAccountOrchestrationService updateAccountOrchestrationService;

    @GetMapping("/getAccountById")
    public ResponseAccount getAccountById(@RequestBody RequestAccountId request) {
        return readAccountService.getAccountById(request);
    }

    @GetMapping("/getAccountByUsername")
    public ResponseAccount getAccountByUsername(@RequestBody RequestAccountUsername request) {
        return readAccountService.getAccountByUsername(request);
    }

    @PostMapping("/createAccount")
    public BaseResponse createAccount(@RequestBody RequestCreateAccount request) {
        return createAccountOrchestrationService.createAccount(request);
    }
    
    @GetMapping("/validateCreatedAccount/{token}")
    public String validateCreatedAccount(@PathVariable String token) {
        return createAccountOrchestrationService.validateAccount(token).getMessage();
    }

    @PutMapping("/updateAccount")
    public ResponseAccount updateAccount(@RequestBody RequestUpdateAccount request) {
        return updateAccountOrchestrationService.updateAccount(request);
    }

    @DeleteMapping("/deleteAccount")
    public BaseResponse deleteAccount(@RequestBody RequestAccountId request) {
        return updateAccountOrchestrationService.deleteAccount(request);
    }

    @GetMapping("/getAccountStatus")
    public ResponseAccountStatus getAccountStatus(@RequestBody RequestAccountId request) {
        return readAccountService.getAccountStatus(request);
    }

    @GetMapping("/getAccountRole")
    public ResponseAccountRole getAccountRole(@RequestBody RequestAccountId request) {
        return readAccountService.getAccountRole(request);
    }

    @PutMapping("/updateAccountRole")
    public ResponseAccount updateAccountRole(RequestUpdateAccountRole request) {
        return updateAccountOrchestrationService.updateAccountRole(request);
    }

    @PutMapping("/updateAccountStatusPassiveToActive")
    public ResponseAccount updateAccountStatusPassiveToActive(RequestAccountId request) {
        return updateAccountOrchestrationService.updateAccountStatusPassiveToActive(request);
    }
    @GetMapping("/emailChange/{change}/{token}")
    public String emailChange(@PathVariable("change") String change, @PathVariable("token") String token) {
        return "EmailChange has " + (change == "yes" ? "done" : "not done");
    }
}
