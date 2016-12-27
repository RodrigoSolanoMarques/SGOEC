package br.edu.utfpr.tcc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import br.edu.utfpr.tcc.model.Empresa;
import br.edu.utfpr.tcc.model.Estado;
import br.edu.utfpr.tcc.repository.CidadeRepository;
import br.edu.utfpr.tcc.repository.EmpresaRepository;
import br.edu.utfpr.tcc.repository.EstadoRepository;

@RestController
@RequestMapping(value="/empresa")
public class EmpresaController {
	
	@Autowired
	EstadoRepository estadoRepository;
	
	@Autowired
	CidadeRepository cidadeRepository;
	
	@Autowired
	EmpresaRepository empresaRepository;
	
	@GetMapping("/index")
	public ModelAndView index(){
		ModelAndView model = new ModelAndView("/empresa/index");
		return model;
	}
	
	@GetMapping()
	public ModelAndView home(){
		ModelAndView model = new ModelAndView("/empresa/cadastros-basicos/lista-empresas");
		model.addObject("listaEstado", estadoRepository.findAll());
		model.addObject("listaCidade", cidadeRepository.findByEstado(new Estado(1L)));
		return model;
	}

//	@GetMapping("/cadastrar")
//	public ModelAndView cadastrar(){
//		ModelAndView model = new ModelAndView("/empresa/cadastros-basicos/cadastro-empresa");
//		
//		return model;
//	}
	
	@PostMapping("/salvar")
	public Empresa salvar(Empresa empresa){				
		
		return empresaRepository.save(empresa);
	}
	
	@GetMapping("/alterar")
	public Empresa alterar(@RequestParam(name = "id", required = true)Long id){	
		
		return empresaRepository.findOne(id);
	}
	
	@GetMapping("/listar")
	public List<Empresa> listar(){				
		
		return empresaRepository.findAll();
	}
	
}
