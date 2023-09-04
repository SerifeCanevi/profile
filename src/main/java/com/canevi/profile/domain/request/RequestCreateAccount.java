package com.canevi.profile.domain.request;

import com.canevi.profile.domain.dto.AccountDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestCreateAccount {
    private AccountDTO account;
}
