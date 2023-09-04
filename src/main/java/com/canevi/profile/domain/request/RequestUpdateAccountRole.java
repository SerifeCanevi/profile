package com.canevi.profile.domain.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestUpdateAccountRole {
    private Long accountId;
    private String role;
}
