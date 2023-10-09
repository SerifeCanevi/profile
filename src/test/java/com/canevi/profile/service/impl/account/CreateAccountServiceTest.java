package com.canevi.profile.service.impl.account;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.canevi.profile.dao.model.Account;
import com.canevi.profile.dao.repository.AccountRepository;
import com.canevi.profile.domain.dto.AccountDTO;
import com.canevi.profile.domain.mapper.AccountMapper;
import com.canevi.profile.domain.request.AccountCreateRequest;
import com.canevi.profile.service.intf.account.CreateAccountService;

@ExtendWith(MockitoExtension.class)
class CreateAccountServiceTest {
    CreateAccountService createAccountService;
    @Mock
    AccountRepository accountRepository;
    @Mock
    AccountMapper accountMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        createAccountService = new CreateAccountServiceImpl(accountRepository, accountMapper);
    }
    @Test
    void test_createAccount() {
        AccountCreateRequest createAccountRequest = mock(AccountCreateRequest.class);
        AccountDTO accountDTO = mock(AccountDTO.class);
        Account account = mock(Account.class);
        when(accountMapper.genereateAccountFromAccountCreateRequest(createAccountRequest)).thenReturn(account);
        when(accountMapper.genereateAccountDTOFromAccount(account)).thenReturn(accountDTO);
        when(accountRepository.save(any())).thenReturn(account);
        assertNotNull(createAccountService.createAccount(createAccountRequest));
    }
}
