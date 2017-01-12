package br.edu.utfpr.tcc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import br.edu.utfpr.tcc.model.AvaliacaoCurriculo;
import br.edu.utfpr.tcc.model.Candidato;
import br.edu.utfpr.tcc.model.Curriculo;
import br.edu.utfpr.tcc.repository.AvaliacaoCurriculoRepository;
import br.edu.utfpr.tcc.repository.CandidatoRepository;
import br.edu.utfpr.tcc.repository.CurriculoRepository;

@RestController
@RequestMapping(value = "/empresa/candidato")
public class CandidatoController {
	
	@Autowired
	CandidatoRepository candidatoRepository;
	
	@Autowired
	CurriculoRepository curriculoRepository;
	
	@Autowired
	AvaliacaoCurriculoRepository avaliacaoCurriculoRepository;
	
	@GetMapping(value="/listar")
	public ModelAndView listar() {
		ModelAndView model = new ModelAndView("/empresa/candidato/lista-candidatos");

		return model;
	}
	
	@GetMapping(value="/listarCandidatos")
	public List<Curriculo> listarCandidatos() {
		
		return curriculoRepository.findAll();
	}
	
	@GetMapping(value="/favoritos")
	public ModelAndView favoritos() {
		ModelAndView model = new ModelAndView("/empresa/candidato/lista-candidatos-favoritos");

		return model;
	}
	
	@GetMapping(value="/listarCandidatosFavoritos")
	public List<AvaliacaoCurriculo> listarCandidatosFavoritos() {
		
		return avaliacaoCurriculoRepository.findByFavoritoTrue();
	}
	
	@GetMapping(value="/carregar")
	public Curriculo carregar(@RequestParam(name = "id", required = true)Long id) {
		return curriculoRepository.findOne(id);
	}

}
