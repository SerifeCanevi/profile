package com.canevi.profile.domain.enums;

public enum Status {
    ACTIVE("Active"),
    INACTIVE("Inactive"),
    PENDING("Pending"),
    BANNED("Banned");

    private final String value;

    Status(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

