package br.edu.utfpr.tcc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.edu.utfpr.tcc.dto.EstadoDTO;
import br.edu.utfpr.tcc.dto.FormacaoDTO;
import lombok.Data;

@Entity
@Data
@Table
public class Estado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 100, nullable = false)
	private String nome;

	@Column(length = 2, nullable = false)
	private String uf;

	public Estado() {
		super();
	}

	public Estado(Long id) {
		super();
		this.id = id;
	}

	public Estado converterFormacaoDTO(EstadoDTO estadoDTO) {

		Estado estado = new Estado();
		estado.setId(estadoDTO.get_id());
		estado.setNome(estadoDTO.getNome());
		estado.setUf(estadoDTO.getUf());

		return estado;
	}

}
