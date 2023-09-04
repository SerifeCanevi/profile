package com.canevi.profile.service.impl;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.canevi.profile.dao.model.Account;
import com.canevi.profile.dao.repository.AccountRepository;
import com.canevi.profile.domain.mapper.AccountMapper;
import com.canevi.profile.domain.request.RequestAccountId;
import com.canevi.profile.domain.request.RequestAccountUsername;
import com.canevi.profile.domain.response.ResponseAccount;
import com.canevi.profile.domain.response.ResponseAccountRole;
import com.canevi.profile.domain.response.ResponseAccountStatus;
import com.canevi.profile.service.exception.AccountNotFoundException;
import com.canevi.profile.service.intf.ReadAccountService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReadAccountServiceImpl implements ReadAccountService {

    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;

    @Override
    public ResponseAccount getAccountById(RequestAccountId request) {
        ResponseAccount response = new ResponseAccount();
        Account account = null;
        try {
            account = accountRepository.findById(request.getAccountId())
                    .orElseThrow(() -> new AccountNotFoundException());
        } catch (Exception e) {
            response.setMessage(e.getMessage());
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            return response;
        }
        response.setAccount(accountMapper.convertAccountToAccountDTO(account));
        return response;
    }

    @Override
    public ResponseAccount getAccountByUsername(RequestAccountUsername request) {
        ResponseAccount response = new ResponseAccount();
        Account account = null;
        try {
            account = accountRepository.findByUsername(request.getUsername())
                    .orElseThrow(() -> new AccountNotFoundException());
        } catch (Exception e) {
            response.setMessage(e.getMessage());
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            return response;
        }
        response.setAccount(accountMapper.convertAccountToAccountDTO(account));
        return response;
    }

    @Override
    public ResponseAccountStatus getAccountStatus(RequestAccountId request) {
        ResponseAccountStatus response = new ResponseAccountStatus();
        String status = null;
        try {
            status = accountRepository.getAccountStatusById(request.getAccountId())
                    .orElseThrow(() -> new AccountNotFoundException());
        } catch (Exception e) {
            response.setMessage(e.getMessage());
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            return response;
        }
        response.setAccountStatus(status);
        return response;
    }

    @Override
    public ResponseAccountRole getAccountRole(RequestAccountId request) {
        ResponseAccountRole response = new ResponseAccountRole();
        String role = null;
        try {
            role = accountRepository.getRoleById(request.getAccountId())
                    .orElseThrow(() -> new AccountNotFoundException());
        } catch (Exception e) {
            response.setMessage(e.getMessage());
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            return response;
        }
        response.setAccountRole(role);
        return response;
    }

}
