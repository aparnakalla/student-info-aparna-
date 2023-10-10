package com.target.studentinfo.dto.request;


import com.target.studentinfo.model.Gender;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;


public class GenderEnumValidator implements ConstraintValidator<GenderEnum, String> {
    @Override
    public void initialize(GenderEnum constraintAnnotation) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        // Handle null values gracefully
        if (value == null) {
            return true;
        }

        // Perform your gender validation logic here
        return "MALE".equalsIgnoreCase(value) || "FEMALE".equalsIgnoreCase(value) || "OTHERS".equalsIgnoreCase(value);
    }
}

