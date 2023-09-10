package com.canevi.profile.service.impl;

import org.springframework.stereotype.Service;
import com.canevi.profile.dao.repository.AccountRepository;
import com.canevi.profile.domain.mapper.AccountMapper;
import com.canevi.profile.domain.request.RequestAccountId;
import com.canevi.profile.domain.request.RequestAccountUsername;
import com.canevi.profile.domain.response.ResponseAccount;
import com.canevi.profile.domain.response.ResponseAccountRole;
import com.canevi.profile.domain.response.ResponseAccountStatus;
import com.canevi.profile.service.intf.ReadAccountService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReadAccountServiceImpl implements ReadAccountService {

    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;
    @Override
    public ResponseAccount getAccountById(RequestAccountId request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAccountById'");
    }
    @Override
    public ResponseAccount getAccountByUsername(RequestAccountUsername request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAccountByUsername'");
    }
    @Override
    public ResponseAccountStatus getAccountStatus(RequestAccountId request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAccountStatus'");
    }
    @Override
    public ResponseAccountRole getAccountRole(RequestAccountId request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAccountRole'");
    }

}
