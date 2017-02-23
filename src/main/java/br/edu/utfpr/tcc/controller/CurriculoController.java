package br.edu.utfpr.tcc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import br.edu.utfpr.tcc.repository.CurriculoRepository;
import net.sf.jasperreports.engine.JRException;

@RestController
@RequestMapping(value = "/empresa/curriculo")
public class CurriculoController {
	
	
	@Autowired
	private CurriculoRepository curriculoRepository;

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
	
	@GetMapping(value = "/curriculoCanditadoPdf")
	public void curriculoCanditadoPdf(ModelMap model) throws JRException {
		
	}

}
