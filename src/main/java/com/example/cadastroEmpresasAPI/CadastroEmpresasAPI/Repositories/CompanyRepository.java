package com.example.cadastroEmpresasAPI.CadastroEmpresasAPI.Repositories;

import com.example.cadastroEmpresasAPI.CadastroEmpresasAPI.Model.Domain.Entities.Company;
import com.example.cadastroEmpresasAPI.CadastroEmpresasAPI.Model.Dtos.CompanyDto;
import com.example.cadastroEmpresasAPI.CadastroEmpresasAPI.Repositories.Interfaces.ICompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CompanyRepository {
  private final ICompanyRepository companyRepository;

  @Autowired
  public CompanyRepository(ICompanyRepository companyRepository) {
    this.companyRepository = companyRepository;
  }

  public Company createCompany(CompanyDto companyDto) {
    Company company = new Company();
    company.MapFromDto(companyDto);
    return companyRepository.save(company);
  }

  public Company updateCompany(CompanyDto companyDto) {
    Company company = new Company();
    company.MapFromDto(companyDto);
    return companyRepository.save(company);
  }

  public void deleteCompany(String cnpj) {
    Company company = getCompany(cnpj);
    companyRepository.delete(company);
  }

  public Company getCompany(String cnpj) {
    return companyRepository.findCompanyByCNPJ(cnpj);
  }

  public List<Company> getAllCompany() {
    return companyRepository.findAllCompanies();
  }
}
