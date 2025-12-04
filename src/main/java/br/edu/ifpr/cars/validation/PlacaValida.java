package br.edu.ifpr.cars.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Documented
@Constraint(validatedBy = PlacaValidaValidator.class)
@Target({ ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface PlacaValida {
  String message() default "Placa deve seguir o formato Mercosul (ex: ABC1D23)";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
