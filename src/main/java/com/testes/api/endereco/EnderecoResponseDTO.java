package com.testes.api.endereco;

//Importação dos módulos necessários
import java.util.ArrayList;
import java.util.List;

public class EnderecoResponseDTO {

	// Atributos
	private String logradouro;
	private short numero;
	private String complemento;
	private String bairro;
	private String cidade;
	private String estado;
	private String cep;

	//Construtor
	private EnderecoResponseDTO(String logradouro, short numero, String complemento, 
			String bairro, String cidade, String estado, String cep) {
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.cep = cep;
	}
	
	// Getters
	public String getLogradouro() {
		return logradouro;
	}

	public short getNumero() {
		return numero;
	}

	public String getComplemento() {
		if(complemento == null) {
			return "N/D";
		}
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
	
	//Método para transformar um Endereco em DTO
	public static EnderecoResponseDTO toDTO(Endereco end) {
		return new EnderecoResponseDTO(end.getLogradouro(), end.getNumero(), end.getComplemento(), 
				end.getBairro(), end.getCidade(), end.getEstado(), end.getCep());
	}
	
	//Método para transformar uma lista de Enderecos em uma lista de DTOs
	public static List<EnderecoResponseDTO> toDTO(List<Endereco> listaEnderecos){
		List<EnderecoResponseDTO> enderecosDTO = new ArrayList<>();
		for(Endereco end: listaEnderecos) {
			enderecosDTO.add(EnderecoResponseDTO.toDTO(end));
		}
		return enderecosDTO;
	}
}
