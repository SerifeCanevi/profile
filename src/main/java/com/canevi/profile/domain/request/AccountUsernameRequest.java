package com.canevi.profile.domain.request;

import com.canevi.profile.service.exception.UsernameException;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountUsernameRequest {
    private Long accountId;
    private String username;
    public void validate(String oldUsername) {
        if(username.equals(oldUsername)) {
            throw new UsernameException();
        }
    }
}
