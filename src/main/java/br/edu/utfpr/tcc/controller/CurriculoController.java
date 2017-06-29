package br.edu.utfpr.tcc.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import br.edu.utfpr.tcc.model.AvaliacaoCurriculo;
import br.edu.utfpr.tcc.repository.AvaliacaoCurriculoRepository;
import br.edu.utfpr.tcc.repository.CurriculoRepository;
import net.sf.jasperreports.engine.JRException;

@RestController
@RequestMapping(value = "/empresa/curriculo")
public class CurriculoController {
	
	
	@Autowired
	private CurriculoRepository curriculoRepository;
	
	@Autowired
	private AvaliacaoCurriculoRepository avaliacaoCurriculoRepository;

	@GetMapping(value = "/listar")
	public ModelAndView listar() {
		ModelAndView model = new ModelAndView("/empresa/curriculo/lista-curriculo");

		return model;
	}
	
	@GetMapping(value = "/avaliar")
	public ModelAndView avaliar() {
		ModelAndView model = new ModelAndView("/empresa/curriculo/avalia-curriculo");

		return model;
	}
	
	@GetMapping(value = "/recentes")
	public ModelAndView recentes() {
		ModelAndView model = new ModelAndView("/empresa/curriculo/recentes-curriculo");

		return model;
	}
	
	@PostMapping(value = "/curriculoCanditadoPdf")
	public ModelAndView curriculoCanditadoPdf(@RequestParam(name = "idAvaliacaoCurriculo", required = true)Long idAvaliacaoCurriculo) {
		AvaliacaoCurriculo avaliacaoCurriculo = avaliacaoCurriculoRepository.findOne(idAvaliacaoCurriculo);
		
		Map<String, Object> param = new HashMap<>();
		param.put("format", "pdf");
		param.put("SUB_REPORT_DIR", "curriculo");
		param.put("CURRICULO_ID", avaliacaoCurriculo.getCurriculo().getId());
		param.put("AVALIACAO_CURRICULO_ID", idAvaliacaoCurriculo);
		return new ModelAndView("relatorio_curriculoCandidato", param);
	}

}
