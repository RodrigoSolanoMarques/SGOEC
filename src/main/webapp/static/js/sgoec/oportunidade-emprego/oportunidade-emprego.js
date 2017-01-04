var oportunidadeEmprego = {
	$modalFormCadastrarOportunidadeEmprego: $("#modalFormCadastrarOportunidadeEmprego"),
	$modalCadastroOportunidadeEmprego: $("#modalCadastroOportunidadeEmprego"),
	$tableOportunidadeEmprego: $("#tableOportunidadeEmprego"),
	$cidade: $("#cidade"),
	$estado: $("#estado"),
	$cargo: $("#cargo"),
	$cargaHoraria: $("#cargaHoraria"),
	$isSalario: $("#isSalario"),
	$txtSalario: $("#txtSalario"),
	$areaProfissional: $("#areaProfissional"),

	modalLimparFormCadastrarOportunidadeEmprego: function(){
		oportunidadeEmprego.$modalFormCadastrarOportunidadeEmprego[0].reset();
		cidade.carregarCidadePorEstado(cidade.classEstado.val());
		
		oportunidadeEmprego.$areaProfissional.prop("disabled", false);
		oportunidadeEmprego.$cidade.prop("disabled", false);
		oportunidadeEmprego.$estado.prop("disabled", false);
		
		oportunidadeEmprego.$cargaHoraria.prop("readonly", false);
		oportunidadeEmprego.$cargo.prop("disabled", false);
		
		oportunidadeEmprego.$txtSalario.prop("readonly", true);
		oportunidadeEmprego.$isSalario.prop("disabled", false);
	},
	
	modalSalvarFormCadastroOportunidadeEmprego: function(){
		showCarregando();
		ajaxOportunidadeEmprego.salvar(oportunidadeEmprego.$modalFormCadastrarOportunidadeEmprego.serialize())
		return false;
	},
	
	modalShowCadastroOportunidadeEmprego: function(){
		oportunidadeEmprego.$modalCadastroOportunidadeEmprego.show();
	},
	
	modalHideCadastroOportunidadeEmprego: function(){
		oportunidadeEmprego.modalLimparFormCadastrarOportunidadeEmprego();
		oportunidadeEmprego.$modalCadastroOportunidadeEmprego.hide();
	},
};

/*====================================================
****************** Carregar Tela *********************
====================================================*/
$(function(){
	// Mascara
	showCarregando();
	// Inicia os Tooltips
	$('[data-toggle="tooltip"]').tooltip(); 
	
	oportunidadeEmprego.$txtSalario.mask("###.##0,00", {reverse: true, placeholder: "Ex: 1.000,00"});
	ajaxOportunidadeEmprego.listar();
	
});


/*====================================================
******************** Função *************************
====================================================*/
validaIsSalario = function(){
	if(oportunidadeEmprego.$isSalario.is(":checked")){
		oportunidadeEmprego.$txtSalario.prop("readonly", false);
	}else{
		oportunidadeEmprego.$txtSalario.prop("readonly", true);
		oportunidadeEmprego.$txtSalario.val(null);
	}
}

/*====================================================
****************** Data Formatter ********************
====================================================*/

/*====================================================
****************** Data Events ********************
====================================================*/



