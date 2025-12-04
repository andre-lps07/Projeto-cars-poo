package br.edu.ifpr.cars.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CNHValidaValidator implements ConstraintValidator<CNHValida, String> {

  @Override
  public void initialize(CNHValida constraintAnnotation) {
  }

  @Override
  public boolean isValid(String cnh, ConstraintValidatorContext context) {
    if (cnh == null || cnh.isEmpty()) {
      return true;
    }

    return cnh.matches("\\d{11}");
  }
}
