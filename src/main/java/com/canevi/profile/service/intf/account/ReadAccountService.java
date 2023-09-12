package com.canevi.profile.service.intf.account;

import com.canevi.profile.domain.request.AccountRequest;
import com.canevi.profile.domain.request.AccountUsernameRequest;
import com.canevi.profile.domain.response.AccountResponse;

public interface ReadAccountService {
    AccountResponse getAccountById(AccountRequest request);
    AccountResponse getAccountByUsername(AccountUsernameRequest request);
}
