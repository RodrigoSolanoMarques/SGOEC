package br.edu.utfpr.tcc.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.utfpr.tcc.dto.ContaUsuarioDTO;
import br.edu.utfpr.tcc.model.ContaUsuario;
import br.edu.utfpr.tcc.repository.ContaUsuarioRepository;

@RestController
@RequestMapping("/api/contaUsuario")
public class ContaUsuarioApi {
	

	@Autowired
	ContaUsuarioRepository contaUsuarioRepository;
	
	@PostMapping("/salvar")
	public List<ContaUsuarioDTO> salve(@RequestBody List<ContaUsuarioDTO> contaUsuarioDTOs){
		
		for(ContaUsuarioDTO contaUsuarioX : contaUsuarioDTOs){
			
			ContaUsuario contaUsuario = new ContaUsuario().converterContaUsuarioDTO(contaUsuarioX);
			contaUsuario = contaUsuarioRepository.save(contaUsuario);
			
			contaUsuarioX.setId(contaUsuario.getId());
		}
		return contaUsuarioDTOs;	
	}

}
