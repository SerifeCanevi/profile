package com.canevi.profile.dao.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.canevi.profile.dao.model.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    Optional<Account> findByUsername(String username);

    @Query("select a.username from Account a where a.id = ?1 and a.status = 'ACTIVE'")
    Optional<String> getUsernameById(Long accountId);
    
    @Query("select a.status from Account a where a.id = ?1")
    Optional<String> getAccountStatusById(Long accountId);
    
    @Query("select a.role from Account a where a.id = ?1 and a.status = 'ACTIVE'")
    Optional<String> getRoleById(Long accountId);

    @Query("select count(a)>0 from Account a where a.username = ?1 and a.status = 'ACTIVE'")
    boolean checkUsername(String username);

    @Query("select count(a)>0 from Account a where a.email = ?1 and a.status = 'ACTIVE'")
    boolean checkEmail(String email);

    @Query("select count(a)>0 from Account a where a.email = ?1 and a.status = 'PASSIVE'")
    boolean checkIfPassiveUserByEmail(String email);
}
