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

import org.springframework.format.annotation.DateTimeFormat;

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
	
	@Column(nullable=false)
	private EStatusCurriculo status;
	
	@Column(nullable=false)
	private Boolean favorito;
	
	@Column(nullable=true)
	private Boolean isAceitaEntrevista;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy hh:mm:ss")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable=false)
	private Date dataCurriculoEnviado;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy hh:mm")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable=true)
	private Date dataEntrevista;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy hh:mm:ss")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable=true)
	private Date dataEncerramento;
	
}
