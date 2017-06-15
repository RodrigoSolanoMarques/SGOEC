package br.edu.utfpr.tcc.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.utfpr.tcc.model.AreaProfissional;
import br.edu.utfpr.tcc.repository.AreaProfissionalRepository;

@RestController
@RequestMapping("/api/areaProfissional")
public class AreaProfissionalApi {
	
	@Autowired
	AreaProfissionalRepository areaProfissionalRepository;
	
	@GetMapping("/listar")
	public List<AreaProfissional> listarAreaProfissional(){		
		return areaProfissionalRepository.findAll();
	}

}
