package com.example.cadastroEmpresasAPI.CadastroEmpresasAPI.Model.Domain.Entities;

import com.example.cadastroEmpresasAPI.CadastroEmpresasAPI.Model.Domain.Enums.Priority;
import com.example.cadastroEmpresasAPI.CadastroEmpresasAPI.Model.Domain.Enums.TaskStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "tasks")
@Data
public class Task implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID ID;

  @Column(nullable = false)
  private String TaskName;

  @Column(nullable = false)
  private String category;

  @Column(nullable = false)
  private Priority priority;

  @Column(nullable = false)
  private TaskStatus status;

  @Column(nullable = false)
  private Date startDate;

  @Column(nullable = false)
  private Date finishDate;

  @ManyToOne
  @JoinColumn(name = "department_id")
  private Department department;

  @ManyToMany(mappedBy = "tasks", cascade = CascadeType.ALL)
  private List<Employee> employees;

  public Task() {
    employees = new ArrayList<>();
  }
}
