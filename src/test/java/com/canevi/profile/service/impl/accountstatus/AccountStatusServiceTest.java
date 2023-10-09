package com.canevi.profile.service.impl.accountstatus;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.canevi.profile.dao.model.AccountStatus;
import com.canevi.profile.dao.repository.AccountStatusRepository;
import com.canevi.profile.domain.enums.Status;
import com.canevi.profile.service.intf.accountstatus.AccountStatusService;

@ExtendWith(MockitoExtension.class)
class AccountStatusServiceTest {
    AccountStatusService accountStatusService;
    @Mock
    AccountStatusRepository accountStatusRepository;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        accountStatusService = new AccountStatusServiceImpl(accountStatusRepository);
    }
    @Test
    void test_getAccountStatusByAccountId() {
        Long accountId = 1L;
        Optional<AccountStatus> accountStatus = Optional.of(new AccountStatus());
        when(accountStatusRepository.findByAccountId(accountId)).thenReturn(accountStatus);
        assertNotNull(accountStatusService.getAccountStatusByAccountId(accountId));
    }
    @Test
    void test_createAccountStatus() {
        Long accountId = 1L;
        Status status = Status.ACTIVE;
        AccountStatus accountStatus = new AccountStatus();
        when(accountStatusRepository.save(any())).thenReturn(accountStatus);
        assertNotNull(accountStatusService.createAccountStatus(accountId, status));
    }
    @Test
    void test_updateAccountStatus() {
        Long accountId = 1L;
        Status status = Status.ACTIVE;
        AccountStatus accountStatus = new AccountStatus();
        when(accountStatusRepository.save(any())).thenReturn(accountStatus);
        assertNotNull(accountStatusService.updateAccountStatus(accountId, status));
    }
}
