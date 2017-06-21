package br.edu.utfpr.tcc.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.utfpr.tcc.dto.CandidatoDTO;
import br.edu.utfpr.tcc.model.Candidato;
import br.edu.utfpr.tcc.repository.CandidatoRepository;

@RestController
@RequestMapping("/api/candidato")
public class CandidatoApi {
	

	@Autowired
	CandidatoRepository candidatoRepository;
	
	@PostMapping("/salvar")
	public List<CandidatoDTO> salve(@RequestBody List<CandidatoDTO> candidatoDTOs){
		
		for(CandidatoDTO candidatoX : candidatoDTOs){
			
			Candidato candidato = new Candidato().converterCandidatoDTO(candidatoX);
			candidato = candidatoRepository.save(candidato);
			
			candidatoX.setId(candidato.getId());
		}
		return candidatoDTOs;	
	}

}
