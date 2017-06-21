package br.edu.utfpr.tcc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.utfpr.tcc.enumerator.EStatusCurriculo;
import br.edu.utfpr.tcc.model.AvaliacaoCurriculo;

public interface AvaliacaoCurriculoRepository extends JpaRepository<AvaliacaoCurriculo, Long>{
	
	public List<AvaliacaoCurriculo> findByFavoritoTrueAndStatusIsNotIn(EStatusCurriculo avaliacaoCurriculo);
	
	public List<AvaliacaoCurriculo> findByFavoritoFalseAndStatusIsNotIn(EStatusCurriculo avaliacaoCurriculo);
	
	public List<AvaliacaoCurriculo> findByIdIsNotIn(Long id);
	
	public List<AvaliacaoCurriculo> findByCurriculoCandidatoPessoaId(Long idPessoa);
	
}
