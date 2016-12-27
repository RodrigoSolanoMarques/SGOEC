package br.edu.utfpr.tcc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;

import br.edu.utfpr.tcc.controller.CandidatoController;

public class CandidatoService {
	
	@Autowired
	CandidatoController candidatoController;

	public ModelAndView listar(){
		ModelAndView model = new ModelAndView();
		
		return model;
	}
	
	public ModelAndView listarFavoritos(){
		ModelAndView model = new ModelAndView();
		
		return model;
	}
	
}
