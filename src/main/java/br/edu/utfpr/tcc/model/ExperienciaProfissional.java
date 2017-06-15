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
import br.edu.utfpr.tcc.dto.ExperienciaProfissionalDTO;
import lombok.Data;

@Entity
@Data
@Table
public class ExperienciaProfissional {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
//	@Column(nullable=true)
//	private Integer idMobile;
	
	@Column(length=100, nullable=false)
	private String nomeEmpresa;
	
	@Column(length=100, nullable=false)
	private String Cargo;
	
	@Column(nullable=false)
	private Boolean isAtual;
	
	@Temporal(TemporalType.DATE)
	@Column(nullable=false)
	private Date dataInicial;
	
	@Temporal(TemporalType.DATE)
	@Column(nullable=true)
	private Date dataFinal;
	
	@Column(length=200, nullable=true)
	private String atividades;
	
	public ExperienciaProfissional converterExperienciaProfissionalDTO(ExperienciaProfissionalDTO experienciaProfissionalDTO) {

		ExperienciaProfissional experienciaProfissional = new ExperienciaProfissional();
		
		experienciaProfissional.setId(experienciaProfissionalDTO.getId());
		experienciaProfissional.setNomeEmpresa(experienciaProfissionalDTO.getNomeEmpresa());
		experienciaProfissional.setDataFinal(experienciaProfissionalDTO.getDataFinal());
		experienciaProfissional.setDataInicial(experienciaProfissionalDTO.getDataInicial());
		experienciaProfissional.setIsAtual(experienciaProfissionalDTO.getIsAtual());
		experienciaProfissional.setAtividades(experienciaProfissionalDTO.getAtividades());
		experienciaProfissional.setCargo(experienciaProfissionalDTO.getCargo());
	          
	    return experienciaProfissional;
	  }
}
