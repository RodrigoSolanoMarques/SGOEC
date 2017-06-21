package br.edu.utfpr.tcc.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.utfpr.tcc.dto.PessoaDTO;
import br.edu.utfpr.tcc.model.Pessoa;
import br.edu.utfpr.tcc.repository.PessoaRepository;

@RestController
@RequestMapping("/api/pessoa")
public class PessoaApi {
	

	@Autowired
	PessoaRepository pessoaRepository;
	
	@PostMapping("/salvar")
	public List<PessoaDTO> salve(@RequestBody List<PessoaDTO> pessoaDTOs){
		
		for(PessoaDTO pessoaX : pessoaDTOs){
			
			Pessoa pessoa = new Pessoa().converterPessoaDTO(pessoaX);
			pessoa = pessoaRepository.save(pessoa);
			
			pessoaX.setId(pessoa.getId());
		}
		return pessoaDTOs;	
	}

}
