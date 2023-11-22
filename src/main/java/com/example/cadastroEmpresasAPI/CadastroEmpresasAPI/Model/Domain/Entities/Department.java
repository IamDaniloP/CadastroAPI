package com.example.cadastroEmpresasAPI.CadastroEmpresasAPI.Model.Domain.Entities;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "departments")
@Data
public class Department implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer ID;

  @Column(nullable = false)
  private String DepartmentName;

  @Column(nullable = false)
  private String HeadOfTheDepartment;

  @Column(nullable = false)
  private String DepartmentDescription;

  @ManyToOne
  @JoinColumn(name = "company_CNPJ")
  private Company company;

  @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
  private List<Employee> employees;

  @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
  private List<Task> tasks;

  public Department() {
    employees = new ArrayList<>();
    tasks = new ArrayList<>();
  }
}
