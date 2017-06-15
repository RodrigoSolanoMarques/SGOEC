package br.edu.utfpr.tcc.dto;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class FormacaoDTO implements Serializable {
	
    private long _id;
    private Long id;
    private Integer periodo;
    private String nomeCurso;
    private String instituicao;
    @JsonFormat(pattern="dd/MM/yyyy")
    private Date dataInicial;
    @JsonFormat(pattern="dd/MM/yyyy")
    private Date dataFinal;
    private Boolean isConcluido;

    public FormacaoDTO() {
    }

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

    public Boolean getConcluido() {
        return isConcluido;
    }

    public void setConcluido(Boolean concluido) {
        isConcluido = concluido;
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

    public Integer getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Integer periodo) {
        this.periodo = periodo;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FormacaoDTO formacao = (FormacaoDTO) o;

        if (id != null ? !id.equals(formacao.id) : formacao.id != null) return false;
        if (nomeCurso != null ? !nomeCurso.equals(formacao.nomeCurso) : formacao.nomeCurso != null)
            return false;
        if (instituicao != null ? !instituicao.equals(formacao.instituicao) : formacao.instituicao != null)
            return false;
        if (dataInicial != null ? !dataInicial.equals(formacao.dataInicial) : formacao.dataInicial != null)
            return false;
        return dataFinal != null ? dataFinal.equals(formacao.dataFinal) : formacao.dataFinal == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (nomeCurso != null ? nomeCurso.hashCode() : 0);
        result = 31 * result + (instituicao != null ? instituicao.hashCode() : 0);
        result = 31 * result + (dataInicial != null ? dataInicial.hashCode() : 0);
        result = 31 * result + (dataFinal != null ? dataFinal.hashCode() : 0);
        return result;
    }
   

}
