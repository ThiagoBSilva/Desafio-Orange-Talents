package com.testes.api.usuario;

//Importação dos módulos necessários
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Repositório para manipular os dados dos usuários
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
}
