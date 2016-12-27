package br.edu.utfpr.tcc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.utfpr.tcc.model.Candidato;

public interface CandidatoRepository extends JpaRepository<Candidato, Long>{
	
	
}
