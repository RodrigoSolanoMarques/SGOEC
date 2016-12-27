package br.edu.utfpr.tcc.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Entity
@Data
public class Pessoa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idCidade", referencedColumnName = "id")
	private Cidade cidade;
	
	@Column(length=100, nullable=false)
	private String nome;
	
	@Column(length=100, nullable=false)
	private String sobrenome;
	
	@Column(length=18, nullable=false)
	private String cpf;
	
	@Temporal(TemporalType.DATE)
	private Date dataNascimento;
	
	@Column(length=18, nullable=true)
	private String telefone1;	
	
	@Column(length=18, nullable=true)
	private String telefone2;
	
	@Column(length=18, nullable=true)
	private String celular1;
	
	@Column(length=18, nullable=true)
	private String celular2;
	
	@Column(length=100, nullable=false)
	private String rua;
	
	@Column(nullable=false)
	private Integer numero;
	
	@Column(length=50, nullable=false)
	private String bairro;
	
	@Column(length=15, nullable=false)
	private String cep;
	
	@Column(length=255, nullable=true)
	private String complemento;
	
	

}
