package com.testes.api.endereco;

//Importação dos módulos necessários
import java.util.Collections;
import java.util.List;
import com.testes.api.usuario.Usuario;

public class EnderecoUsuarioResponseDTO {
	
	//Atributos
	private String nome;
	private String email;
	private Long id;
	private List<EnderecoResponseDTO> enderecos;
	
	//Construtor
	public EnderecoUsuarioResponseDTO(String nome, String email, Long id, List<Endereco> enderecos) {
		this.nome = nome;
		this.email = email;
		this.id = id;
		this.enderecos = EnderecoResponseDTO.toDTO(enderecos);
	}
	
	//Getters
	public String getNome() {
		return nome;
	}
	
	public String getEmail() {
		return email;
	}
	
	public List<EnderecoResponseDTO> getEnderecos(){
		return enderecos;
	}
	
	public Long getId() {
		return id;
	}
	
	//Método para transformar a lista de enderecos relacionados a um usuário em DTO
	public static EnderecoUsuarioResponseDTO toDTO(Usuario usuario, List<Endereco> listaEnderecos) {
		if(listaEnderecos.isEmpty()) {
			List<Endereco> listaVazia = Collections.emptyList();
			return new EnderecoUsuarioResponseDTO(usuario.getNome(), usuario.getEmail(), usuario.getId(), listaVazia);
		}
		return new EnderecoUsuarioResponseDTO(usuario.getNome(), usuario.getEmail(), usuario.getId(), listaEnderecos);
	}
}
