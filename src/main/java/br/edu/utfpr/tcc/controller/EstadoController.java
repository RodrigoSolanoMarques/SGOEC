package br.edu.utfpr.tcc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import br.edu.utfpr.tcc.model.Estado;
import br.edu.utfpr.tcc.repository.EstadoRepository;

@RestController
@RequestMapping("/estado")
public class EstadoController {

	@Autowired
	EstadoRepository estadoRepository;
	
	@GetMapping
	public ModelAndView home(){	
		
		return new ModelAndView("/empresa/cadastros-basicos/lista-estados");
	}
	
	@GetMapping("/listar")
	public List<Estado> listar(){				
		
		return estadoRepository.findAll();
	}
	
}
