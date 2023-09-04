package com.canevi.profile.util.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.canevi.profile.util.generate.TokenGenerator;
import com.canevi.profile.util.validator.AccountValidator;

@Configuration
public class BeanConfig {
    @Bean
    public AccountValidator getAccountValidator() {
        return new AccountValidator();
    }

    @Bean
    public CryptoConfig getCryptoConfig() {
        return new CryptoConfig();
    }

    @Bean
    public TokenGenerator getTokenGenerator() {
        return new TokenGenerator(getCryptoConfig());
    }
}
