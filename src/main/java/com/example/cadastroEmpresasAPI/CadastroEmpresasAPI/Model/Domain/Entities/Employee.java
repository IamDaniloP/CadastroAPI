package com.example.cadastroEmpresasAPI.CadastroEmpresasAPI.Model.Domain.Entities;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "employees")
@Data
public class Employee implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID ID;

  @Column(nullable = false)
  private String employeeName;

  @Column(nullable = false)
  private Date birthDate;

  @Column(nullable = false, unique = true)
  private String CPF;

  @Column(nullable = false, unique = true)
  private String phoneNumber;

  @Column(nullable = false, unique = true)
  private String email;

  @Column(nullable = false)
  private String roleName;

  @Column(nullable = false)
  private Date hireDate;

  @ManyToOne
  @JoinColumn(name = "company_CNPJ")
  private Company company;

  @ManyToOne
  @JoinColumn(name = "department_id")
  private Department department;

  @ManyToMany(cascade = CascadeType.ALL)
  @JoinTable(name = "task_employee",
          joinColumns = {@JoinColumn(name = "task_id")},
          inverseJoinColumns = {@JoinColumn(name = "employee_id")})
  private List<Task> tasks;

  public Employee() {
    tasks = new ArrayList<>();
  }
}
