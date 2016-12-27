package br.edu.utfpr.tcc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.utfpr.tcc.model.Cidade;
import br.edu.utfpr.tcc.model.Estado;

public interface CidadeRepository extends JpaRepository<Cidade, Long>{
	
	List<Cidade> findByEstado(Estado estado);

}
