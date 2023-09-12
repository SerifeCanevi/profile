package com.canevi.profile.util.validator;

import org.springframework.beans.factory.annotation.Autowired;

import com.canevi.profile.dao.repository.AccountRepository;
import com.canevi.profile.service.exception.AccountNotFoundException;

public class AccountValidator {
    @Autowired
    private AccountRepository accountRepository;

    public void validateAccount(Long accountId) {
        accountRepository.findById(accountId)
                .orElseThrow(() -> new AccountNotFoundException());
    }
}
