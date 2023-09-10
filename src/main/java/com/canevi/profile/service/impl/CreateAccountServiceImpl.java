package com.canevi.profile.service.impl;

import org.springframework.stereotype.Service;
import com.canevi.profile.dao.repository.AccountRepository;
import com.canevi.profile.domain.mapper.AccountMapper;
import com.canevi.profile.domain.request.RequestCreateAccount;
import com.canevi.profile.domain.response.BaseResponse;
import com.canevi.profile.domain.response.ResponseAccount;
import com.canevi.profile.service.intf.CreateAccountService;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class CreateAccountServiceImpl implements CreateAccountService {
    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;

    private final String ACCOUNT_CREATED = "Account created";
    private final String ACCOUNT_VALIDATED = "Account validated";
    @Override
    public ResponseAccount createAccount(RequestCreateAccount request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createAccount'");
    }
    @Override
    public BaseResponse validateAccount(Long id, Date date) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'validateAccount'");
    }
}
