package com.canevi.profile.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.canevi.profile.dao.model.AccountStatus;

public interface AccountStatusRepository extends JpaRepository<AccountStatus, Long> {

}
