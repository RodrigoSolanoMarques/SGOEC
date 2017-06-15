package br.edu.utfpr.tcc.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import br.edu.utfpr.tcc.dto.PessoaDTO;
import lombok.Data;

@Entity
@Data
public class Pessoa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idCidade", referencedColumnName = "id")
	private Cidade cidade;
	
	@Column(length=100, nullable=false)
	private String nome;
	
	@Column(length=100, nullable=false)
	private String sobrenome;
	
	@Column(length=18, nullable=true)
	private String cpf;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date dataNascimento;
	
	@Column(length=18, nullable=true)
	private String telefone1;	
	
	@Column(length=18, nullable=true)
	private String telefone2;
	
	@Column(length=18, nullable=true)
	private String celular1;
	
	@Column(length=18, nullable=true)
	private String celular2;
	
	@Column(length=100, nullable=true)
	private String rua;
	
	@Column(nullable=true)
	private Integer numero;
	
	@Column(length=50, nullable=true)
	private String bairro;
	
	@Column(length=15, nullable=true)
	private String cep;
	
	@Column(length=255, nullable=true)
	private String complemento;
	
	@Column(length=255, nullable=true)
	private String foto;
	
	public Pessoa converterPessoaDTO(PessoaDTO pessoaDTO) {

		Pessoa pessoa = new Pessoa();
		pessoa.setId(pessoaDTO.getId());
		pessoa.setBairro(pessoaDTO.getBairro());
		pessoa.setCelular1(pessoaDTO.getCelular1());
		pessoa.setCelular2(pessoaDTO.getCelular2());
		pessoa.setCep(pessoaDTO.getCep());
		pessoa.setComplemento(pessoaDTO.getComplemento());
		pessoa.setCpf(pessoaDTO.getCpf());
		pessoa.setDataNascimento(pessoaDTO.getDataNascimento());
		pessoa.setFoto(pessoaDTO.getFoto());
		pessoa.setNome(pessoaDTO.getNome());
		pessoa.setNumero(pessoaDTO.getNumero());
		pessoa.setRua(pessoaDTO.getRua());
		pessoa.setSobrenome(pessoaDTO.getSobrenome());
		pessoa.setTelefone1(pessoaDTO.getTelefone1());
		pessoa.setTelefone2(pessoaDTO.getTelefone2());
		
		Cidade cidade = new Cidade().converterCidadeDTO(pessoaDTO.getCidade());
		pessoa.setCidade(cidade);
	          
	      return pessoa;
	  }

}
