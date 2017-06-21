package br.edu.utfpr.tcc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.utfpr.tcc.model.AreaProfissional;

public interface AreaProfissionalRepository extends JpaRepository<AreaProfissional, Long>{
	
	List<AreaProfissional> findByNome(String nome);

}
