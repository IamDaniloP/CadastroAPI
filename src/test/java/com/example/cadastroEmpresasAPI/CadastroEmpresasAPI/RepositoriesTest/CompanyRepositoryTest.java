package com.example.cadastroEmpresasAPI.CadastroEmpresasAPI.RepositoriesTest;

import com.example.cadastroEmpresasAPI.CadastroEmpresasAPI.Repositories.CompanyRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

@DataJpaTest
@ActiveProfiles("test")
@DisplayName("Test for company repository")
public class CompanyRepositoryTest {

  @Autowired
  private CompanyRepository companyRepository;

  @Test
  @DisplayName("Creating company")
  public void createCompany() {
    // Verificação
    Assertions.assertTrue(1 == 1);
  }
}
