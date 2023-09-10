package com.canevi.profile.util.validator;

import org.springframework.beans.factory.annotation.Autowired;

import com.canevi.profile.dao.repository.AccountRepository;
import com.canevi.profile.domain.dto.AccountDTO;
import com.canevi.profile.util.annotation.ValidEmail;
import com.canevi.profile.util.annotation.ValidPassword;

import jakarta.validation.Valid;

public class AccountValidator {
    @Autowired
    private AccountRepository accountRepository;

    public void validateRequestCreateAccount(@Valid AccountDTO request) {
    }

    public void validateAccountDTO(@Valid AccountDTO request) {
    }

    public void validateEmail(@ValidEmail String email) {
    }

    public void validatePassword(@ValidPassword String password) {
    }

    public void validateAccountRole(@Valid String role) {
    }

    public void validateUsername(String value) {
    }
}
