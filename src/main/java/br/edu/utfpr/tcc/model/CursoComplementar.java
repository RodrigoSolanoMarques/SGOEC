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

import br.edu.utfpr.tcc.dto.CursoComplementarDTO;
import br.edu.utfpr.tcc.dto.FormacaoDTO;
import lombok.Data;

@Entity
@Data
@Table
public class CursoComplementar {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
//	@Column(nullable=true)
//	private Integer idMobile;
	
	@Column(length=100, nullable=false)
	private String nomeCurso;
	
	@Column(length=100, nullable=false)
	private String instituicao;
	
	@Column(nullable=false)
	private Boolean isConcluido;
	
	@Temporal(TemporalType.DATE)
	@Column(nullable=false)
	private Date dataInicial;
	
	@Temporal(TemporalType.DATE)
	@Column(nullable=true)
	private Date dataFinal;
	
	@Column(nullable=true)
	private Integer periodo;
	
	public CursoComplementar converterCursoComplementarDTO(CursoComplementarDTO cursoComplementarDTO) {

		CursoComplementar cursoComplementar = new CursoComplementar();
		
		cursoComplementar.setId(cursoComplementarDTO.getId());
		cursoComplementar.setIsConcluido(cursoComplementarDTO.getIsConcluido());
		cursoComplementar.setDataFinal(cursoComplementarDTO.getDataFinal());
		cursoComplementar.setDataInicial(cursoComplementarDTO.getDataInicial());
		cursoComplementar.setInstituicao(cursoComplementarDTO.getInstituicao());
		cursoComplementar.setNomeCurso(cursoComplementarDTO.getNomeCurso());
		cursoComplementar.setPeriodo(cursoComplementarDTO.getPeriodo());
	          
	      return cursoComplementar;
	  }
}
