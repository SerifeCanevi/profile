package com.canevi.profile.service.impl.account;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.canevi.profile.dao.model.Account;
import com.canevi.profile.dao.repository.AccountRepository;
import com.canevi.profile.domain.mapper.AccountMapper;
import com.canevi.profile.domain.request.AccountCreateRequest;
import com.canevi.profile.domain.response.AccountResponse;
import com.canevi.profile.service.intf.account.CreateAccountService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CreateAccountServiceImpl implements CreateAccountService {
    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;

    private final String ACCOUNT_CREATED = "Account created";

    @Override
    public AccountResponse createAccount(AccountCreateRequest request) {
        Account account = saveAccount(request);
        return new AccountResponse(accountMapper.genereateAccountDTOFromAccount(account),
                ACCOUNT_CREATED, HttpStatus.CREATED);
    }

    private Account saveAccount(AccountCreateRequest request) {
        Account account = accountMapper.genereateAccountFromAccountCreateRequest(request);
        return accountRepository.save(account);
    }
}
