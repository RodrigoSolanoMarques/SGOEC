package br.edu.utfpr.tcc.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.edu.utfpr.tcc.dto.FormacaoDTO;
import lombok.Data;

@Entity
@Data
@Table
public class Formacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
//	@Column(nullable=true)
//	private Integer idMobile;
	
	@Column(length=100, nullable=false)
	private String nomeCurso;
	
	@Column(length=100, nullable=false)
	private String instituicao;
	
	@Column(nullable=true)
	private Integer periodo;
	
	@Column(nullable=true)
	private Boolean isConcluido;
	
	@Temporal(TemporalType.DATE)
	@Column(nullable=false)
	private Date dataInicial;
	
	@Temporal(TemporalType.DATE)
	@Column(nullable=true)
	private Date dataFinal;
	
  public Formacao converterFormacaoDTO(FormacaoDTO formacaoDTO) {

	  Formacao formacao = new Formacao();
      formacao.setId(formacaoDTO.getId());
      formacao.setIsConcluido(formacaoDTO.getConcluido());
      formacao.setDataFinal(formacaoDTO.getDataFinal());
      formacao.setDataInicial(formacaoDTO.getDataInicial());
      formacao.setInstituicao(formacaoDTO.getInstituicao());
      formacao.setNomeCurso(formacaoDTO.getNomeCurso());
      formacao.setPeriodo(formacaoDTO.getPeriodo());
          
      return formacao;
  }
	
}
