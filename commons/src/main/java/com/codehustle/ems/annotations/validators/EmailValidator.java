package com.codehustle.ems.annotations.validators;

import com.codehustle.ems.annotations.ValidEmail;
import com.codehustle.ems.constants.ApplicationConstants;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidator implements ConstraintValidator<ValidEmail,String> {

    @Override
    public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {
        if(email == null)
            return false;
        Pattern pattern = Pattern.compile(ApplicationConstants.EMAIL_REGEX);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
