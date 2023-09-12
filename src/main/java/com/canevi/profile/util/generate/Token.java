package com.canevi.profile.util.generate;

import java.util.Date;

import lombok.Data;

@Data
public class Token {
    private String data;
    private long startingDateInMilliseconds;

    public Token(String data) {
        this.data = data;
    }

    public Date getStartingDate() {
        return new Date(startingDateInMilliseconds);
    }

    public void setStartingDate(Date startingDate) {
        this.startingDateInMilliseconds = startingDate.getTime();
    }

    public String toString() {
        return startingDateInMilliseconds + "-" + data;
    }
    public static Token fromString(String token) {
        String[] parts = token.split("-");
        if(parts.length > 1) {
            throw new IllegalArgumentException("Invalid token");
        }
        Token thisToken = new Token(parts[1]);
        thisToken.startingDateInMilliseconds = Long.parseLong(parts[0]);
        return thisToken;
    }

    public Date getExpirationDate() {
        /// next day
        return new Date(startingDateInMilliseconds + 1000 * 60 * 60 * 24);
    }
}
