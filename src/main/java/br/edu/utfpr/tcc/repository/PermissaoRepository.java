package br.edu.utfpr.tcc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.utfpr.tcc.model.Permissao;

public interface PermissaoRepository extends JpaRepository<Permissao, Long> {

	Permissao findByPermissao(String permissao);
	
	Permissao findById(Long id);
}
