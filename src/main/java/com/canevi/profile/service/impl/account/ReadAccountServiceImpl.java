package com.canevi.profile.service.impl.account;

import org.springframework.stereotype.Service;

import com.canevi.profile.dao.model.Account;
import com.canevi.profile.dao.repository.AccountRepository;
import com.canevi.profile.domain.mapper.AccountMapper;
import com.canevi.profile.domain.request.AccountRequest;
import com.canevi.profile.domain.request.AccountUsernameRequest;
import com.canevi.profile.domain.response.AccountResponse;
import com.canevi.profile.service.exception.AccountNotFoundException;
import com.canevi.profile.service.intf.account.ReadAccountService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReadAccountServiceImpl implements ReadAccountService {

    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;

    @Override
    public AccountResponse getAccountById(AccountRequest request) {
        Account account = accountRepository.findById(request.getAccountId())
                .orElseThrow(() -> new AccountNotFoundException());
        return new AccountResponse(accountMapper.genereateAccountDTOFromAccount(account));
    }

    @Override
    public AccountResponse getAccountByUsername(AccountUsernameRequest request) {
        Account account = accountRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new AccountNotFoundException());
        return new AccountResponse(accountMapper.genereateAccountDTOFromAccount(account));
    }
}
