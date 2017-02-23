package br.edu.utfpr.tcc.model;

import javax.persistence.Column;
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
public class OportunidadeEmprego {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idCidade", referencedColumnName = "id")
	private Cidade cidade;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idCargo", referencedColumnName = "id")
	private Cargo cargo;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idEmpregador", referencedColumnName = "id")
	private Empregador empregador;
	
	@Column(length=200, nullable=false)
	private String descricao;
	
	@Column(nullable=true)
	private Boolean isSalario;
	
	@Column(length=12, nullable=true)
	private String salario;
	
	@Column(length=50, nullable=false)
	private String cargaHoraria;
	
	@Column(length=255, nullable=true)
	private String beneficios;
	
	@Column(nullable=true)
	private Boolean isFinalizado;
	
	public OportunidadeEmprego(){
	}
	
	public OportunidadeEmprego(Long id){
		this.id = id;
	}
	
	

}
