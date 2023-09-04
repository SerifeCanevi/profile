package com.canevi.profile.service.impl;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.canevi.profile.dao.model.Account;
import com.canevi.profile.dao.repository.AccountRepository;
import com.canevi.profile.domain.dto.AccountDTO;
import com.canevi.profile.domain.enums.AccountStatus;
import com.canevi.profile.domain.mapper.AccountMapper;
import com.canevi.profile.domain.request.RequestAccountId;
import com.canevi.profile.domain.request.RequestUpdateAccount;
import com.canevi.profile.domain.request.RequestUpdateAccountRole;
import com.canevi.profile.domain.response.BaseResponse;
import com.canevi.profile.domain.response.ResponseAccount;
import com.canevi.profile.service.exception.AccountISAlredyActiveException;
import com.canevi.profile.service.exception.AccountNotFoundException;
import com.canevi.profile.service.intf.UpdateAccountService;
import com.canevi.profile.util.validator.AccountValidator;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UpdateAccountServiceImpl implements UpdateAccountService {
    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;
    private final AccountValidator accountValidator;

    @Override
    public ResponseAccount updateAccount(RequestUpdateAccount request) {
        ResponseAccount response = new ResponseAccount();
        Account account = null;
        try {
            account = accountRepository.findById(request.getId())
                    .orElseThrow(() -> new AccountNotFoundException());
            AccountDTO accountDTO = request.getAccount();
            accountValidator.validateAccountDTO(request.getAccount());
            if (accountDTO.getUsername() != null) {
                account.setUsername(accountDTO.getUsername());
            }
            if (accountDTO.getPassword() != null) {
                account.setPassword(accountDTO.getPassword());
            }
            if (accountDTO.getEmail() != null) {
                account.setEmail(accountDTO.getEmail());
            }
            account = accountRepository.save(account);
        } catch (AccountISAlredyActiveException e) {
            response.setMessage(e.getMessage());
            response.setStatus(HttpStatus.NOT_FOUND);
            return response;
        } catch (Exception e) {
            response.setMessage(e.getMessage());
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            return response;
        }
        response.setStatus(HttpStatus.CREATED);
        response.setMessage("Account updated");
        response.setAccount(accountMapper.convertAccountToAccountDTO(account));
        return response;
    }

    @Override
    public BaseResponse deleteAccount(RequestAccountId request) {
        BaseResponse response = new BaseResponse();
        try {
            Account account = accountRepository.findById(request.getAccountId())
                    .orElseThrow(() -> new AccountNotFoundException());
            accountValidator.validateEmail(account.getEmail());
            account.setStatus(AccountStatus.PASSIVE);
            accountRepository.save(account);
        } catch (AccountISAlredyActiveException e) {
            response.setMessage(e.getMessage());
            response.setStatus(HttpStatus.NOT_FOUND);
            return response;
        } catch (Exception e) {
            response.setMessage(e.getMessage());
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            return response;
        }
        response.setMessage("Account deleted");
        return response;
    }

    @Override
    public ResponseAccount updateAccountRole(RequestUpdateAccountRole request) {
        ResponseAccount response = new ResponseAccount();
        Account account = null;
        try {
            account = accountRepository.findById(request.getAccountId())
                    .orElseThrow(() -> new AccountNotFoundException());
            accountValidator.validateAccountRole(request.getRole());
            account.setRole(request.getRole());
            account = accountRepository.save(account);
        } catch (AccountISAlredyActiveException e) {
            response.setMessage(e.getMessage());
            response.setStatus(HttpStatus.NOT_FOUND);
            return response;
        } catch (Exception e) {
            response.setMessage(e.getMessage());
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            return response;
        }
        response.setMessage("Account role updated");
        response.setAccount(accountMapper.convertAccountToAccountDTO(account));
        return response;
    }

    @Override
    public ResponseAccount updateAccountStatusPassiveToActive(RequestAccountId request) {
        ResponseAccount response = new ResponseAccount();
        Account account = null;
        try {
            account = accountRepository.findById(request.getAccountId())
                    .orElseThrow(() -> new AccountNotFoundException());
            if (account.getStatus().equals(AccountStatus.ACTIVE.toString())) {
                throw new AccountISAlredyActiveException();
            }
            
            account.setStatus(AccountStatus.ACTIVE);
            account = accountRepository.save(account);
        } catch (Exception e) {
            response.setMessage(e.getMessage());
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            return response;
        }
        response.setMessage("Account status updated to active");
        response.setAccount(accountMapper.convertAccountToAccountDTO(account));
        return response;
    }
}
