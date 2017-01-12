package br.edu.utfpr.tcc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table
@Data
public class Candidato{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length=50, nullable=true)
	private String titulacao;
	
	@Column(length=100, nullable=false)
	private String areaProfissional;
	
	@Column(nullable=true)
	private Boolean isFavorito;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="idPessoa", referencedColumnName = "id")
	private Pessoa pessoa;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="idContaUsuario", referencedColumnName = "id")
	private ContaUsuario contaUsuario;
}
