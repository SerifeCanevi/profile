package com.canevi.profile.service.impl;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.canevi.profile.dao.model.Account;
import com.canevi.profile.dao.repository.AccountRepository;
import com.canevi.profile.domain.enums.AccountRole;
import com.canevi.profile.domain.enums.AccountStatus;
import com.canevi.profile.domain.mapper.AccountMapper;
import com.canevi.profile.domain.request.RequestCreateAccount;
import com.canevi.profile.domain.response.BaseResponse;
import com.canevi.profile.domain.response.ResponseAccount;
import com.canevi.profile.service.exception.AccountNotFoundException;
import com.canevi.profile.service.exception.TimeoutException;
import com.canevi.profile.service.intf.CreateAccountService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CreateAccountServiceImpl implements CreateAccountService {
    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;

    @Override
    public ResponseAccount createAccount(RequestCreateAccount request) {
        ResponseAccount response = new ResponseAccount();
        Account account = accountMapper.convertAccountDTOToAccount(request.getAccount());
        account.setStatus(AccountStatus.ACTIVE);
        account.setRole(AccountRole.NOT_VERIFIED);
        account = accountRepository.save(account);
        response.setStatus(HttpStatus.CREATED);
        response.setMessage("Account created");
        response.setAccount(accountMapper.convertAccountToAccountDTO(account));
        return response;
    }

    @Override
    public BaseResponse validateAccount(Long id ,Date date) {
        BaseResponse response = new BaseResponse();
        Account account = accountRepository.findById(id)
            .orElseThrow(() -> new AccountNotFoundException());
        if(new Date().getTime() - date.getTime() > 5*60*1000){
            throw new TimeoutException();
        }
        account.setRole(AccountRole.USER);
        accountRepository.save(account);
        response.setMessage("Account validated");
        return response;
    }
}
