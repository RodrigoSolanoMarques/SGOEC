var candidatos = {
	$modalAvaliarCurriculo: $('#modalAvaliarCurriculo'),
		
	carregar: function(curriculo){
		showCarregando();
		ajaxCandidatos.carregar(curriculo);
	},
	
	modalShowAvaliarCurriculo: function(){
		candidatos.$modalAvaliarCurriculo.show();
		
	},
	modalHideAvaliarCurriculo: function(){
		candidatos.$modalAvaliarCurriculo.hide();
	},
};

/*====================================================
****************** Carregar Tela *********************
====================================================*/
$(function() {
	debugger
	ajaxCandidatos.listarCandidatos();
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
		  return "<img class=''" +
			"src='/static/img/star-empty.png'>";
	  }
}
function isCurriculoFormatter(value, row) {
	 return [ "<a class='visualizar' href='javascript:void(0)' title='Visualizar Currículo'>",
	 "<span class='glyphicon glyphicon-eye-open' aria-hidden='true'></span>", "</a>"].join("");
}

/*====================================================
****************** Data Events ********************
====================================================*/

window.isCurriculoEvents = {
    'click .visualizar': function (e, value, row, index) {
    	debugger
    	candidatos.carregar(row);
    }
};