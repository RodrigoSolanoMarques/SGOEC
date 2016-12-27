package br.edu.utfpr.tcc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping(value = "/empresa/curriculo")
public class CurriculoController {

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

}
