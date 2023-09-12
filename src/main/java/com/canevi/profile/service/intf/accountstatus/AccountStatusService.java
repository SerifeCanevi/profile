package com.canevi.profile.service.intf.accountstatus;

import com.canevi.profile.dao.model.AccountStatus;
import com.canevi.profile.domain.enums.Status;

public interface AccountStatusService {
    AccountStatus getAccountStatusByAccountId(Long accountId);
    AccountStatus createAccountStatus(Long accountId, Status status);
    AccountStatus updateAccountStatus(Long accountId, Status status);
}
