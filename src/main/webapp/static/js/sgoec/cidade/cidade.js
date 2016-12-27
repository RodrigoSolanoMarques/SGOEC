var cidade = {
	$tableCidades: $("#tableCidades"),
	classCidade: $(".cidade"),
	classEstado: $(".estado"),
	
	carregarCidadePorEstado: function(idEstado, idCidade){
		debugger;
		ajaxCidade.carregarCidadePorEstado(idEstado, idCidade);
	}
};

/*====================================================
****************** Carregar Tela *********************
====================================================*/
$(function(){
	ajaxCidade.listar();
	
	cidade.classEstado.change(function(){
		debugger;
		cidade.carregarCidadePorEstado(cidade.classEstado.val());
	});
});


