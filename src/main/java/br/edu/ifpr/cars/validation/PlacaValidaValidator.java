package br.edu.ifpr.cars.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PlacaValidaValidator implements ConstraintValidator<PlacaValida, String> {

  private static final String PLACA_PATTERN = "^[A-Z]{3}[0-9][A-Z][0-9]{2}$";

  @Override
  public void initialize(PlacaValida constraintAnnotation) {
  }

  @Override
  public boolean isValid(String placa, ConstraintValidatorContext context) {
    if (placa == null || placa.isEmpty()) {
      return true;
    }

    return placa.matches(PLACA_PATTERN);
  }
}
