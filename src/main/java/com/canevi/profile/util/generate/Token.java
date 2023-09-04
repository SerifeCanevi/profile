package com.canevi.profile.util.generate;

import java.util.Date;

import lombok.Data;

@Data
public class Token {
    private Long id;
    private Date startingDate;

    public String toString() {
        return id + "-" + startingDate.getTime();
    }
    public static Token fromString(String token) {
        String[] parts = token.split("-");
        Token thisToken = new Token();
        thisToken.id = Long.parseLong(parts[0]);
        thisToken.startingDate = new Date(Long.parseLong(parts[1]));
        return thisToken;
    }
}
