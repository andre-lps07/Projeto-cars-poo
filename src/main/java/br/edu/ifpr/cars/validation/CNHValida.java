package br.edu.ifpr.cars.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Documented
@Constraint(validatedBy = CNHValidaValidator.class)
@Target({ ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface CNHValida {
  String message() default "CNH deve conter exatamente 11 dígitos numéricos";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
