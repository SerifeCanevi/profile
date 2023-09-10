package com.canevi.profile.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.canevi.profile.dao.model.UserDetail;

public interface UserDetailRepository extends JpaRepository<UserDetail, Long> {
    
}
