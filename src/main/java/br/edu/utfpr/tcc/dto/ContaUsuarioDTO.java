package br.edu.utfpr.tcc.dto;

public class ContaUsuarioDTO {

    private Long _id;
    private Long id;
    private String username;
    private String senha;
    private String email;
    private String pathImagem;
    
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
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPathImagem() {
		return pathImagem;
	}
	public void setPathImagem(String pathImagem) {
		this.pathImagem = pathImagem;
	}
 }
