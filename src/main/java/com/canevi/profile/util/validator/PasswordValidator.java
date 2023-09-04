package com.canevi.profile.util.validator;

import java.util.regex.Pattern;

import com.canevi.profile.util.annotation.ValidPassword;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordValidator implements ConstraintValidator<ValidPassword, String> {
    private static final String PASSWORD_PATTERN = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$";
    private static final Pattern pattern = Pattern.compile(PASSWORD_PATTERN);

    private static boolean validatePassword(String password) {
        return pattern.matcher(password).matches();
    }

    @Override
    public boolean isValid(String password, ConstraintValidatorContext context) {
        return validatePassword(password);
    }
}
