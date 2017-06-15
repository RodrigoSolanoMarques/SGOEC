package br.edu.utfpr.tcc.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.utfpr.tcc.dto.ExperienciaProfissionalDTO;
import br.edu.utfpr.tcc.model.ExperienciaProfissional;
import br.edu.utfpr.tcc.repository.ExperienciaProfissionalRepository;

@RestController
@RequestMapping("/api/experienciaProfissional")
public class ExperienciaProfissionalApi {

	@Autowired
	ExperienciaProfissionalRepository experienciaProfissionalRepository;
	
	@PostMapping("/salvar")
	public List<ExperienciaProfissionalDTO> salve(@RequestBody List<ExperienciaProfissionalDTO> experienciaProfissionalDTOs){
		
		for(ExperienciaProfissionalDTO experienciaProfissionalX : experienciaProfissionalDTOs){
			
			ExperienciaProfissional experienciaProfissional = new ExperienciaProfissional().converterExperienciaProfissionalDTO(experienciaProfissionalX);
			experienciaProfissional = experienciaProfissionalRepository.save(experienciaProfissional);
			
			experienciaProfissionalX.setId(experienciaProfissional.getId());
		}
		return experienciaProfissionalDTOs;	
	}
}
