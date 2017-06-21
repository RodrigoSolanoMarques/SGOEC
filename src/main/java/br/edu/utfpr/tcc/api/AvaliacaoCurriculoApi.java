package br.edu.utfpr.tcc.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.utfpr.tcc.model.AvaliacaoCurriculo;
import br.edu.utfpr.tcc.repository.AvaliacaoCurriculoRepository;

@RestController
@RequestMapping("/api/avaliacaoCurriculo")
public class AvaliacaoCurriculoApi {

	
	@Autowired
	AvaliacaoCurriculoRepository avaliacaoCurriculoRepository;
	
	@GetMapping("/listar/{idPessoa}")
	public List<AvaliacaoCurriculo> listar(@PathVariable("idPessoa")Long idPessoa){
		return avaliacaoCurriculoRepository.findByCurriculoCandidatoPessoaId(idPessoa);
	}
	
	@GetMapping("/{idPessoa}/{idOportunidadeEmprego}")
	public AvaliacaoCurriculo findByPessoa(@PathVariable("idPessoa")Long idPessoa, 
			@PathVariable("idOportunidadeEmprego") Long idOportunidadeEmprego){
		
		List<AvaliacaoCurriculo> avaliacoesCurriculo = avaliacaoCurriculoRepository.findByCurriculoCandidatoPessoaId(idPessoa);
		
		AvaliacaoCurriculo retorno = null;
		for(AvaliacaoCurriculo avaliacao : avaliacoesCurriculo){
			if(avaliacao.getOportunidadeEmprego().getId() == idOportunidadeEmprego){
				retorno = avaliacao;
			}
		}
		
		return retorno;
	}
}
