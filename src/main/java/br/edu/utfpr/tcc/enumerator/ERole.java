package br.edu.utfpr.tcc.enumerator;

public enum ERole {
	ROLE_ADMIN(1L),
	ROLE_USER(2L),
	ROLE_CANDIDATO(3L),
	ROLE_EMPREGADOR(4L);
	
	public Long role;
	
	ERole(Long role){
		this.role = role;
	};
	
	public Long getValor(){
		return this.role;
	}
	
}
