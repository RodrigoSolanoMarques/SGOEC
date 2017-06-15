package br.edu.utfpr.tcc.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ExperienciaProfissionalDTO {

	private long _id;
	private Long id;
	private String nomeEmpresa;
	private String cargo;
	private Boolean isAtual;
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date dataInicial;
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date dataFinal;
	private String atividades;
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
	public String getNomeEmpresa() {
		return nomeEmpresa;
	}
	public void setNomeEmpresa(String nomeEmpresa) {
		this.nomeEmpresa = nomeEmpresa;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public Boolean getIsAtual() {
		return isAtual;
	}
	public void setIsAtual(Boolean isAtual) {
		this.isAtual = isAtual;
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
	public String getAtividades() {
		return atividades;
	}
	public void setAtividades(String atividades) {
		this.atividades = atividades;
	}

}
