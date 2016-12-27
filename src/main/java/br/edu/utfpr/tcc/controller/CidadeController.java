package br.edu.utfpr.tcc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import br.edu.utfpr.tcc.model.Cidade;
import br.edu.utfpr.tcc.model.Estado;
import br.edu.utfpr.tcc.repository.CidadeRepository;

@RestController
@RequestMapping("/cidade")
public class CidadeController {
	
	@Autowired
	CidadeRepository cidadeRepository;
	
	@GetMapping
	public ModelAndView home(){	
		
		return new ModelAndView("/empresa/cadastros-basicos/lista-cidades");
	}
	
	@GetMapping("/listar")
	public List<Cidade> listar(){				
		
		return cidadeRepository.findAll();
	}
	
	@GetMapping("/carregarCidadePorEstado/{idEstado}")
	public List<Cidade> carregarCidadePorEstado(@PathVariable("idEstado") Long idEstado){		
		return cidadeRepository.findByEstado(new Estado(idEstado));
	}
	
	

}
