var avaliacaoCurriculoSelecionado = "";

var curriculo = {
	$modalAvaliarCurriculo: $('#modalAvaliarCurriculo'),
	$modalAvaliarCurriculoIsFavorito: $('#modalAvaliarCurriculoIsFavorito'),
	$modalAvaliarCurriculoIdade: $('#modalAvaliarCurriculoIdade'),
	$modalAvaliarCurriculoFoto: $('#modalAvaliarCurriculoFoto'),
	
	$btnAprovar: $('#btnAprovar'),
	$btnDispensar: $('#btnDispensar'),
	$btnListaCandidatosFavoritos: $('#btnListaCandidatosFavoritos'),
	$btnListaEspera: $('#btnListaEspera'),
	$btnSolicitarCurriculo: $('#btnSolicitarCurriculo'),
	
	carregarAvaliacaoCurriculo: function(avaliacaoCurriculo){
		showCarregando();
		avaliacaoCurriculoSelecionado = avaliacaoCurriculo;
    	ajaxCurriculo.carregar(avaliacaoCurriculo);
	},
	
	modalShowAvaliarCurriculo: function(){
		curriculo.$modalAvaliarCurriculo.show();
		
	},
	
	modalHideAvaliarCurriculo: function(){
		curriculo.$modalAvaliarCurriculo.hide();
	},
	
	btnAprovar: function(){
		ajaxCurriculo.btnAprovar(avaliacaoCurriculoSelecionado.id);
	},
	
	btnDispensar: function(){
		ajaxCurriculo.btnDispensar(avaliacaoCurriculoSelecionado.id);
	},
	
	btnListaCandidatosFavoritos: function(){
		ajaxCurriculo.btnListaCandidatosFavoritos(avaliacaoCurriculoSelecionado.id);
	},
	
	btnListaEspera: function(){
		ajaxCurriculo.btnListaEspera(avaliacaoCurriculoSelecionado.id);
	},
	
	btnSolicitarCurriculo: function(){
		ajaxCurriculo.btnSolicitarCurriculo(avaliacaoCurriculoSelecionado.id);
	},
	
	hideBtnAprovarBtnDispensar: function(boolean){
		if(boolean){
			curriculo.$btnAprovar.addClass("disabled");
			curriculo.$btnDispensar.addClass("disabled");
		}else{
			curriculo.$btnAprovar.removeClass("disabled");
			curriculo.$btnDispensar.removeClass("disabled");
		}
	},
	
	hideBtnAprovar: function(){
		curriculo.$btnAprovar.addClass("disabled");
		curriculo.$btnDispensar.removeClass("disabled");
	},
	
	hideBtnDispensar: function(){
		curriculo.$btnDispensar.addClass("disabled");
		curriculo.$btnAprovar.removeClass("disabled");
	},
	
	hideBtnListaCandidatosFavoritos: function(boolean){
		curriculo.$btnListaCandidatosFavoritos.prop("disabled", boolean);
	},
	
	hideBtnListaEspera: function(boolean){
		curriculo.$btnListaEspera.prop("disabled", boolean);
	},
	
	hideBtnSolicitarCurriculo: function(boolean){
		curriculo.$btnSolicitarCurriculo.prop("disabled", boolean);
	}
};