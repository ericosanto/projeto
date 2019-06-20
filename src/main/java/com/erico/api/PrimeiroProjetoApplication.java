package com.erico.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.erico.api.entities.Empresa;
import com.erico.api.repositories.EmpresaRepository;

@SpringBootApplication
public class PrimeiroProjetoApplication {
	
	@Autowired
	private EmpresaRepository empresaRepository;
	
	@Value("${paginacao.qtd_por_pagina}")
	private int qtdPorPagina;

	public static void main(String[] args) {
		SpringApplication.run(PrimeiroProjetoApplication.class, args);
		System.out.println("Spring");
	}
	
	@Bean
	public CommandLineRunner commandLineRunner() {
		return args ->{
			Empresa empresa = new Empresa();
			empresa.setRazaoSocial("Cas & Cia");
			empresa.setCnpj("33443334454443455");
			
			this.empresaRepository.save(empresa);
			
			List<Empresa> empresas = empresaRepository.findAll();
			empresas.forEach(System.out::println);
			
			//Empresa empresaDb = empresaRepository.findOne(1L);
			//System.out.println("Empresa por id" + empresaDb);
			
		
			
			Empresa empresaCnpj = empresaRepository.findByCnpj("33443334454443455");
			System.out.println("Empresa por Cnpj" + empresaCnpj);
			
			
			//this.empresaRepository.delete(1L);
			empresas = empresaRepository.findAll();
			System.out.print("Empresa" + empresas.size());
			
			
			
			
		};
	}

}
