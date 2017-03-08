package br.edu.utfpr.tcc.dto;

import br.edu.utfpr.tcc.model.Cidade;
import lombok.Data;

@Data
public class RegistroDTO {
	
	/* Dados da Empresa */
	private String razaoSocial;
	
	private String nomeFantasia;
	
	private Boolean isPessoaJuridica;
	
	private String cpfCnpj;

	private Cidade cidade;
	
	/* Dados do Usuário */
	private String nome;
	
	private String sobrenome;
	
	/* Dados da Conta */
	private String username;
	
	private String senha;
	
	private String compararSenha;
	
	private String email;

}
