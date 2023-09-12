package com.canevi.profile.service.intf.account;

import com.canevi.profile.domain.request.AccountCreateRequest;
import com.canevi.profile.domain.response.AccountResponse;

public interface CreateAccountService {
    AccountResponse createAccount(AccountCreateRequest request);
}
