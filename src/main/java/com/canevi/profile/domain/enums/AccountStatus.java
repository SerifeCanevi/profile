package com.canevi.profile.domain.enums;
import lombok.Getter;


@Getter
public enum AccountStatus {
    ACTIVE("ACTIVE"), PASSIVE("PASSIVE");

    private String value;

    private AccountStatus(String value) {
        this.value = value;
    }
}
