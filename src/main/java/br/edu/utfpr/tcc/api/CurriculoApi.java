package br.edu.utfpr.tcc.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.utfpr.tcc.dto.CurriculoDTO;
import br.edu.utfpr.tcc.model.Curriculo;
import br.edu.utfpr.tcc.repository.CurriculoRepository;

@RestController
@RequestMapping("/api/curriculo")
public class CurriculoApi {
	

	@Autowired
	CurriculoRepository curriculoRepository;
	
	@PostMapping("/salvar")
	public List<CurriculoDTO> salve(@RequestBody List<CurriculoDTO> curriculoDTOs){
		
		for(CurriculoDTO curriculoX : curriculoDTOs){
			
			Curriculo curriculo = new Curriculo().converterCurriculoDTO(curriculoX);
			curriculo = curriculoRepository.save(curriculo);
			
			curriculoX.setId(curriculo.getId());
		}
		return curriculoDTOs;	
	}

}
