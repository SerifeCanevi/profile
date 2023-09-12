package com.canevi.profile.service.impl.account;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.canevi.profile.dao.model.Account;
import com.canevi.profile.dao.repository.AccountRepository;
import com.canevi.profile.domain.mapper.AccountMapper;
import com.canevi.profile.domain.request.AccountRequest;
import com.canevi.profile.domain.request.AccountEmailRequest;
import com.canevi.profile.domain.request.AccountUpdatePasswordRequest;
import com.canevi.profile.domain.request.AccountUsernameRequest;
import com.canevi.profile.domain.response.BaseResponse;
import com.canevi.profile.domain.response.AccountResponse;
import com.canevi.profile.service.exception.AccountNotFoundException;
import com.canevi.profile.service.exception.PasswordException;
import com.canevi.profile.service.intf.account.UpdateAccountService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UpdateAccountServiceImpl implements UpdateAccountService {
    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;

    private final String ACCOUNT_DELETED = "Account deleted";
    private final String ACCOUNT_UPDATED = "Account updated";

    @Override
    public AccountResponse changeEmail(AccountEmailRequest request) throws AccountNotFoundException {
        Account account = getAccountById(request.getAccountId());
        request.validate(account.getEmail());
        account.setEmail(request.getEmail());
        return new AccountResponse(accountMapper.genereateAccountDTOFromAccount(account),
                ACCOUNT_UPDATED, HttpStatus.CREATED);
    }

    @Override
    public AccountResponse changeUsername(AccountUsernameRequest request) throws AccountNotFoundException {
        Account account = getAccountById(request.getAccountId());
        request.validate(account.getUsername());
        account.setUsername(request.getUsername());
        return new AccountResponse(accountMapper.genereateAccountDTOFromAccount(account),
                ACCOUNT_UPDATED, HttpStatus.CREATED);
    }

    @Override
    public AccountResponse changePassword(AccountUpdatePasswordRequest request)
            throws AccountNotFoundException, PasswordException {
        Account account = getAccountById(request.getAccountId());
        request.validate(account.getPassword());
        account.setPassword(request.getNewPassword());
        return new AccountResponse(accountMapper.genereateAccountDTOFromAccount(account),
                ACCOUNT_UPDATED, HttpStatus.CREATED);
    }

    @Override
    public BaseResponse deleteAccount(AccountRequest request)
            throws AccountNotFoundException {
        /// TODO
        return new BaseResponse(ACCOUNT_DELETED);
    }
    
    private Account getAccountById(Long id) {
        return accountRepository.findById(id).orElseThrow(() -> new AccountNotFoundException());
    }
}
