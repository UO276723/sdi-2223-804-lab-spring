package com.uniovi.sdi2223804spring.validators;

import com.uniovi.sdi2223804spring.entities.Mark;
import com.uniovi.sdi2223804spring.entities.User;
import com.uniovi.sdi2223804spring.services.MarksService;
import com.uniovi.sdi2223804spring.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class MarkValidator implements Validator {
    @Autowired
    private MarksService marksService;

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Mark mark = (Mark) target;
        if (mark.getScore() < 0 || mark.getScore() > 10)
            errors.rejectValue("score", "Error.mark.score.range");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "Error.empty");
        if (mark.getDescription().length() < 20) {
            errors.rejectValue("description", "Error.mark.description.length");}
    }
}
