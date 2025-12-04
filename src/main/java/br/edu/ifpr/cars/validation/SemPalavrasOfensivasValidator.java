package br.edu.ifpr.cars.validation;

import java.util.Arrays;
import java.util.List;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class SemPalavrasOfensivasValidator implements ConstraintValidator<SemPalavrasOfensivas, String> {

  private static final List<String> PALAVRAS_PROIBIDAS = Arrays.asList(
      "burro",
      "idiota",
      "lixo",
      "estúpido",
      "imbecil");

  @Override
  public void initialize(SemPalavrasOfensivas constraintAnnotation) {
  }

  @Override
  public boolean isValid(String comentario, ConstraintValidatorContext context) {
    if (comentario == null || comentario.isEmpty()) {
      return true;
    }

    String textoMinusculo = comentario.toLowerCase();

    for (String palavraProibida : PALAVRAS_PROIBIDAS) {
      if (textoMinusculo.contains(palavraProibida)) {
        return false;
      }
    }

    return true;
  }
}
