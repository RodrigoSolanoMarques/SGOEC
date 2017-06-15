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

import br.edu.utfpr.tcc.dto.CidadeDTO;
import br.edu.utfpr.tcc.dto.EstadoDTO;
import lombok.Data;

@Entity
@Data
@Table
public class Cidade {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idEstado", referencedColumnName = "id")
	private Estado estado;
	
	@Column(length=100, nullable=false)
	private String nome;
	
	public Cidade converterCidadeDTO(CidadeDTO cidadeDTO) {

		Cidade cidade = new Cidade();
		cidade.setId(cidadeDTO.getId());
		cidade.setNome(cidadeDTO.getNome());
		
		Estado estado = new Estado().converterFormacaoDTO(cidadeDTO.getEstado());
		cidade.setEstado(estado);
	          
	      return cidade;
	  }
}
