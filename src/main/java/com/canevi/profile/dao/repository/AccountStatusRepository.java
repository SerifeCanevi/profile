package com.canevi.profile.dao.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.canevi.profile.dao.model.AccountStatus;

public interface AccountStatusRepository extends JpaRepository<AccountStatus, Long> {
    @Query("SELECT a FROM AccountStatus a WHERE a.accountId = :accountId")
    Optional<AccountStatus> findByAccountId(Long accountId);
}
