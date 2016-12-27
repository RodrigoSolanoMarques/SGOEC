var oportunidadeEmprego = {
	$formCadastrarOportunidadeEmprego : $("#formCadastrarOportunidadeEmprego"),
	$tableOportunidadeEmprego: $("#tableOportunidadeEmprego"),
	cidade: $("#cidade"),
	estado: $("#estado"),
	isSalario: $("#isSalario"),
	txtSalario: $("#txtSalario")
};

/*====================================================
****************** Carregar Tela *********************
====================================================*/
$(function(){
	// Mascara
	oportunidadeEmprego.txtSalario.mask("###.##0,00", {reverse: true, placeholder: "Ex: 1.000,00"});

	ajaxOportunidadeEmprego.listar();
	
	oportunidadeEmprego.formCadastrarOportunidadeEmprego.submit(function() {
		debugger
		ajaxOportunidadeEmprego.salvar();
	  return false;
	});
});


/*====================================================
******************** Função *************************
====================================================*/
validaIsSalario = function(){
	if(oportunidadeEmprego.isSalario.is(":checked")){
		oportunidadeEmprego.txtSalario.prop("readonly", false);
	}else{
		oportunidadeEmprego.txtSalario.prop("readonly", true);
		oportunidadeEmprego.txtSalario.val(null);
	}
}

/*====================================================
****************** Data Formatter ********************
====================================================*/

/*====================================================
****************** Data Events ********************
====================================================*/



