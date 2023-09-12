package com.canevi.profile.domain.request;

import com.canevi.profile.service.exception.EmailException;
import com.canevi.profile.util.annotation.ValidEmail;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountEmailRequest {
    private Long accountId;
    @ValidEmail
    private String email;
    public void validate(String oldEmail) {
        if(email.equals(oldEmail)) {
            throw new EmailException();
        }
    }
}
