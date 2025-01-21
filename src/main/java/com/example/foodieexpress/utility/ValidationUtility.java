package com.example.foodieexpress.utility;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

import java.util.Set;

public class ValidationUtility {

    private static final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    private static final Validator validator = factory.getValidator();


    public static <T> boolean validate(T dto) {
        Set<ConstraintViolation<T>> violations = validator.validate(dto);
        return violations.isEmpty();
    }


    public static <T> Set<ConstraintViolation<T>> getValidationErrors(T dto) {
        return validator.validate(dto);
    }
}