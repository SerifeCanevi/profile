package com.canevi.profile.service.impl.accountrole;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import com.canevi.profile.dao.model.AccountRole;
import com.canevi.profile.dao.repository.AccountRoleRepository;
import com.canevi.profile.domain.enums.Role;
import com.canevi.profile.service.intf.accountrole.AccountRoleService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AccountRoleServiceImpl implements AccountRoleService {
    private final AccountRoleRepository accountRoleRepository;
    @Override
    public AccountRole createAccountRole(Long accountId, Role role) {
        AccountRole accountRole = new AccountRole();
        accountRole.setAccountId(accountId);
        accountRole.setRole(role);
        return accountRoleRepository.save(accountRole);
    }
    @Override
    public List<AccountRole> getAccountRoleByAccountId(Long accountId) {
        return accountRoleRepository.findByAccountId(accountId).orElse(Collections.emptyList());
    }
    @Override
    public boolean isAccountHasRole(Long accountId, Role role) {
        return accountRoleRepository.findIfAccountHasRole(accountId, role.getDisplayName());
    }
    @Override
    public boolean removeAccountRole(Long accountId, Role role) {
        return accountRoleRepository.removeRoleFromAccount(accountId, role.getDisplayName());
    }
}
