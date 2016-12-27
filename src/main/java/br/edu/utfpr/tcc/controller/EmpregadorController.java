package br.edu.utfpr.tcc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.GsonBuilder;

import br.edu.utfpr.tcc.model.Empregador;
import br.edu.utfpr.tcc.model.Estado;
import br.edu.utfpr.tcc.repository.CargoRepository;
import br.edu.utfpr.tcc.repository.CidadeRepository;
import br.edu.utfpr.tcc.repository.EmpregadorRepository;
import br.edu.utfpr.tcc.repository.EstadoRepository;

@RestController
@RequestMapping(value="/empresa/empregador")
public class EmpregadorController {
	
	@Autowired
	EmpregadorRepository empregadorRepository;
	
	@Autowired
	EstadoRepository estadoRepository;
	
	@Autowired
	CidadeRepository cidadeRepository;
	
	@Autowired
	CargoRepository cargoRepository;
	
	@GetMapping
	public ModelAndView home(){	
		ModelAndView model = new ModelAndView("/empresa/cadastros-basicos/lista-empregadores");
		
		model.addObject("listaEstado", estadoRepository.findAll());
		model.addObject("listaCidade", cidadeRepository.findByEstado(new Estado(1L)));
		model.addObject("listaCargo", cargoRepository.findAll());
		
		return model;
	}
	
	@GetMapping("/alterar")
	public String alterar(@RequestParam(name = "id", required = true)Long id){				
		return new GsonBuilder().setDateFormat("dd/MM/yyy").create().toJson(empregadorRepository.findOne(id));
	}
	@PostMapping("/salvar")
	public String salvar(Empregador empregador){				
		
		return new GsonBuilder().setDateFormat("dd/MM/yyyy").create().toJson(empregadorRepository.save(empregador));
	}
	
	@GetMapping("/listar")
	public String listar(){						
		return new GsonBuilder().setDateFormat("dd/MM/yyyy").create().toJson(empregadorRepository.findAll());
	}
	
}
