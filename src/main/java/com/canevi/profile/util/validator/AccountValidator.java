package com.canevi.profile.util.validator;

import org.springframework.beans.factory.annotation.Autowired;

import com.canevi.profile.dao.repository.AccountRepository;
import com.canevi.profile.domain.dto.AccountDTO;
import com.canevi.profile.domain.enums.AccountRole;
import com.canevi.profile.service.exception.AccountISAlredyActiveException;
import com.canevi.profile.service.exception.TimeoutException;
import com.canevi.profile.service.exception.InvalidAccountRoleException;
import com.canevi.profile.service.exception.UsernameExistsException;
import com.canevi.profile.util.annotation.ValidEmail;

import jakarta.validation.Valid;

public class AccountValidator {
    @Autowired
    private AccountRepository accountRepository;
    
    public void validateRequestCreateAccount(@Valid AccountDTO request) {
        String username = request.getUsername();
        String email = request.getEmail();
        
        validateEmail(email);
        if (accountRepository.checkUsername(username)) {
            throw new UsernameExistsException();
        }
        if (accountRepository.checkEmail(email)) {
            throw new TimeoutException();
        }
    }

    public void validateAccountDTO(@Valid AccountDTO request) {
        validateEmail(request.getEmail());
    }
    
    public void validateEmail(@ValidEmail String email) {
        if (accountRepository.checkIfPassiveUserByEmail(email)) {
            throw new AccountISAlredyActiveException();
        }
    }

    public void validateAccountRole(@Valid String role) throws InvalidAccountRoleException {
        for(AccountRole accountRole : AccountRole.values()) {
            if (accountRole.name().equals(role)) {
                return;
            }
        }
        throw new InvalidAccountRoleException();
    }
}
