package com.canevi.profile.service.impl.accountrole;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.canevi.profile.dao.model.AccountRole;
import com.canevi.profile.dao.repository.AccountRoleRepository;
import com.canevi.profile.domain.enums.Role;
import com.canevi.profile.service.intf.accountrole.AccountRoleService;

@ExtendWith(MockitoExtension.class)
class AccountRoleServiceTest {
    AccountRoleService accountRoleService;
    @Mock
    AccountRoleRepository accountRoleRepository;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        accountRoleService = new AccountRoleServiceImpl(accountRoleRepository);
    }
    @Test
    void test_createAccountRole() {
        Long accountId = 1L;
        Role role = Role.ADMIN;
        AccountRole accountRole = new AccountRole();
        when(accountRoleRepository.save(any())).thenReturn(accountRole);
        assertNotNull(accountRoleService.createAccountRole(accountId, role));
    }
    @Test
    void test_getAccountRoleByAccountId() {
        Long accountId = 1L;
        Optional<List<AccountRole>> accountRoleList = Optional.of(List.of(new AccountRole()));
        when(accountRoleRepository.findByAccountId(accountId)).thenReturn(accountRoleList);
        assertNotNull(accountRoleService.getAccountRoleByAccountId(accountId));
    }
}
