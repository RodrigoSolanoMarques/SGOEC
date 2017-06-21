package br.edu.utfpr.tcc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.utfpr.tcc.model.OportunidadeEmprego;

public interface OportunidadeEmpregoRepository extends JpaRepository<OportunidadeEmprego, Long> {
	
	public List<OportunidadeEmprego> findByIsFinalizadoFalseAndCargoAreaProfissionalNomeLike(String idAreaProfissional);

}
