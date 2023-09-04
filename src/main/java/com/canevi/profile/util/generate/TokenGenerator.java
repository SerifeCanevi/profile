package com.canevi.profile.util.generate;

import java.util.Date;

import com.canevi.profile.util.config.CryptoConfig;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TokenGenerator {
    private final CryptoConfig cryptoConfig;

    public String generateToken(Long accountId) throws Exception {
        Token token = new Token();
        token.setId(accountId);
        token.setStartingDate(new Date());
        String uniqueId = token.toString();

        return cryptoConfig.encrypt(uniqueId);
    }

    public Token decryptToken(String encryptedToken) throws Exception {
        String decryptedToken = cryptoConfig.decrypt(encryptedToken);

        return Token.fromString(decryptedToken);
    }
}
