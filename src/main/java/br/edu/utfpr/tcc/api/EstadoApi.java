package br.edu.utfpr.tcc.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.utfpr.tcc.model.Estado;
import br.edu.utfpr.tcc.repository.EstadoRepository;

@RestController
@RequestMapping("/api/estado")
public class EstadoApi {
	
	@Autowired
	EstadoRepository estadoRepository;
	
	@GetMapping("/listar")
	public List<Estado> listar(){		
		return estadoRepository.findAll();
	}

}
