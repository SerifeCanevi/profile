package com.canevi.profile.domain.response;

import com.canevi.profile.domain.dto.AccountDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseAccount extends BaseResponse {
    private AccountDTO account;
}
