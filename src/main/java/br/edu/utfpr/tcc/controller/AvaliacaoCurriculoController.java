package br.edu.utfpr.tcc.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.edu.utfpr.tcc.enumerator.EStatusCurriculo;
import br.edu.utfpr.tcc.model.AvaliacaoCurriculo;
import br.edu.utfpr.tcc.model.Curriculo;
import br.edu.utfpr.tcc.model.OportunidadeEmprego;
import br.edu.utfpr.tcc.repository.AvaliacaoCurriculoRepository;
import br.edu.utfpr.tcc.repository.OportunidadeEmpregoRepository;

@RestController
@RequestMapping(value = "/empresa/avaliacaoCurriculo")
public class AvaliacaoCurriculoController {
	
	@Autowired
	private AvaliacaoCurriculoRepository avaliacaoCurriculoRepository;
	
	@Autowired
	private OportunidadeEmpregoRepository oportunidadeEmpregoRepository;

	@PostMapping("/salvar")
	public AvaliacaoCurriculo salvar(@RequestParam(name = "idCurriculo", required = true)Long idCurriculo, 
			@RequestParam(name = "idOportunidadeEmprego", required = true) Long idOportunidadeEmprego){				
		AvaliacaoCurriculo avaliacaoCurriculo = new AvaliacaoCurriculo();
		avaliacaoCurriculo.setCurriculo(new Curriculo(idCurriculo));
		avaliacaoCurriculo.setOportunidadeEmprego(new OportunidadeEmprego(idOportunidadeEmprego));
		avaliacaoCurriculo.setDataCurriculoEnviado(new Date());
		avaliacaoCurriculo.setStatus(EStatusCurriculo.AGUARDANDO_AVALIACAO);
	
		return avaliacaoCurriculoRepository.save(avaliacaoCurriculo);
	}
	
	@PostMapping("/aprovar")
	public void aprovar(@RequestParam(name = "idAvaliacaoCurriculo", required = true)Long idAvaliacaoCurriculo){
		/* Recupera a AvaliacaoCurriculo para mudar o status para aprovado */
		AvaliacaoCurriculo avaliacaoCurriculo = avaliacaoCurriculoRepository.findOne(idAvaliacaoCurriculo);
		avaliacaoCurriculo.setStatus(EStatusCurriculo.APROVADO);
		avaliacaoCurriculoRepository.save(avaliacaoCurriculo);
		
		/* FInaliza a Oportunidade de Emprego */
		OportunidadeEmprego oportunidadeEmprego = oportunidadeEmpregoRepository.findOne(avaliacaoCurriculo.getOportunidadeEmprego().getId());
		oportunidadeEmprego.setIsFinalizado(true);
		oportunidadeEmpregoRepository.save(oportunidadeEmprego);
		
		/* Exclui todas as avaliações de currículos vinculadas a essa oportunidade de emprego */
		List<AvaliacaoCurriculo> listaAvaliacaoCurriculo = avaliacaoCurriculoRepository.findByIdIsNotIn(avaliacaoCurriculo.getId());
		avaliacaoCurriculoRepository.delete(listaAvaliacaoCurriculo);
		
	}
	
	@PostMapping("/favoritar")
	public void favoritar(@RequestParam(name = "idAvaliacaoCurriculo", required = true)Long idAvaliacaoCurriculo){		
		AvaliacaoCurriculo avaliacaoCurriculo = avaliacaoCurriculoRepository.findOne(idAvaliacaoCurriculo);
		avaliacaoCurriculo.setFavorito(true);
		avaliacaoCurriculo.setStatus(EStatusCurriculo.LISTA_DE_FAVORITOS);
		avaliacaoCurriculoRepository.save(avaliacaoCurriculo);
	}
	
	@PostMapping("/marcarEntrevista")
	public void marcarEntrevista(@RequestParam(name = "idAvaliacaoCurriculo", required = true)Long idAvaliacaoCurriculo,
			@RequestParam(name = "dataEntrevista", required = true)Date dataEntrevista){		
		AvaliacaoCurriculo avaliacaoCurriculo = avaliacaoCurriculoRepository.findOne(idAvaliacaoCurriculo);
		avaliacaoCurriculo.setDataEntrevista(dataEntrevista);
		avaliacaoCurriculo.setStatus(EStatusCurriculo.ENTREVISTA_MARCADA);
		avaliacaoCurriculoRepository.save(avaliacaoCurriculo);
	}
	
	@PostMapping("/dispensar")
	public void encerrar(@RequestParam(name = "idAvaliacaoCurriculo", required = true)Long idAvaliacaoCurriculo){		
		AvaliacaoCurriculo avaliacaoCurriculo = avaliacaoCurriculoRepository.findOne(idAvaliacaoCurriculo);
		avaliacaoCurriculo.setDataEncerramento(new Date());
		avaliacaoCurriculo.setStatus(EStatusCurriculo.DISPENSADO);
		avaliacaoCurriculoRepository.save(avaliacaoCurriculo);
	}
	
	@PostMapping("/avaliado")
	public void avaliado(@RequestParam(name = "idAvaliacaoCurriculo", required = true)Long idAvaliacaoCurriculo){		
		AvaliacaoCurriculo avaliacaoCurriculo = avaliacaoCurriculoRepository.findOne(idAvaliacaoCurriculo);
		avaliacaoCurriculo.setStatus(EStatusCurriculo.AVALIADO);
		avaliacaoCurriculoRepository.save(avaliacaoCurriculo);
	}
	
	@PostMapping("/listaEspera")
	public void listaEspera(@RequestParam(name = "idAvaliacaoCurriculo", required = true)Long idAvaliacaoCurriculo){		
		AvaliacaoCurriculo avaliacaoCurriculo = avaliacaoCurriculoRepository.findOne(idAvaliacaoCurriculo);
		avaliacaoCurriculo.setStatus(EStatusCurriculo.LISTA_ESPERA);
		avaliacaoCurriculo.setFavorito(false);
		avaliacaoCurriculoRepository.save(avaliacaoCurriculo);
	}
	
	@PostMapping("/solicitarCurriculo")
	public void solicitarCurriculo(@RequestParam(name = "idAvaliacaoCurriculo", required = true)Long idAvaliacaoCurriculo){		
		AvaliacaoCurriculo avaliacaoCurriculo = avaliacaoCurriculoRepository.findOne(idAvaliacaoCurriculo);
		avaliacaoCurriculo.setStatus(EStatusCurriculo.SOLICITOU_CURRICULO);
		avaliacaoCurriculoRepository.save(avaliacaoCurriculo);
	}
}
