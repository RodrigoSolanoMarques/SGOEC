package br.edu.utfpr.tcc.enumerator;

public enum EStatusCurriculo {

	APROVADO(1),
	REPROVADO(2),
	AGUARDANDO(3),
	AVALIADO(4),
	LISTAFAVORITOS(5),
	LISTAESPERA(6);
	
	public Integer status;
	
	EStatusCurriculo(Integer status){
		this.status = status;
	};
	
	public Integer getValor(){
		return this.status;
	}
}
