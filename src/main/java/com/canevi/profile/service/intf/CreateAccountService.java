package com.canevi.profile.service.intf;

import java.util.Date;

import com.canevi.profile.domain.request.RequestCreateAccount;
import com.canevi.profile.domain.response.BaseResponse;
import com.canevi.profile.domain.response.ResponseAccount;

public interface CreateAccountService {
    ResponseAccount createAccount(RequestCreateAccount request);
    BaseResponse validateAccount(Long id, Date date);
}
