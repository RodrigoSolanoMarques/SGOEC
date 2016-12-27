package br.edu.utfpr.tcc.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class Empregador{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idCargo", referencedColumnName = "id")
	private Cargo cargo;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="idPessoa", referencedColumnName = "id")
	private Pessoa pessoa;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="idContaUsuario", referencedColumnName = "id")
	private ContaUsuario contaUsuario;

}
