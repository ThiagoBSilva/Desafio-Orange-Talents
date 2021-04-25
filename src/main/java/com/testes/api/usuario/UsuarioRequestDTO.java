package com.testes.api.usuario;

//Importação dos módulos necessários
import java.time.LocalDate;
import javax.validation.constraints.Email;
import org.hibernate.validator.constraints.br.CPF;
import com.sun.istack.NotNull;

public class UsuarioRequestDTO {
	
	//Atributos
	@NotNull
	private String nome;
	
	@NotNull
	@Email
	private String email;
	
	@NotNull
	@CPF
	private String cpf;
	
	@NotNull
	private LocalDate dataNasc;

	//Getters
	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getCpf() {
		return cpf;
	}

	public LocalDate getDataNasc() {
		return dataNasc;
	}
	
	//Método para transformar um DTO em Usuario
	public Usuario toModel() {
		return new Usuario(nome, email, cpf, dataNasc);
	}
}