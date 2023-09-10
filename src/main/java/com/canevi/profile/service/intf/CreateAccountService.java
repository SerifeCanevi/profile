package com.canevi.profile.service.intf;

import java.util.Date;

import com.canevi.profile.domain.response.BaseResponse;

public interface CreateAccountService {
    ResponseAccount createAccount(RequestCreateAccount request);
    BaseResponse validateAccount(Long id, Date date);
}
