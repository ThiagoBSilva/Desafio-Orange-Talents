package com.testes.api.usuario;

//Importação dos módulos necessários
import java.time.LocalDate;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.testes.api.endereco.Endereco;

@Entity
public class Usuario {
	
	//Atributos
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false, unique = true)
	private String email;
	
	@Column(nullable = false, unique = true)
	private String cpf;
	
	@Column(nullable = false)
	private LocalDate dataNasc;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToMany(mappedBy = "usuario")
	List<Endereco> enderecos;
	
	//Construtor vazio
	public Usuario() {
	}
	
	//Construtor completo
	public Usuario(String nome, String email, String cpf, LocalDate dataNasc) {
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.dataNasc = dataNasc;
	}
	
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
	
	public Long getId() {
		return id;
	}
}
