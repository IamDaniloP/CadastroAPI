package com.example.cadastroEmpresasAPI.CadastroEmpresasAPI.Model.Validations;

import jakarta.validation.Constraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CnpjValidation.CnpjValidator.class)
public @interface CnpjValidation {
  String message() default "Invalid CNPJ or Empty";

  class CnpjValidator implements ConstraintValidator<CnpjValidation, String> {

    @Override
    public void initialize(CnpjValidation constraintAnnotation) {
      ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String valueCnpj, ConstraintValidatorContext constraintValidatorContext) {
      String cnpj = clearCnpj(valueCnpj);

      if (cnpj.length() != 14 || isSequence(cnpj)) return false;

      String verifiedCnpj = cnpjNumberCalculation(cnpj);
      if (verifiedCnpj.equals(cnpj)) return true;

      return false;
    }

    private String clearCnpj(String cnpj) {
      cnpj = cnpj.replace(".", "").replace("-","").replace("/", "");
      return cnpj;
    }

    private boolean isSequence(String cnpj) {
      return repeatString(cnpj.charAt(0), 14).equals(cnpj);
    }

    private String repeatString(char char0Cnpj, int repeat) {
      StringBuilder stringBuilder = new StringBuilder();

      for (int i = 0; i < repeat; i++) {
        stringBuilder.append(char0Cnpj);
      }

      return stringBuilder.toString();
    }

    private String cnpjNumberCalculation(String cnpj)
    {
      String cnpjWithoutDigits = cnpj.substring(0, cnpj.length() - 2);

      String firstDigit = firstDigitCalculation(cnpjWithoutDigits);
      String secondDigit = secondDigitCalculation(cnpjWithoutDigits + firstDigit);

      return cnpjWithoutDigits + firstDigit + secondDigit;
    }

    private String firstDigitCalculation(String cnpjWithoutDigits) {
      int total = 0;
      int[] multiples = new int[]{5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};

      for (int i = 0; i < cnpjWithoutDigits.length(); i++) {
        total += (cnpjWithoutDigits.charAt(i) - '0') * multiples[i];
      }

      int digit = total % 11;
      if (digit == 0 || digit == 1) {
        return "0";
      }
      return String.valueOf(11 - digit);
    }

    private String secondDigitCalculation(String cnpjWithoutLastDigit) {
      int total = 0;
      int[] multiples = new int[]{6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};

      for (int i = 0; i < cnpjWithoutLastDigit.length(); i++) {
        total += (cnpjWithoutLastDigit.charAt(i) - '0') * multiples[i];
      }

      int digit = total % 11;
      if (digit == 0 || digit == 1) {
        return "0";
      }
      return String.valueOf(11 - digit);
    }
  }
}