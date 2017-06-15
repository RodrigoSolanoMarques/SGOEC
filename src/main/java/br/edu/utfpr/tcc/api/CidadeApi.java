package br.edu.utfpr.tcc.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.utfpr.tcc.model.Cidade;
import br.edu.utfpr.tcc.repository.CidadeRepository;

@RestController
@RequestMapping("/api/cidade")
public class CidadeApi {
	
	@Autowired
	CidadeRepository cidadeRepository;
	
	@GetMapping("/listar")
	public List<Cidade> listar(){
		return cidadeRepository.findAll();
	}

}
