package com.canevi.profile.service.intf;

import com.canevi.profile.domain.request.RequestAccountId;
import com.canevi.profile.domain.request.RequestUpdateAccount;
import com.canevi.profile.domain.request.RequestUpdateAccountRole;
import com.canevi.profile.domain.response.BaseResponse;
import com.canevi.profile.domain.response.ResponseAccount;

public interface UpdateAccountService {
    ResponseAccount updateAccount(RequestUpdateAccount request);
    BaseResponse deleteAccount(RequestAccountId request);
    ResponseAccount updateAccountRole(RequestUpdateAccountRole request);
    ResponseAccount updateAccountStatusPassiveToActive(RequestAccountId request);
}
