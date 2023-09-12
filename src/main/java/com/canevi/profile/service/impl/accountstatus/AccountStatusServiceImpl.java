package com.canevi.profile.service.impl.accountstatus;

import org.springframework.stereotype.Service;

import com.canevi.profile.dao.model.AccountStatus;
import com.canevi.profile.dao.repository.AccountStatusRepository;
import com.canevi.profile.domain.enums.Status;
import com.canevi.profile.service.intf.accountstatus.AccountStatusService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AccountStatusServiceImpl implements AccountStatusService {
    private final AccountStatusRepository accountStatusRepository;
    @Override
    public AccountStatus getAccountStatusByAccountId(Long accountId) {
        return accountStatusRepository.findByAccountId(accountId)
                .orElseThrow(() -> new RuntimeException("AccountStatus not found"));
    }

    @Override
    public AccountStatus createAccountStatus(Long accountId, Status status) {
        AccountStatus accountStatus = new AccountStatus();
        accountStatus.setAccountId(accountId);
        accountStatus.setStatus(status);
        return accountStatusRepository.save(accountStatus);
    }

    @Override
    public AccountStatus updateAccountStatus(Long accountId, Status status) {
        AccountStatus accountStatus = getAccountStatusByAccountId(accountId);
        accountStatus.setStatus(status);
        return accountStatusRepository.save(accountStatus);
    }
    
}
