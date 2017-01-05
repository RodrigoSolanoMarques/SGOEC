package br.edu.utfpr.tcc.controller;

import java.util.List;

import org.apache.hadoop.mapred.gethistory_jsp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import br.edu.utfpr.tcc.model.Cargo;
import br.edu.utfpr.tcc.model.ContaUsuario;
import br.edu.utfpr.tcc.model.Empregador;
import br.edu.utfpr.tcc.model.Empresa;
import br.edu.utfpr.tcc.model.Pessoa;
import br.edu.utfpr.tcc.repository.AreaProfissionalRepository;
import br.edu.utfpr.tcc.repository.CargoRepository;
import br.edu.utfpr.tcc.repository.EmpregadorRepository;

@RestController
@RequestMapping("/empresa/cargo")
public class CargoController {
	
	@Autowired
	CargoRepository cargoRepository;
	
	@Autowired
	EmpregadorRepository empregadorRepository;
	
	@Autowired
	AreaProfissionalRepository areaProfissionalRepository;
	
	@GetMapping
	public ModelAndView home(){	
		ModelAndView model = new ModelAndView("/empresa/cadastros-basicos/lista-cargos");
		model.addObject("listaAreaProfissional", areaProfissionalRepository.findAll());
		
		return model;
	}

	@GetMapping("/cadastrar")
	public ModelAndView cadastrar(){				
		
		return new ModelAndView("/empresa/cadastros-basicos/cadastro-cargo");
	}
	
	@GetMapping("/alterar")
	public Cargo alterar(@RequestParam(name = "id", required = true)Long id){				
		
		return cargoRepository.findOne(id);
	}
	
	@PostMapping("/salvar")
	public Cargo salvar(Cargo cargo){				
		ContaUsuario contaUsuario = (ContaUsuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		Empregador empregador = empregadorRepository.findByContaUsuario(contaUsuario);
		
		Empresa empresa = empregador.getCargo().getEmpresa();
		cargo.setEmpresa(empresa);
		
		return cargoRepository.save(cargo);
	}
	
	@GetMapping("/listar")
	public List<Cargo> listar(){				
		
		return cargoRepository.findAll();
	}

}
