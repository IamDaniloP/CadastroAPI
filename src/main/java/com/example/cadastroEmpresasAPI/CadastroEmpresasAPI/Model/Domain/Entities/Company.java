package com.example.cadastroEmpresasAPI.CadastroEmpresasAPI.Model.Domain.Entities;

import com.example.cadastroEmpresasAPI.CadastroEmpresasAPI.Model.Dtos.CompanyDto;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "companies")
@Data
public class Company implements Serializable {
  private static final long serialVersionUID = 1L;

  @Column(nullable = false)
  private String companyName;

  @Column(nullable = false)
  private Date creationDate;

  @Column(nullable = false)
  private String CEO;

  @Id
  private String CNPJ;

  @Column(nullable = false)
  private String niche;

  @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
  private List<Employee> employees;

  @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
  private List<Department> departments;

  public Company() {
    employees = new ArrayList<>();
    departments = new ArrayList<>();
  }

  public void MapFromDto(CompanyDto companyDto) {
    companyName = companyDto.getCompanyName();
    creationDate = Date.valueOf(companyDto.getCreationDate());
    CEO = companyDto.getCEO();
    CNPJ = companyDto.getCNPJ();
    niche = companyDto.getNiche();
  }
}

