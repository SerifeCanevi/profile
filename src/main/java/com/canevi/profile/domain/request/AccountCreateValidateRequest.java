package com.canevi.profile.domain.request;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountCreateValidateRequest {
    private Long accountId;
    private Date validationCreateDate;
}
