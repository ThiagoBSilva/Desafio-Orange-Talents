package com.testes.api.usuario;

//Importação dos módulos necessários
import java.time.LocalDate;

public class UsuarioResponseDTO {

	//Atributos
	private String nome;
	private String email;
	private String cpf;
	private LocalDate dataNasc;
	private Long id;
	
	//Construtor
	public UsuarioResponseDTO(String nome, String email, String cpf, LocalDate dataNasc, Long id){
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.dataNasc = dataNasc;
		this.id = id;
		
	}
	
	// Getters
	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}
	
	public String getCPF() {
		return cpf;
	}
	
	public LocalDate getDataNasc() {
		return dataNasc;
	}
	
	public Long getId() {
		return id;
	}
	
	//Método para transformar um Usuário em DTO
	public static UsuarioResponseDTO toDTO(Usuario usuario) {
		return new UsuarioResponseDTO(usuario.getNome(), usuario.getEmail(), usuario.getCpf(), 
									  usuario.getDataNasc(), usuario.getId());
	}
}
