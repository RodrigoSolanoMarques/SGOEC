package br.edu.utfpr.tcc.dto;

public class CandidatoDTO {
	
	private Long _id;
	private Long id;
	private Long idPessoa;
	private Long idContaUsuario;
	private String titulacao;
	private String areaProfissional;
	private PessoaDTO pessoa;
	private ContaUsuarioDTO contaUsuario;
	
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
	public Long getIdPessoa() {
		return idPessoa;
	}
	public void setIdPessoa(Long idPessoa) {
		this.idPessoa = idPessoa;
	}
	public Long getIdContaUsuario() {
		return idContaUsuario;
	}
	public void setIdContaUsuario(Long idContaUsuario) {
		this.idContaUsuario = idContaUsuario;
	}
	public String getTitulacao() {
		return titulacao;
	}
	public void setTitulacao(String titulacao) {
		this.titulacao = titulacao;
	}
	public String getAreaProfissional() {
		return areaProfissional;
	}
	public void setAreaProfissional(String areaProfissional) {
		this.areaProfissional = areaProfissional;
	}
	public PessoaDTO getPessoa() {
		return pessoa;
	}
	public void setPessoa(PessoaDTO pessoa) {
		this.pessoa = pessoa;
	}
	public ContaUsuarioDTO getContaUsuario() {
		return contaUsuario;
	}
	public void setContaUsuario(ContaUsuarioDTO contaUsuario) {
		this.contaUsuario = contaUsuario;
	}
	
	

}
