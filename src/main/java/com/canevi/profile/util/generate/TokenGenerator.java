package com.canevi.profile.util.generate;

import java.util.Date;

import com.canevi.profile.util.config.CryptoConfig;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TokenGenerator {
    private final CryptoConfig cryptoConfig;

    public String generateToken(Token token) throws Exception {
        token.setStartingDate(new Date());
        return cryptoConfig.encrypt(token.toString());
    }

    public Token decryptToken(String encryptedToken) throws Exception {
        String decryptedToken = cryptoConfig.decrypt(encryptedToken);
        return Token.fromString(decryptedToken);
    }
}
