package com.canevi.profile.util.annotation;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@NotBlank(message = "Email is required")
@Email(message = "Invalid email format")
@Pattern(regexp = "^\\w+([-+.']\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$", message = "Invalid email format")
public @interface ValidEmail {

}
