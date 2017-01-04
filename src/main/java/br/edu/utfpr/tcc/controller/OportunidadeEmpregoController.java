package br.edu.utfpr.tcc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import br.edu.utfpr.tcc.model.AreaProfissional;
import br.edu.utfpr.tcc.model.ContaUsuario;
import br.edu.utfpr.tcc.model.Empregador;
import br.edu.utfpr.tcc.model.Empresa;
import br.edu.utfpr.tcc.model.Estado;
import br.edu.utfpr.tcc.model.OportunidadeEmprego;
import br.edu.utfpr.tcc.model.Pessoa;
import br.edu.utfpr.tcc.repository.AreaProfissionalRepository;
import br.edu.utfpr.tcc.repository.CargoRepository;
import br.edu.utfpr.tcc.repository.CidadeRepository;
import br.edu.utfpr.tcc.repository.EmpregadorRepository;
import br.edu.utfpr.tcc.repository.EmpresaRepository;
import br.edu.utfpr.tcc.repository.EstadoRepository;
import br.edu.utfpr.tcc.repository.OportunidadeEmpregoRepository;

@RestController
@RequestMapping(value = "/empresa/oportundadeemprego")
public class OportunidadeEmpregoController {

	@Autowired
	OportunidadeEmpregoRepository oportunidadeEmpregoRepository;
	
	@Autowired
	CidadeRepository cidadeRepository;
	
	@Autowired
	EstadoRepository estadoRepository;
	
	@Autowired
	CargoRepository cargoRepository;

	@Autowired
	EmpresaRepository empresaRepository;

	@Autowired
	EmpregadorRepository empregadorRepository;
	
	@Autowired
	AreaProfissionalRepository areaProfissionalRepository;

	@GetMapping
	public ModelAndView index() {
		ModelAndView model = new ModelAndView("/empresa/oportunidade-emprego/lista-oportunidades-emprego");

		model.addObject("listaCargo", cargoRepository.findAll());
		model.addObject("listaEstado", estadoRepository.findAll());
		model.addObject("listaCidade", cidadeRepository.findByEstado(new Estado(1L)));
		model.addObject("listaAreaProfissional", areaProfissionalRepository.findAll());

		ContaUsuario contaUsuario = (ContaUsuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Empregador empregador = empregadorRepository.findByContaUsuario(contaUsuario);
		
		model.addObject("empresa", empregador.getCargo().getEmpresa());
		model.addObject("empregador", empregador);
		
		return model;
	}

	@GetMapping("/alterar")
	public OportunidadeEmprego alterar(@RequestParam(name = "id", required = true)Long id){	
		
		return oportunidadeEmpregoRepository.findOne(id);
	}

	@GetMapping(value = "/listar")
	public List<OportunidadeEmprego> listar() {
		return oportunidadeEmpregoRepository.findAll();
	}
	
	@PostMapping("/salvar")
	public OportunidadeEmprego salvar(OportunidadeEmprego oportunidadeEmprego){
		
		if(oportunidadeEmprego.getId() != null && oportunidadeEmprego.getId() > 0){
			OportunidadeEmprego oportunidadeEmpregoAlterado = oportunidadeEmpregoRepository.findOne(oportunidadeEmprego.getId());
			oportunidadeEmpregoAlterado.setBeneficios(oportunidadeEmprego.getBeneficios());
			oportunidadeEmpregoAlterado.setDescricao(oportunidadeEmprego.getDescricao());
			return oportunidadeEmpregoRepository.save(oportunidadeEmpregoAlterado);
		}else{
			ContaUsuario contaUsuario = (ContaUsuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			Empregador empregador = empregadorRepository.findByContaUsuario(contaUsuario);
			oportunidadeEmprego.setEmpregador(empregador);
			return oportunidadeEmpregoRepository.save(oportunidadeEmprego);
		}		
	}
}
