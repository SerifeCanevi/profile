package com.canevi.profile.service.intf;

import com.canevi.profile.domain.request.RequestAccountId;
import com.canevi.profile.domain.request.RequestAccountUsername;
import com.canevi.profile.domain.response.ResponseAccount;
import com.canevi.profile.domain.response.ResponseAccountRole;
import com.canevi.profile.domain.response.ResponseAccountStatus;

public interface ReadAccountService {
    ResponseAccount getAccountById(RequestAccountId request);
    ResponseAccount getAccountByUsername(RequestAccountUsername request);
    ResponseAccountStatus getAccountStatus(RequestAccountId request);
    ResponseAccountRole getAccountRole(RequestAccountId request);
}
