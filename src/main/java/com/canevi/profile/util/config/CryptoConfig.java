package com.canevi.profile.util.config;

import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.beans.factory.annotation.Value;

public class CryptoConfig {
    @Value("${token.algorithm}")
    private String algorithm;

    @Value("${token.secretKey}")
    private String secretKey;

    private Key generateKey() throws NoSuchAlgorithmException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance(algorithm);
        keyGenerator.init(128);
        return new SecretKeySpec(secretKey.getBytes(), algorithm);
    }

    public String encrypt(String data) throws Exception {
        Key key = generateKey();
        Cipher cipher = Cipher.getInstance(algorithm);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encryptedBytes = cipher.doFinal(data.getBytes());
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    public String decrypt(String encryptedData) throws Exception {
        byte[] decodedData = Base64.getDecoder().decode(encryptedData);
        Key key = generateKey();
        Cipher cipher = Cipher.getInstance(algorithm);
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decryptedBytes = cipher.doFinal(decodedData);
        return new String(decryptedBytes);
    }
}
