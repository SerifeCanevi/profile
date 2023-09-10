package com.canevi.profile.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.canevi.profile.domain.request.RequestAccountId;
import com.canevi.profile.domain.request.RequestAccountUsername;
import com.canevi.profile.domain.response.ResponseAccount;
import com.canevi.profile.domain.response.ResponseAccountRole;
import com.canevi.profile.domain.response.ResponseAccountStatus;
import com.canevi.profile.service.intf.ReadAccountService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/account")
public class ReadAccountController {
    private final ReadAccountService readAccountService;
    @GetMapping("/byId")
    public ResponseAccount getAccountById(@RequestBody RequestAccountId request) {
        return readAccountService.getAccountById(request);
    }

    @GetMapping("/byUsername")
    public ResponseAccount getAccountByUsername(@RequestBody RequestAccountUsername request) {
        return readAccountService.getAccountByUsername(request);
    }
    
    @GetMapping("/status")
    public ResponseAccountStatus getAccountStatus(@RequestBody RequestAccountId request) {
        return readAccountService.getAccountStatus(request);
    }

    @GetMapping("/role")
    public ResponseAccountRole getAccountRole(@RequestBody RequestAccountId request) {
        return readAccountService.getAccountRole(request);
    }
}
