package com.canevi.profile.service.intf.account;

import javax.security.auth.login.AccountNotFoundException;

import com.canevi.profile.domain.request.AccountRequest;
import com.canevi.profile.domain.request.AccountEmailRequest;
import com.canevi.profile.domain.request.AccountUpdatePasswordRequest;
import com.canevi.profile.domain.request.AccountUsernameRequest;
import com.canevi.profile.domain.response.BaseResponse;
import com.canevi.profile.domain.response.AccountResponse;
import com.canevi.profile.service.exception.PasswordException;

public interface UpdateAccountService {
    AccountResponse changeEmail(AccountEmailRequest request) throws AccountNotFoundException;

    AccountResponse changeUsername(AccountUsernameRequest request) throws AccountNotFoundException;

    AccountResponse changePassword(AccountUpdatePasswordRequest request)
            throws AccountNotFoundException, PasswordException;

    BaseResponse deleteAccount(AccountRequest request) throws AccountNotFoundException;
}
