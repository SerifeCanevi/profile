package com.canevi.profile.dao.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.canevi.profile.dao.model.AccountRole;

public interface AccountRoleRepository extends JpaRepository<AccountRole, Long> {
    @Query("SELECT a FROM AccountRole a WHERE a.account.id = :accountId")
    Optional<List<AccountRole>> findByAccountId(Long accountId);

    @Query("SELECT COUNT(a) > 0 FROM AccountRole a WHERE a.account.id = :accountId AND a.role = :role")
    boolean findIfAccountHasRole(Long accountId, String role);

    @Query("DELETE FROM AccountRole a WHERE a.account.id = :accountId AND a.role = :role")
    boolean removeRoleFromAccount(Long accountId, String role);
}
