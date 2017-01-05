package br.edu.utfpr.tcc.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.edu.utfpr.tcc.enumerator.EStatusCurriculo;
import lombok.Data;

@Entity
@Data
@Table
public class AvaliacaoCurriculo {

	// Essa clase será a classe criado quando o usuário enviar o curriculo
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idOportunidadeEmprego", referencedColumnName = "id")
	private OportunidadeEmprego oportunidadeEmprego;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idCurriculo", referencedColumnName = "id")
	private Curriculo curriculo;
	
//	@OneToOne(fetch = FetchType.EAGER)
//	@JoinColumn(name = "idEmpregador", referencedColumnName = "id")
//	private Empregador empregador;
	
	@Column(nullable=true)
	private EStatusCurriculo status;
	
	@Column(nullable=false)
	private Boolean isFavorito;
	
	@Temporal(TemporalType.DATE)
	private Date dataCurriculoEnviado;
	
	@Temporal(TemporalType.DATE)
	private Date dataEntrevista;
	
	@Temporal(TemporalType.DATE)
	private Date dataEncerramento;
	
}
