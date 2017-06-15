package br.edu.utfpr.tcc.enumerator;

public enum ESimNao {

	NAO(0),
	SIM(1);
	
	public Integer simNao;
	
	ESimNao(Integer simNao){
		this.simNao = simNao;
	};
	
	public Integer getValor(){
		return this.simNao;
	}
}
