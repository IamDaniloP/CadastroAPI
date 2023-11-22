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
@Constraint(validatedBy = CpfValidation.CpfValidator.class)
public @interface CpfValidation {
  String message() default "Invalid CPF or Empty";

  class CpfValidator implements ConstraintValidator<CpfValidation, String> {

    @Override
    public void initialize(CpfValidation constraintAnnotation) {
      ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String cpfValue, ConstraintValidatorContext constraintValidatorContext) {
      String cpf = clearCpf(cpfValue);

      if (cpf.length() != 11 || isSequence(cpf)) return false;

      String verifiedCpf = cpfNumberCalculation(cpf);
      if (verifiedCpf.equals(cpf)) return true;

      return false;
    }

    private String clearCpf(String cpf) {
      cpf = cpf.replace(".", "").replace("-","").replace("/", "");
      return cpf;
    }

    private boolean isSequence(String cpf) {
      return repeatString(cpf.charAt(0), 14).equals(cpf);
    }

    private String repeatString(char char0Cpf, int repeat) {
      StringBuilder stringBuilder = new StringBuilder();

      for (int i = 0; i < repeat; i++) {
        stringBuilder.append(char0Cpf);
      }

      return stringBuilder.toString();
    }

    private String cpfNumberCalculation(String cpf)
    {
      String cpfWithoutDigits = cpf.substring(0, cpf.length() - 2);

      String firstDigit = digitsCalculation(cpfWithoutDigits);
      String secondDigit = digitsCalculation(cpfWithoutDigits + firstDigit);

      return cpfWithoutDigits + firstDigit + secondDigit;
    }

    private String digitsCalculation(String cpfDigits) {
      int total = 0;
      int count = cpfDigits.length() + 1;

      for (char number : cpfDigits.toCharArray()) {
        total += (number - '0') * count;
        count--;
      }

      int digit = 11 - (total % 11);
      return digit > 9 ? "0" : Integer.toString(digit);
    }
  }
}