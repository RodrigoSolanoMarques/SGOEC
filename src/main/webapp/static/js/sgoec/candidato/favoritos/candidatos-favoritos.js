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
    return row.curriculo.candidato.pessoa.nome + " " + row.curriculo.candidato.pessoa.sobrenome;
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

window.operateEvents = {
        'click .visualizar': function (e, value, row) {
        	debugger
            alert('You click like action, row: ' + JSON.stringify(row));
        },
    };

function isCurriculoFormatter(value, row) {
	 return ['<a class="visualizar" href="javascript:void(0)" title="Visualizar Curriculo">',
	         '<span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span>',
	         '</a>'].join('');
}
