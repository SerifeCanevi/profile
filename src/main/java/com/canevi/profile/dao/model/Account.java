package com.canevi.profile.dao.model;

import com.canevi.profile.domain.enums.AccountRole;
import com.canevi.profile.domain.enums.AccountStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.SEQUENCE, generator = "account_seq")
    @SequenceGenerator(name = "account_seq", sequenceName = "account_seq", allocationSize = 1)
    private Long id;
    @Column
    private String username;
    @Column
    private String password;
    @Column
    private String email;
    @Column
    private String role;
    @Column
    private String status;

    public void setStatus(AccountStatus status) {
        this.status = status.getValue();
    }

    public void setRole(AccountRole role) {
        this.role = role.getValue();
    }

    public void setRole(String role) {
        this.role = role;
    }
}
