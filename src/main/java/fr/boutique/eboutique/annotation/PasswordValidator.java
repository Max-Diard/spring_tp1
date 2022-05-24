package fr.boutique.eboutique.annotation;

import fr.boutique.eboutique.modelDto.UsersDto;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordValidator implements ConstraintValidator<PasswordValid, Object> {

    private final String[] specialCharacter = {"%", "*", "$", "-", "+", "="};

    @Override
    public void initialize(PasswordValid constraintAnnotation) {
    }

    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext context) {
        UsersDto user = (UsersDto) obj;
        if(Character.isUpperCase(user.getPassword().indexOf(0))){
            for (String special : specialCharacter) {
                if (user.getPassword().contains(special)) {
                    return true;
                }
            }
        }

        return false;
    }
}
