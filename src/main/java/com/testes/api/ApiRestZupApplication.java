package com.testes.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class ApiRestZupApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiRestZupApplication.class, args);
	}

}
