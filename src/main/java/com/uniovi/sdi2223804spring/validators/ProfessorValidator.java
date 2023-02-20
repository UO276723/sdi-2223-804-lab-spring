package com.uniovi.sdi2223804spring.validators;

import com.uniovi.sdi2223804spring.entities.Mark;
import com.uniovi.sdi2223804spring.entities.Professor;
import com.uniovi.sdi2223804spring.entities.User;
import com.uniovi.sdi2223804spring.services.MarksService;
import com.uniovi.sdi2223804spring.services.ProfessorsService;
import com.uniovi.sdi2223804spring.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class ProfessorValidator implements Validator {
    @Autowired
    private ProfessorsService professorsService;

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Professor professor = (Professor) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "DNI", "Error.empty");
        if (professor.getDNI().length() != 9) {
            errors.rejectValue("DNI", "Error.professor.dni.length");}

        if (professor.getDNI().length()>8 && !Character.isLetter(professor.getDNI().charAt(8)))
            errors.rejectValue("DNI", "Error.professor.dni.letter");

        if (professorsService.getProfessorByDNI(professor.getDNI()) != null) {
            errors.rejectValue("DNI", "Error.professor.dni.duplicate");}

    }
}
