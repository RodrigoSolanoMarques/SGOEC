package br.edu.utfpr.tcc.model;

import java.util.List;

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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table
public class Curriculo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
//	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//	@JoinColumn(name = "idOportunidadeEmprego", referencedColumnName = "id")
//	private OportunidadeEmprego oportunidadeEmprego;
	
//	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//	@JoinColumn(name = "idEmpregador", referencedColumnName = "id")
//	private Empregador empregador;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idCandidato", referencedColumnName = "id")
	private Candidato candidato;
	
	@ManyToMany
	@JoinTable(name="CurriculoFormacao",joinColumns =
	{@JoinColumn(name = "idCurriculo")}, inverseJoinColumns =
	{@JoinColumn(name = "idFormacao")})
	private List<Formacao> formacoes;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="CurriculoCursoComplementar",joinColumns =
	{@JoinColumn(name = "idCurriculo")}, inverseJoinColumns =
	{@JoinColumn(name = "idCursoComplementar")})
	private List<CursoComplementar> cursoComplementares;
	
	@ManyToMany
	@JoinTable(name="CurriculoExperienciaProfissional",joinColumns =
	{@JoinColumn(name = "idCurriculo")}, inverseJoinColumns =
	{@JoinColumn(name = "idExperienciaProfissional")})
	private List<ExperienciaProfissional> experienciasProfissionais;
	
	@Column(length=100, nullable=false)
	private String objetivoAreaAtuar;
	
	@Column(length=200,nullable=true)
	private String conhecimentosGerais;
	
	@Column(length=200,nullable=true)
	private String conhecimentosInformatica;	
	
	@OneToOne(mappedBy = "curriculo")
    private AvaliacaoCurriculo avaliacaoCurriculo;

}