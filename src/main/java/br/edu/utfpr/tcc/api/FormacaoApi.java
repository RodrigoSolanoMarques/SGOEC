package br.edu.utfpr.tcc.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.utfpr.tcc.dto.FormacaoDTO;
import br.edu.utfpr.tcc.model.Formacao;
import br.edu.utfpr.tcc.repository.FormacaoRepository;

@RestController
@RequestMapping("/api/formacao")
public class FormacaoApi {
	
	@Autowired
	FormacaoRepository formacaoRepository;
	
	@PostMapping("/salvar")
	public List<FormacaoDTO> salvar(@RequestBody List<FormacaoDTO> formacaoDTOs){
		
		for(FormacaoDTO formacaoX : formacaoDTOs){
			
			Formacao formacao = new Formacao().converterFormacaoDTO(formacaoX);
			formacao = formacaoRepository.save(formacao);
			
			formacaoX.setId(formacao.getId());
		}
		return formacaoDTOs;	
	}

}
