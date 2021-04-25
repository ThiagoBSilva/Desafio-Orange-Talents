package com.testes.api.endereco;

//Importação dos módulos necessários
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

//Repositório para manipular os dados dos endereços
//SELECT e FROM Endereco e, Usuario u WHERE e.usuario.id = u.id
@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
	public static final String consultaEnderecoUsuario = "SELECT * FROM Endereco e2 WHERE e2.id_Usuario = ?1 "
													   + "AND e2.cep IN (SELECT cep FROM Endereco e1, Usuario u "
													   + "WHERE e1.id_Usuario = u.id)";
	@Query(value=consultaEnderecoUsuario, nativeQuery = true)
	List<Endereco> findById_Usuario(String id_Usuario);
}
