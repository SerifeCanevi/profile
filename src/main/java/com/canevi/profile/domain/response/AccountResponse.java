package com.canevi.profile.domain.response;

import org.springframework.http.HttpStatus;

import com.canevi.profile.domain.dto.AccountDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountResponse extends BaseResponse {
    private AccountDTO account;

    public AccountResponse(AccountDTO account) {
        super();
        this.account = account;
    }
    public AccountResponse(AccountDTO account, String message) {
        super(message);
        this.account = account;
    }
    public AccountResponse(AccountDTO account, String message, HttpStatus status) {
        super(message, status);
        this.account = account;
    }
}
