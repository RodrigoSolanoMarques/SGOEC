package br.edu.utfpr.tcc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.edu.utfpr.tcc.model.ContaUsuario;
import br.edu.utfpr.tcc.repository.ContaUsuarioRepository;

@Service
public class ContaUsuarioService implements UserDetailsService {
	
	private ContaUsuarioRepository contaUsuarioRepository;
	
	@Autowired
	public ContaUsuarioService(ContaUsuarioRepository contaUsuarioRepository) {
		this.contaUsuarioRepository = contaUsuarioRepository;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		ContaUsuario contaUsuario = contaUsuarioRepository.findByUsername(username);				
		
		if(contaUsuario == null){
			throw new UsernameNotFoundException("Login inválido!");
		}
		return contaUsuario;
	}
}
