package br.edu.utfpr.tcc.api;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.utfpr.tcc.dto.AvaliacaoCurriculoDTO;
import br.edu.utfpr.tcc.enumerator.EStatusCurriculo;
import br.edu.utfpr.tcc.model.AvaliacaoCurriculo;
import br.edu.utfpr.tcc.model.Curriculo;
import br.edu.utfpr.tcc.model.OportunidadeEmprego;
import br.edu.utfpr.tcc.repository.AvaliacaoCurriculoRepository;

@RestController
@RequestMapping("/api/avaliacaoCurriculo")
public class AvaliacaoCurriculoApi {

	@Autowired
	AvaliacaoCurriculoRepository avaliacaoCurriculoRepository;

	@GetMapping("/listar/{idPessoa}")
	public List<AvaliacaoCurriculo> listar(@PathVariable("idPessoa") Long idPessoa) {
		return avaliacaoCurriculoRepository.findByCurriculoCandidatoPessoaId(idPessoa);
	}

	@GetMapping("/{idPessoa}/{idOportunidadeEmprego}")
	public AvaliacaoCurriculoDTO findByPessoa(@PathVariable("idPessoa") Long idPessoa,
			@PathVariable("idOportunidadeEmprego") Long idOportunidadeEmprego) {

		List<AvaliacaoCurriculo> avaliacoesCurriculo = avaliacaoCurriculoRepository
				.findByCurriculoCandidatoPessoaId(idPessoa);

		for (AvaliacaoCurriculo avaliacao : avaliacoesCurriculo) {
			if (avaliacao.getOportunidadeEmprego().getId() == idOportunidadeEmprego) {

				AvaliacaoCurriculoDTO avaliacaoCurriculoDTO = new AvaliacaoCurriculoDTO();
				avaliacaoCurriculoDTO = avaliacaoCurriculoDTO.converterAvaliacaoCurriculo(avaliacao);
				return avaliacaoCurriculoDTO;
				
			}
		}
		
		return null;
	}

	@PostMapping("salvar/{idCurriculo}/{idOportunidadeEmprego}")
	public AvaliacaoCurriculoDTO salvar(@PathVariable("idCurriculo") Long idCurriculo,
			@PathVariable("idOportunidadeEmprego") Long idOportunidadeEmprego) {

		AvaliacaoCurriculo avaliacaoCurriculo = new AvaliacaoCurriculo();

		Curriculo curriculo = new Curriculo();
		curriculo.setId(idCurriculo);
		avaliacaoCurriculo.setCurriculo(curriculo);

		OportunidadeEmprego oportunidadeEmprego = new OportunidadeEmprego();
		oportunidadeEmprego.setId(idOportunidadeEmprego);

		avaliacaoCurriculo.setCurriculo(curriculo);
		avaliacaoCurriculo.setDataCurriculoEnviado(new Timestamp(System.currentTimeMillis()));
		avaliacaoCurriculo.setOportunidadeEmprego(oportunidadeEmprego);
		avaliacaoCurriculo.setStatus(EStatusCurriculo.AGUARDANDO_AVALIACAO);
		avaliacaoCurriculo.setFavorito(false);

		avaliacaoCurriculoRepository.save(avaliacaoCurriculo);
		AvaliacaoCurriculoDTO avaliacaoCurriculoDTO = new AvaliacaoCurriculoDTO();
		avaliacaoCurriculoDTO.converterAvaliacaoCurriculo(avaliacaoCurriculo);
		return avaliacaoCurriculoDTO;

	}
}
