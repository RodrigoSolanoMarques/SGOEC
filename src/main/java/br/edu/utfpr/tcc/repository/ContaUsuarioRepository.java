package br.edu.utfpr.tcc.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import br.edu.utfpr.tcc.model.ContaUsuario;;

public interface ContaUsuarioRepository extends JpaRepository<ContaUsuario, Long>{
	
	//@Query("select c.id, c.username, c.email, c.imagem, c.senha from ContaUsuario c where c.id = :id")
	//ContaUsuario findById(@Param("id")Long id);
	
	ContaUsuario findByUsername(String username);


}
