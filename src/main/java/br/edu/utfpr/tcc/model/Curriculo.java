package br.edu.utfpr.tcc.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.edu.utfpr.tcc.dto.CurriculoDTO;
import br.edu.utfpr.tcc.dto.CursoComplementarDTO;
import br.edu.utfpr.tcc.dto.ExperienciaProfissionalDTO;
import br.edu.utfpr.tcc.dto.FormacaoDTO;
import lombok.Data;

@Entity
@Data
@Table
public class Curriculo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idCandidato", referencedColumnName = "id")
	private Candidato candidato;

	@ManyToMany
	@JoinTable(name = "CurriculoFormacao", joinColumns = { @JoinColumn(name = "idCurriculo") }, inverseJoinColumns = {
			@JoinColumn(name = "idFormacao") })
	private Set<Formacao> formacoes;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "CurriculoCursoComplementar", joinColumns = {
			@JoinColumn(name = "idCurriculo") }, inverseJoinColumns = { @JoinColumn(name = "idCursoComplementar") })
	private Set<CursoComplementar> cursoComplementares;

	@ManyToMany
	@JoinTable(name = "CurriculoExperienciaProfissional", joinColumns = @JoinColumn(name = "idCurriculo", referencedColumnName = "id") , inverseJoinColumns = @JoinColumn(name = "idExperienciaProfissional", referencedColumnName = "id") )
	private Set<ExperienciaProfissional> experienciasProfissionais;

	@Column(length = 100, nullable = false)
	private String objetivoAreaAtuar;

	@Column(length = 200, nullable = true)
	private String conhecimentosGerais;

	@Column(length = 200, nullable = true)
	private String conhecimentosInformatica;

	public Curriculo() {
	}

	public Curriculo(Long id) {
		this.id = id;
	}

	public Curriculo converterCurriculoDTO(CurriculoDTO curriculoDTO) {

		Curriculo curriculo = new Curriculo();

		curriculo.setId(curriculoDTO.getId());
		curriculo.setObjetivoAreaAtuar(curriculoDTO.getObjetivoAreaAtuar());
		curriculo.setConhecimentosGerais(curriculoDTO.getConhecimentosGerais());
		curriculo.setConhecimentosInformatica(curriculoDTO.getConhecimentosInformatica());

		Candidato candidato = new Candidato().converterCandidatoDTO(curriculoDTO.getCandidato());
		curriculo.setCandidato(candidato);

		Set<CursoComplementar> cursoComplementars = new HashSet<>();
		for (CursoComplementarDTO cursoComplementarDTO : curriculoDTO.getCursoComplementares()) {
			CursoComplementar cursoComplementar = new CursoComplementar()
					.converterCursoComplementarDTO(cursoComplementarDTO);
			
			cursoComplementars.add(cursoComplementar);
		}
		
		Set<Formacao> formacoes = new HashSet<>();
		for (FormacaoDTO formacaoDTO : curriculoDTO.getFormacoes()) {
			Formacao formacao = new Formacao()
					.converterFormacaoDTO(formacaoDTO);
			
			formacoes.add(formacao);
		}
		
		Set<ExperienciaProfissional> experienciaProfissionals = new HashSet<>();
		for (ExperienciaProfissionalDTO experienciaProfissionalDTO : curriculoDTO.getExperienciasProfissionais()) {
			ExperienciaProfissional experienciaProfissional = new ExperienciaProfissional()
					.converterExperienciaProfissionalDTO(experienciaProfissionalDTO);
			
			experienciaProfissionals.add(experienciaProfissional);
		}
		curriculo.setCursoComplementares(cursoComplementars);
		curriculo.setFormacoes(formacoes);
		curriculo.setExperienciasProfissionais(experienciaProfissionals);

		return curriculo;
	}

}
