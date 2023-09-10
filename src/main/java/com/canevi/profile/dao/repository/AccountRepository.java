package com.canevi.profile.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.canevi.profile.dao.model.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

}
