package com.canevi.profile.domain.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Status {
    ACTIVE(1L,"Active"),
    INACTIVE(2L,"Inactive"),
    PENDING(3L,"Pending"),
    BANNED(4L,"Banned");

    private final Long id;
    private final String value;
}

