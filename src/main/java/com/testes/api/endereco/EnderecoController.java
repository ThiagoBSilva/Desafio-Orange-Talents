package com.testes.api.endereco;

//Importação dos módulos necessários
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.testes.api.usuario.Usuario;
import com.testes.api.usuario.UsuarioRepository;

//Classe controladora referente a Endereco
@RestController
@RequestMapping("/")
public class EnderecoController {

	@Autowired
	private EnderecoRepository enderecoRepository;

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	//Listagem dos endereços referentes a um usuário
	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/enderecos/{id_Usuario}")
	public EnderecoUsuarioResponseDTO listarEndUsuario(@PathVariable Long id_Usuario) {
		Usuario usuario = usuarioRepository.findById(id_Usuario).orElseThrow(() -> new
											NoSuchElementException("Usuário não encontrado!"));
		List<Endereco> listaEnderecos = enderecoRepository.findById_Usuario(id_Usuario.toString());
		return EnderecoUsuarioResponseDTO.toDTO(usuario, listaEnderecos);
	}
	
	//Inserção de um endereço no banco de dados
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/cadastrarEndereco")
	public EnderecoResponseDTO salvar(@RequestBody EnderecoRequestDTO enderecoDTO) {
		Usuario usuario = usuarioRepository.findById(enderecoDTO.getId_Usuario()).orElseThrow(
											() -> new NoSuchElementException("Usuário não encontrado!"));
		Endereco endereco = enderecoDTO.toModel(usuario);
		enderecoRepository.save(endereco);
		EnderecoResponseDTO enderecoResponseDTO = EnderecoResponseDTO.toDTO(endereco);
		return enderecoResponseDTO;
	}
}
