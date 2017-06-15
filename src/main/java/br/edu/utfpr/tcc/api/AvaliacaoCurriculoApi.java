package br.edu.utfpr.tcc.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.utfpr.tcc.model.AvaliacaoCurriculo;
import br.edu.utfpr.tcc.repository.AvaliacaoCurriculoRepository;

@RestController
@RequestMapping("/api/avaliacaoCurriculo")
public class AvaliacaoCurriculoApi {

	
	@Autowired
	AvaliacaoCurriculoRepository avaliacaoCurriculoRepository;
	
	@GetMapping("/listar")
	public List<AvaliacaoCurriculo> listar(Long idCandidato){
		return avaliacaoCurriculoRepository.findByCurriculoCandidatoId(idCandidato);
	}
}
