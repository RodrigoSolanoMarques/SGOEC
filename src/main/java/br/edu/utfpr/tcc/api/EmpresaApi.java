package br.edu.utfpr.tcc.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.utfpr.tcc.model.Empresa;
import br.edu.utfpr.tcc.repository.EmpresaRepository;

@RestController
@RequestMapping("/api/empresa")
public class EmpresaApi {
	
	@Autowired
	EmpresaRepository empresaRepository;
	
	@GetMapping("/listar")
	public List<Empresa> listar(){		
		return empresaRepository.findAll();
	}

}
