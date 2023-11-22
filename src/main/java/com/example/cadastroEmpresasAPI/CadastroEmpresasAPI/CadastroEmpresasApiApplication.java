package com.example.cadastroEmpresasAPI.CadastroEmpresasAPI;

import com.example.cadastroEmpresasAPI.CadastroEmpresasAPI.Model.Domain.Entities.Company;
import com.example.cadastroEmpresasAPI.CadastroEmpresasAPI.Model.Dtos.CompanyDto;
import com.example.cadastroEmpresasAPI.CadastroEmpresasAPI.Repositories.CompanyRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CadastroEmpresasApiApplication {
	public static void main(String[] args) {
		SpringApplication.run(CadastroEmpresasApiApplication.class, args);
	}
}
