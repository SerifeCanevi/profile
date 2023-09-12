package com.canevi.profile.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.canevi.profile.service.intf.account.ReadAccountService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/account")
public class ReadAccountController {
    private final ReadAccountService readAccountService;
}
