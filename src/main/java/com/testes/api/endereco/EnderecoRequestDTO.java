package com.testes.api.endereco;

//Importação dos módulos necessários
import com.sun.istack.NotNull;
import com.testes.api.usuario.Usuario;

public class EnderecoRequestDTO {
	
	// Atributos
	@NotNull
	private String logradouro;

	@NotNull
	private short numero;

	private String complemento;

	@NotNull
	private String bairro;

	@NotNull
	private String cidade;

	@NotNull
	private String estado;

	@NotNull
	private String cep;
	
	private long id_Usuario;
	
	// Getters
	public String getLogradouro() {
		return logradouro;
	}

	public short getNumero() {
		return numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public String getEstado() {
		return estado;
	}
	
	public String getCep() {
		return cep;
	}
	
	public Long getId_Usuario() {
		return Long.valueOf(id_Usuario);
	}

	//Método para transformar o DTO em Endereco
	public Endereco toModel(Usuario usuario){
		return new Endereco(logradouro, numero, complemento, bairro, cidade, estado, cep, usuario);
	}
}
