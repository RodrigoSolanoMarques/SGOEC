package br.edu.utfpr.tcc.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.utfpr.tcc.model.OportunidadeEmprego;
import br.edu.utfpr.tcc.repository.OportunidadeEmpregoRepository;

@RestController
@RequestMapping("/api/oportunidadeEmprego")
public class OportunidadeEmpregoApi {

	@Autowired
	OportunidadeEmpregoRepository oportunidadeEmpregoRepository;
	
	@GetMapping("/listar")
	public List<OportunidadeEmprego> listar(){
		return oportunidadeEmpregoRepository.findAll();
	}
	
	@GetMapping("/listarOportunidadeEmpregoByAreaProfissional")
	public List<OportunidadeEmprego> listar(Long idAreaProfissional){
		return oportunidadeEmpregoRepository.findByCargoAreaProfissionalId(idAreaProfissional);
	}
	
}
