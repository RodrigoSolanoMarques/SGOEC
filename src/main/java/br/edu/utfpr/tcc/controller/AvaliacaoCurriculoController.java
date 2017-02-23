package br.edu.utfpr.tcc.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.edu.utfpr.tcc.enumerator.EStatusCurriculo;
import br.edu.utfpr.tcc.model.AvaliacaoCurriculo;
import br.edu.utfpr.tcc.model.Curriculo;
import br.edu.utfpr.tcc.model.OportunidadeEmprego;
import br.edu.utfpr.tcc.repository.AvaliacaoCurriculoRepository;

@RestController
@RequestMapping(value = "/empresa/avaliacaoCurriculo")
public class AvaliacaoCurriculoController {
	
	@Autowired
	private AvaliacaoCurriculoRepository avaliacaoCurriculoController;

	@PostMapping("/salvar")
	public AvaliacaoCurriculo salvar(@RequestParam(name = "idCurriculo", required = true)Long idCurriculo, 
			@RequestParam(name = "idOportunidadeEmprego", required = true) Long idOportunidadeEmprego){				
		AvaliacaoCurriculo avaliacaoCurriculo = new AvaliacaoCurriculo();
		avaliacaoCurriculo.setCurriculo(new Curriculo(idCurriculo));
		avaliacaoCurriculo.setOportunidadeEmprego(new OportunidadeEmprego(idOportunidadeEmprego));
		avaliacaoCurriculo.setDataCurriculoEnviado(new Date());
		avaliacaoCurriculo.setStatus(EStatusCurriculo.AGUARDANDOAVALIACAO);
	
		return avaliacaoCurriculoController.save(avaliacaoCurriculo);
	}
	
	@PostMapping("/aprovar")
	public void aprovar(@RequestParam(name = "idAvaliacaoCurriculo", required = true)Long idAvaliacaoCurriculo){		
		AvaliacaoCurriculo avaliacaoCurriculo = avaliacaoCurriculoController.findOne(idAvaliacaoCurriculo);
		avaliacaoCurriculo.setStatus(EStatusCurriculo.APROVADO);
		System.out.println(" Deu certo");
	}
	
	@PostMapping("/favoritar")
	public void favoritar(@RequestParam(name = "idAvaliacaoCurriculo", required = true)Long idAvaliacaoCurriculo){		
		AvaliacaoCurriculo avaliacaoCurriculo = avaliacaoCurriculoController.findOne(idAvaliacaoCurriculo);
		avaliacaoCurriculo.setFavorito(true);
		avaliacaoCurriculo.setStatus(EStatusCurriculo.LISTAFAVORITOS);
	}
	
	@PostMapping("/marcarEntrevista")
	public void marcarEntrevista(@RequestParam(name = "idAvaliacaoCurriculo", required = true)Long idAvaliacaoCurriculo,
			@RequestParam(name = "dataEntrevista", required = true)Date dataEntrevista){		
		AvaliacaoCurriculo avaliacaoCurriculo = avaliacaoCurriculoController.findOne(idAvaliacaoCurriculo);
		avaliacaoCurriculo.setDataEntrevista(dataEntrevista);
		avaliacaoCurriculo.setStatus(EStatusCurriculo.ENTREVISTAMARCADA);
	}
	
	@PostMapping("/dispensar")
	public void encerrar(@RequestParam(name = "idAvaliacaoCurriculo", required = true)Long idAvaliacaoCurriculo){		
		AvaliacaoCurriculo avaliacaoCurriculo = avaliacaoCurriculoController.findOne(idAvaliacaoCurriculo);
		avaliacaoCurriculo.setDataEncerramento(new Date());
		avaliacaoCurriculo.setStatus(EStatusCurriculo.DISPENSADO);
	}
	
	@PostMapping("/avaliado")
	public void avaliado(@RequestParam(name = "idAvaliacaoCurriculo", required = true)Long idAvaliacaoCurriculo){		
		AvaliacaoCurriculo avaliacaoCurriculo = avaliacaoCurriculoController.findOne(idAvaliacaoCurriculo);
		avaliacaoCurriculo.setStatus(EStatusCurriculo.AVALIADO);
	}
	
	@PutMapping("/listaEspera")
	public void listaEspera(@RequestParam(name = "idAvaliacaoCurriculo", required = true)Long idAvaliacaoCurriculo){		
		AvaliacaoCurriculo avaliacaoCurriculo = avaliacaoCurriculoController.findOne(idAvaliacaoCurriculo);
		avaliacaoCurriculo.setStatus(EStatusCurriculo.LISTAESPERA);
	}
	
	@PostMapping("/solicitarCurriculo")
	public void solicitarCurriculo(@RequestParam(name = "idAvaliacaoCurriculo", required = true)Long idAvaliacaoCurriculo){		
		AvaliacaoCurriculo avaliacaoCurriculo = avaliacaoCurriculoController.findOne(idAvaliacaoCurriculo);
		avaliacaoCurriculo.setStatus(EStatusCurriculo.SOLICITOUCURRICULO);
	}
}
