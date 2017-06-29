var ajaxCurriculo = {
	carregar: function(avaliaCurriculo){	
		debugger
		putResultVal(avaliaCurriculo, curriculo.$modalAvaliarCurriculo);
		curriculo.$modalAvaliarCurriculoFoto.attr('src', avaliaCurriculo.curriculo.candidato.contaUsuario.pathImagem)
		
		if(avaliaCurriculo.oportunidadeEmprego.isFinalizado){
			curriculo.hideBtnAprovarBtnDispensar(true);
			curriculo.hideBtnListaEspera(true);
			curriculo.hideBtnListaCandidatosFavoritos(true);
			curriculo.hideBtnSolicitarCurriculo(true);
			
		}else{
			if(avaliaCurriculo.favorito){
				curriculo.$modalAvaliarCurriculoIsFavorito.attr('src', "/static/img/star-full.png");
				curriculo.hideBtnListaEspera(false);
				curriculo.hideBtnListaCandidatosFavoritos(true);
			}else{
				curriculo.$modalAvaliarCurriculoIsFavorito.attr('src', "/static/img/star-empty.png");
				curriculo.hideBtnListaEspera(true);
				curriculo.hideBtnListaCandidatosFavoritos(false);
			}
			
			if(avaliaCurriculo.curriculo != null){
				curriculo.hideBtnSolicitarCurriculo(true);
				curriculo.$pdfIdAvaliacaoCurriculo.val(avaliaCurriculo.id);
				curriculo.$btnPdfAbrirCurriculo.show();
				curriculo.$pdfSemCurriculo.hide();
			}else{
				curriculo.hideBtnSolicitarCurriculo(false);
				curriculo.$btnPdfAbrirCurriculo.hide();
				curriculo.$pdfSemCurriculo.show();
			}
		}
		
		/* Calculo para mostrar a idade do candidato */
		curriculo.$modalAvaliarCurriculoIdade.text(calcularIdade(avaliaCurriculo.curriculo.candidato.pessoa.dataNascimento));
		
		curriculo.modalShowAvaliarCurriculo();
		hideCarregando();

	},
	
	btnAprovar: function(idAvaliacaoCurriculo){
		$.post("/empresa/avaliacaoCurriculo/aprovar", {idAvaliacaoCurriculo: idAvaliacaoCurriculo}, function(data){
			curriculo.hideBtnAprovarBtnDispensar(true);
			curriculo.hideBtnListaEspera(true);
			curriculo.hideBtnListaCandidatosFavoritos(true);
			curriculo.hideBtnSolicitarCurriculo(true);
			
			curriculo.modalHideAvaliarCurriculo();
			candidatosFavoritos.$tableFavoritosCandidatos.bootstrapTable('refresh');
		});
	},
	
	btnDispensar: function(idAvaliacaoCurriculo){
		$.post("/empresa/avaliacaoCurriculo/dispensar", {idAvaliacaoCurriculo: idAvaliacaoCurriculo}, function(data){
			curriculo.hideBtnDispensar();
			curriculo.modalHideAvaliarCurriculo();
			candidatosFavoritos.$tableFavoritosCandidatos.bootstrapTable('refresh');
		})
	},
	
	btnListaCandidatosFavoritos: function(idAvaliacaoCurriculo){
		$.post("/empresa/avaliacaoCurriculo/favoritar", {idAvaliacaoCurriculo: idAvaliacaoCurriculo}, function(data){
			curriculo.hideBtnListaCandidatosFavoritos();
			curriculo.modalHideAvaliarCurriculo();
			candidatos.$tableCandidatos.bootstrapTable('refresh');
		})
	},
	
	btnListaEspera: function(idAvaliacaoCurriculo){
		$.post("/empresa/avaliacaoCurriculo/listaEspera", {idAvaliacaoCurriculo: idAvaliacaoCurriculo}, function(data){
			curriculo.hideBtnListaEspera();
			curriculo.modalHideAvaliarCurriculo();
			candidatosFavoritos.$tableFavoritosCandidatos.bootstrapTable('refresh');
		})
	},
	
	btnSolicitarCurriculo: function(idAvaliacaoCurriculo){
		$.post("/empresa/avaliacaoCurriculo/solicitarCurriculo", {idAvaliacaoCurriculo: idAvaliacaoCurriculo}, function(data){
			curriculo.hideBtnSolicitarCurriculo();
			curriculo.modalHideAvaliarCurriculo();
			
			if(typeof candidatosFavoritos != "undefined"){
				candidatosFavoritos.$tableFavoritosCandidatos.bootstrapTable('refresh');
			}else{
				candidatos.$tableCandidatos.bootstrapTable('refresh');
			}
		})
	}
};