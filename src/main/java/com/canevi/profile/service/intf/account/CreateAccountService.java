package com.canevi.profile.service.intf.account;

import com.canevi.profile.domain.request.AccountCreateRequest;
import com.canevi.profile.domain.request.AccountCreateValidateRequest;
import com.canevi.profile.domain.response.AccountResponse;
import com.canevi.profile.domain.response.BaseResponse;

public interface CreateAccountService {
    AccountResponse createAccount(AccountCreateRequest request);
    BaseResponse validateAccount(AccountCreateValidateRequest request);
}
