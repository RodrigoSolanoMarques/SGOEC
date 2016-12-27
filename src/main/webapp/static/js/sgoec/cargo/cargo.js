var cargo = {
	$tableCargos: $("#tableCargos"),
	$modalCadastroCargo: $("#modalCadastroCargo"),
	$modalFormCadastrarCargo: $("#modalFormCadastrarCargo"),
	$id: $("#id"),
	$nome: $("#nome"),
	$descricao: $("#descricao"),
	$btnModalFormSalvarCargo: $("#btnModalFormSalvarCargo"),
	$btnModalFormLimparCargo: $("#btnModalFormLimparCargo"),
	$btnModalFormCancelarCargo: $("#btnModalFormCancelarCargo"),
	
	alterar: function(id){
		ajaxCargo.alterar(id);
	},
	
	modalLimparFormCadastrarCargo: function(){
		cargo.$modalFormCadastrarCargo[0].reset();
	},
	
	cadastrar: function(){
		ajaxCargo.cadastrar()
	},
	
	modalSalvarFormCadastroCargo: function(){
		ajaxCargo.salvar(cargo.$modalFormCadastrarCargo.serialize())
		return false;
	},
	
	modalShowCadastroCargo: function(){
		cargo.$modalCadastroCargo.show();
		
	},
	
	modalHideCadastroCargo: function(){
		cargo.modalLimparFormCadastrarCargo();
		cargo.$modalCadastroCargo.hide();
	}
}

/*====================================================
****************** Carregar Tela *********************
====================================================*/
$(function(){
	ajaxCargo.listar();
});

/*====================================================
******************* Modal Form ***********************
====================================================*/
