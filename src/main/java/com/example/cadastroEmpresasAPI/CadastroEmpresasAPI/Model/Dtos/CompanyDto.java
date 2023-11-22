package com.example.cadastroEmpresasAPI.CadastroEmpresasAPI.Model.Dtos;

import com.example.cadastroEmpresasAPI.CadastroEmpresasAPI.Model.Validations.CnpjValidation;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CompanyDto {
  @NotNull
  private String companyName;

  @NotNull
  private String creationDate;

  @NotNull
  private String CEO;

  @NotNull
  @CnpjValidation
  private String CNPJ;

  @NotNull
  private String niche;
}
