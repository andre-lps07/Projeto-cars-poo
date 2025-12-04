package br.edu.ifpr.cars.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Documented
@Constraint(validatedBy = SemPalavrasOfensivasValidator.class)
@Target({ ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface SemPalavrasOfensivas {
  String message() default "O comentário contém palavras ofensivas";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
