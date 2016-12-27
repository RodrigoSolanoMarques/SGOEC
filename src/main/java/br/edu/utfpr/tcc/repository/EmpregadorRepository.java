package br.edu.utfpr.tcc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.utfpr.tcc.model.ContaUsuario;
import br.edu.utfpr.tcc.model.Empregador;

public interface EmpregadorRepository extends JpaRepository<Empregador, Long>{
	
	public Empregador findByContaUsuario(ContaUsuario contaUsuario);

}
