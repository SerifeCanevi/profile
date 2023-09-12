package com.canevi.profile.dao.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.canevi.profile.dao.model.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    @Query("SELECT a FROM Account a WHERE a.id = :id")
    Optional<Account> findById(Long id);

    @Query("SELECT a FROM Account a WHERE a.username = :username")
    Optional<Account> findByUsername(String username);

    @Query("SELECT a FROM Account a WHERE a.email = :email")
    Optional<Account> findByEmail(String email);
}
