package br.edu.utfpr.tcc.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.utfpr.tcc.model.Cargo;
import br.edu.utfpr.tcc.repository.CargoRepository;

@RestController
@RequestMapping("/api/cargo")
public class CargoApi {
	
	@Autowired
	CargoRepository cargoRepository;
	
	@GetMapping("/listar")
	public List<Cargo> listar(){		
		return cargoRepository.findAll();
	}

}
