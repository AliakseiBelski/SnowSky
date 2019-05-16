package com.tryam.study.validator;

import com.tryam.study.entity.Account;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Service
public class AccountValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return Account.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "login", "login is empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "password is empty");
    }

}
