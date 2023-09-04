package com.canevi.profile.domain.enums;

import lombok.Getter;

@Getter
public enum AccountRole {
    NONE("NONE"), 
    NOT_VERIFIED("NOT_VERIFIED"),
    USER("USER"), 
    ADMIN("ADMIN");

    private String value;

    private AccountRole(String value) {
        this.value = value;
    }
}
