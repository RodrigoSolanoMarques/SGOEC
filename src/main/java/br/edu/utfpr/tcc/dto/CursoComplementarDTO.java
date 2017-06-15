package br.edu.utfpr.tcc.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class CursoComplementarDTO {

	private long _id;
	private Long id;
	private Integer periodo;
	private String nomeCurso;
	private String instituicao;
	private Boolean isConcluido;
	
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date dataInicial;
	
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date dataFinal;

	public long get_id() {
		return _id;
	}

	public void set_id(long _id) {
		this._id = _id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getPeriodo() {
		return periodo;
	}

	public void setPeriodo(Integer periodo) {
		this.periodo = periodo;
	}

	public String getNomeCurso() {
		return nomeCurso;
	}

	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}

	public String getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(String instituicao) {
		this.instituicao = instituicao;
	}

	public Boolean getIsConcluido() {
		return isConcluido;
	}

	public void setIsConcluido(Boolean isConcluido) {
		this.isConcluido = isConcluido;
	}

	public Date getDataInicial() {
		return dataInicial;
	}

	public void setDataInicial(Date dataInicial) {
		this.dataInicial = dataInicial;
	}

	public Date getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(Date dataFinal) {
		this.dataFinal = dataFinal;
	}
	
	
	

}
