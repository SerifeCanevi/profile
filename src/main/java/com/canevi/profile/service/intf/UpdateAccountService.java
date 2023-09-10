package com.canevi.profile.service.intf;

import javax.security.auth.login.AccountNotFoundException;

import com.canevi.profile.domain.request.RequestAccountId;
import com.canevi.profile.domain.request.RequestUpdateAccount;
import com.canevi.profile.domain.response.BaseResponse;
import com.canevi.profile.domain.response.ResponseAccount;

public interface UpdateAccountService {
    ResponseAccount changeEmail(RequestUpdateAccount request) throws AccountNotFoundException;

    ResponseAccount changeUsername(RequestUpdateAccount request) throws AccountNotFoundException;

    ResponseAccount changePassword(RequestUpdateAccount request) throws AccountNotFoundException;

    BaseResponse deleteAccount(RequestAccountId request) throws AccountNotFoundException;
}
