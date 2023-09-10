package com.canevi.profile.service.impl;

import javax.security.auth.login.AccountNotFoundException;

import org.springframework.stereotype.Service;
import com.canevi.profile.dao.repository.AccountRepository;
import com.canevi.profile.domain.mapper.AccountMapper;
import com.canevi.profile.domain.request.RequestAccountId;
import com.canevi.profile.domain.request.RequestUpdateAccount;
import com.canevi.profile.domain.response.BaseResponse;
import com.canevi.profile.domain.response.ResponseAccount;
import com.canevi.profile.service.intf.UpdateAccountService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UpdateAccountServiceImpl implements UpdateAccountService {
    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;

    private final String ACCOUNT_DELETED = "Account deleted";
    private final String ACCOUNT_UPDATED = "Account updated";
    @Override
    public ResponseAccount changeEmail(RequestUpdateAccount request) throws AccountNotFoundException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'changeEmail'");
    }
    @Override
    public ResponseAccount changeUsername(RequestUpdateAccount request) throws AccountNotFoundException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'changeUsername'");
    }
    @Override
    public ResponseAccount changePassword(RequestUpdateAccount request) throws AccountNotFoundException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'changePassword'");
    }
    @Override
    public BaseResponse deleteAccount(RequestAccountId request) throws AccountNotFoundException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteAccount'");
    }
}
