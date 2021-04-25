package com.testes.api.usuario;

//Importação dos módulos necessários
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

//Classe controladora referente a Usuario
@RestController
@RequestMapping("/")
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	//Inserção um usuário no banco de dados
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/cadastrarUsuario")
	public UsuarioResponseDTO salvar(@RequestBody UsuarioRequestDTO usuarioDTO) {
		Usuario usuario = usuarioDTO.toModel();
		usuarioRepository.save(usuario);
		UsuarioResponseDTO usuarioResponseDTO_CPF = UsuarioResponseDTO.toDTO(usuario);
		return usuarioResponseDTO_CPF;
	}
}
