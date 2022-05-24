package fr.boutique.eboutique.annotation;

import fr.boutique.eboutique.modelDto.UsersDto;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> {

    @Override
    public void initialize(PasswordMatches constraintAnnotation) {}

    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext context){
        UsersDto user = (UsersDto) obj;
        return user.getPassword().equals(user.getPasswordMatches());
    }
}