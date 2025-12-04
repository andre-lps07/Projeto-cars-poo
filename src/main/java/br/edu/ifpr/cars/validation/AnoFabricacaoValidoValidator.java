package br.edu.ifpr.cars.validation;

import java.time.LocalDate;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class AnoFabricacaoValidoValidator implements ConstraintValidator<AnoFabricacaoValido, Integer> {

  private static final int ANO_MINIMO = 1886;

  @Override
  public void initialize(AnoFabricacaoValido constraintAnnotation) {
  }

  @Override
  public boolean isValid(Integer ano, ConstraintValidatorContext context) {
    if (ano == null) {
      return true;
    }

    int anoAtual = LocalDate.now().getYear();
    return ano >= ANO_MINIMO && ano <= anoAtual;
  }
}
