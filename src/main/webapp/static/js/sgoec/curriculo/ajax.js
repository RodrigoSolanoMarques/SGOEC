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
			}else{
				curriculo.hideBtnSolicitarCurriculo(false);
			}
		}
		
		
		/* Calculo para mostrar a idade do candidato */
		curriculo.$modalAvaliarCurriculoIdade.text(calcularIdade(avaliaCurriculo.curriculo.candidato.pessoa.dataNascimento));
		
		curriculo.modalShowAvaliarCurriculo();
		hideCarregando();

	},
	btnAprovar: function(idAvaliacaoCurriculo){
		$.post("/empresa/avaliacaoCurriculo/aprovar", {idAvaliacaoCurriculo: idAvaliacaoCurriculo}, function(data){
			curriculo.hideBtnAprovar();
			alert("Curriculo Aprovado");
		});
	},
	
	btnDispensar: function(idAvaliacaoCurriculo){
		curriculo.hideBtnDispensar();
		alert("Curriculo Reprovado");
	},
	
	btnListaCandidatosFavoritos: function(idAvaliacaoCurriculo){
		
	},
	
	btnListaEspera: function(idAvaliacaoCurriculo){
		
	},
	
	btnSolicitarCurriculo: function(idAvaliacaoCurriculo){
		
	}
};