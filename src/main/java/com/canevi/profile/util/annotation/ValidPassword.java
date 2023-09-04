package com.canevi.profile.util.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.canevi.profile.util.validator.PasswordValidator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.constraints.Size;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PasswordValidator.class)
@Size(min = 8, max = 20, message = "Password length must be between 8 and 20 characters")
public @interface ValidPassword {
    String message() default "Invalid password format";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
