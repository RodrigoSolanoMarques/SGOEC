package br.edu.utfpr.tcc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table
public class Estado {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length=100, nullable=false)
	private String nome;
	
	@Column(length=2, nullable=false)
	private String uf;

	public Estado() {
		super();
	}
	
	public Estado(Long id) {
		super();
		this.id = id;
	}	

}
