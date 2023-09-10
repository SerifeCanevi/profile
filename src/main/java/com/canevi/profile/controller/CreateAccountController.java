package com.canevi.profile.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.canevi.profile.service.orchestration.CreateAccountOrchestrationService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/account")
public class CreateAccountController {
    private final CreateAccountOrchestrationService createAccountService;
}
