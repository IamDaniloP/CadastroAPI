package com.example.cadastroEmpresasAPI.CadastroEmpresasAPI.Repositories.Interfaces;

import com.example.cadastroEmpresasAPI.CadastroEmpresasAPI.Model.Domain.Entities.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICompanyRepository extends JpaRepository<Company, String> {
  @Query("SELECT c FROM Company c WHERE c.CNPJ = :cnpj")
  Company findCompanyByCNPJ(String cnpj);

  @Query("SELECT c FROM Company c")
  List<Company> findAllCompanies();
}
