package com.canevi.profile.domain.request;

import com.canevi.profile.util.annotation.ValidEmail;
import com.canevi.profile.util.annotation.ValidPassword;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountCreateRequest {
    private String username;

    @ValidPassword
    private String password;

    @ValidEmail
    private String email;
}
