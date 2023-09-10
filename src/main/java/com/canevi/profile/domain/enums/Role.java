package com.canevi.profile.domain.enums;

public enum Role {
    USER("User"),
    ADMIN("Admin"),
    MODERATOR("Moderator");

    private final String value;

    Role(String value) {
        this.value = value;
    }

    public String getDisplayName() {
        return value;
    }
}
