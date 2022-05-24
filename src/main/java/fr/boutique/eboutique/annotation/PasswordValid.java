package fr.boutique.eboutique.annotation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({TYPE,ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = PasswordValidator.class)
@Documented
public @interface PasswordValid {
    String message() default "Le mot de passe ne contient pas de caractère spécial ou ne commence pas par une majusucle.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}