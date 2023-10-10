package com.target.studentinfo.dto.request;



import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = GenderEnumValidator.class)
@Documented
public @interface GenderEnum {
    String message() default "Invalid gender. Allowed values are: MALE, FEMALE, OTHERS";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
