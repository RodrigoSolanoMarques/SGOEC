package br.edu.utfpr.tcc.dto;

import java.util.List;

public class CurriculoDTO {
	

	private Long _id;
	private Long id;
    private Long idCandidato;
	private String objetivoAreaAtuar;
	private String conhecimentosGerais;
	private String conhecimentosInformatica;
	private CandidatoDTO candidato;
	private List<FormacaoDTO> formacoes;
	private List<CursoComplementarDTO> cursoComplementares;
	private List<ExperienciaProfissionalDTO> experienciasProfissionais;
	public Long get_id() {
		return _id;
	}
	public void set_id(Long _id) {
		this._id = _id;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getIdCandidato() {
		return idCandidato;
	}
	public void setIdCandidato(Long idCandidato) {
		this.idCandidato = idCandidato;
	}
	public String getObjetivoAreaAtuar() {
		return objetivoAreaAtuar;
	}
	public void setObjetivoAreaAtuar(String objetivoAreaAtuar) {
		this.objetivoAreaAtuar = objetivoAreaAtuar;
	}
	public String getConhecimentosGerais() {
		return conhecimentosGerais;
	}
	public void setConhecimentosGerais(String conhecimentosGerais) {
		this.conhecimentosGerais = conhecimentosGerais;
	}
	public String getConhecimentosInformatica() {
		return conhecimentosInformatica;
	}
	public void setConhecimentosInformatica(String conhecimentosInformatica) {
		this.conhecimentosInformatica = conhecimentosInformatica;
	}
	public List<FormacaoDTO> getFormacoes() {
		return formacoes;
	}
	public void setFormacoes(List<FormacaoDTO> formacoes) {
		this.formacoes = formacoes;
	}
	public List<CursoComplementarDTO> getCursoComplementares() {
		return cursoComplementares;
	}
	public void setCursoComplementares(List<CursoComplementarDTO> cursoComplementares) {
		this.cursoComplementares = cursoComplementares;
	}
	public List<ExperienciaProfissionalDTO> getExperienciasProfissionais() {
		return experienciasProfissionais;
	}
	public void setExperienciasProfissionais(List<ExperienciaProfissionalDTO> experienciasProfissionais) {
		this.experienciasProfissionais = experienciasProfissionais;
	}
	public CandidatoDTO getCandidato() {
		return candidato;
	}
	public void setCandidato(CandidatoDTO candidato) {
		this.candidato = candidato;
	}
	
}
