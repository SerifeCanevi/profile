package com.canevi.profile.service.intf.accountrole;

import java.util.List;

import com.canevi.profile.dao.model.AccountRole;
import com.canevi.profile.domain.enums.Role;

public interface AccountRoleService {
    AccountRole createAccountRole(Long accountId, Role role);
    List<AccountRole> getAccountRoleByAccountId(Long accountId);
    boolean isAccountHasRole(Long accountId, Role role);
    boolean removeAccountRole(Long accountId, Role role);
}
