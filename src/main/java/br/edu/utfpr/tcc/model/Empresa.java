package br.edu.utfpr.tcc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table
public class Empresa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length=100, nullable=false)
	private String razaoSocial;
	
	@Column(length=100, nullable=false)
	private String nomeFantasia;
	
	@Column(length=100, nullable=true)
	private String missao;
	
	@Column(length=100, nullable=true)
	private String visao;
	
	@Column(length=100, nullable=true)
	private String valores;
	
	@Column(nullable=false)
	private Boolean isPessoaJuridica;
	
	@Column(length=18, nullable=false)
	private String cpfCnpj;
	
	@Column(length=20, nullable=true)
	private String inscricaoEstadual;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idCidade", referencedColumnName = "id")
	private Cidade cidade;

}
