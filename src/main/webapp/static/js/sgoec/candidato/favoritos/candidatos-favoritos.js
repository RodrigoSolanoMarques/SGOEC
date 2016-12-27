var oportunidadeEmpregoCadastrar = {
};

/*====================================================
****************** Carregar Tela *********************
====================================================*/
$(function(){
	debugger
	ajaxCandidatos.listarCandidatosFavoritos();
});

/*====================================================
****************** Data Formatter ********************
====================================================*/
function nomeCompletoFormatter(value, row) {
    return row.candidato.pessoa.nome + " " + row.candidato.pessoa.sobrenome;
}

function isFavoritoFormatter(value, row) {
	  if(value){
		  return "<img class=''" +
				"src='/static/img/star-full.png'>";
	  }else{
		  return "<img class='right floated mini ui image'" +
			"src='/static/img/star-empty.png'>";
	  }
}

function isCurriculoFormatter(value, row) {
	 return "<span class='glyphicon glyphicon-eye-open' aria-hidden='true'></span>";
}
