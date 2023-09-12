package com.canevi.profile.domain.request;

import com.canevi.profile.service.exception.PasswordException;
import com.canevi.profile.util.annotation.ValidPassword;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountUpdatePasswordRequest {
    private Long accountId;
    @ValidPassword
    private String newPassword;
    @ValidPassword
    private String confirmPassword;
    public void validate(String oldPassword) {
        if(!newPassword.equals(confirmPassword)) {
            throw new PasswordException("Password's do not match");
        } else if (newPassword.equals(oldPassword) || confirmPassword.equals(oldPassword)) {
            throw new PasswordException("New password cannot be the same as the old one");
        }
    }
}
