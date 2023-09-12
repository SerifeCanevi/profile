package com.canevi.profile.service.impl.account;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.canevi.profile.dao.model.Account;
import com.canevi.profile.dao.repository.AccountRepository;
import com.canevi.profile.domain.mapper.AccountMapper;
import com.canevi.profile.domain.request.AccountCreateRequest;
import com.canevi.profile.domain.request.AccountCreateValidateRequest;
import com.canevi.profile.domain.response.BaseResponse;
import com.canevi.profile.domain.response.AccountResponse;
import com.canevi.profile.service.intf.account.CreateAccountService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CreateAccountServiceImpl implements CreateAccountService {
    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;

    private final String ACCOUNT_CREATED = "Account created";
    private final String ACCOUNT_VALIDATED = "Account validated";

    @Override
    public AccountResponse createAccount(AccountCreateRequest request) {
        Account account = saveAccount(request);
        return new AccountResponse(accountMapper.genereateAccountDTOFromAccount(account),
                ACCOUNT_CREATED, HttpStatus.CREATED);
    }

    @Override
    public BaseResponse validateAccount(AccountCreateValidateRequest request) {
        /// TODO
        return new BaseResponse(ACCOUNT_VALIDATED);
    }

    private Account saveAccount(AccountCreateRequest request) {
        Account account = accountMapper.genereateAccountFromAccountCreateRequest(request);
        return accountRepository.save(account);
    }
}
