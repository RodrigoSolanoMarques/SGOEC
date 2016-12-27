package br.edu.utfpr.tcc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.utfpr.tcc.model.Curriculo;

public interface CurriculoRepository extends JpaRepository<Curriculo, Long>{
	
	List<Curriculo> findByCandidatoIsFavoritoIsTrue();
	
	List<Curriculo> findByCandidatoIsFavoritoIsFalse();
	
	
}
