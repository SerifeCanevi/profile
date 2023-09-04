package com.canevi.profile.domain.dto;

import com.canevi.profile.util.annotation.ValidEmail;
import com.canevi.profile.util.annotation.ValidPassword;

import lombok.Data;

@Data
public class AccountDTO {
    private Long id;
    
    private String username;

    @ValidPassword
    private String password;

    @ValidEmail
    private String email;
}
