package br.edu.ifpr.cars.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Documented
@Constraint(validatedBy = AnoFabricacaoValidoValidator.class)
@Target({ ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface AnoFabricacaoValido {
  String message() default "Ano de fabricação deve estar entre 1886 e o ano atual";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
