package br.edu.utfpr.tcc.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.utfpr.tcc.dto.CursoComplementarDTO;
import br.edu.utfpr.tcc.model.CursoComplementar;
import br.edu.utfpr.tcc.repository.CursoComplementarRepository;

@RestController
@RequestMapping("/api/cursoComplementar")
public class CursoComplementarApi {
	

	@Autowired
	CursoComplementarRepository cursoComplementarRepository;
	
	@PostMapping("/salvar")
	public List<CursoComplementarDTO> salve(@RequestBody List<CursoComplementarDTO> cursoComplementarDTOs){
		
		for(CursoComplementarDTO cursoComplementarX : cursoComplementarDTOs){
			
			CursoComplementar cursoComplementar = new CursoComplementar().converterCursoComplementarDTO(cursoComplementarX);
			cursoComplementar = cursoComplementarRepository.save(cursoComplementar);
			
			cursoComplementarX.setId(cursoComplementar.getId());
		}
		return cursoComplementarDTOs;	
	}

}
