package com.canevi.profile.domain.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {
    USER(1L, "User"),
    ADMIN(2L, "Admin"),
    MODERATOR(3L, "Moderator");

    private final Long id;
    private final String value;
}
