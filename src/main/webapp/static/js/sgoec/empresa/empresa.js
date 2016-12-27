var empresa = {
	$tableEmpresas: $("#tableEmpresas"),
	$modalCadastroEmpresa: $("#modalCadastroEmpresa"),
	$modalFormCadastrarEmpresa: $("#modalFormCadastrarEmpresa"),
	$cpfCnpj: $("#cpfCnpj"),
	$cpf: $("#cpf"),
	$cnpj: $("#cnpj"),
	
	classData: $(".data"),
	classCep: $(".cep"),
	classTelefone: $(".telefone"),
	classCelular: $(".celular"),
	contaUsuarioId: $("#contaUsuarioId"),
	
	salvar: function(){
		ajaxEmpresa.salvar(empresa.formCadastrarEmpresa.serialize());
	},
	
	alterar: function(id){
		ajaxEmpresa.alterar(id);
	},
	
	validaCpfCnpj: function(){
		if(empresa.$cpf.is(':checked')){
			empresa.$cpfCnpj.mask('000.000.000-00');
		}else{
			empresa.$cpfCnpj.prop('checked', true);
			empresa.$cpfCnpj.mask("99.999.999/9999-99");
		}
	},
	
	modalLimparFormCadastrarEmpresa: function(){
		empresa.$modalFormCadastrarEmpresa[0].reset();
		cidade.carregarCidadePorEstado(cidade.classEstado.val());
		
	},
	
	cadastrar: function(){
		ajaxEmpresa.cadastrar()
	},
	
	modalSalvarFormCadastroEmpresa: function(){
		ajaxEmpresa.salvar(empresa.$modalFormCadastrarEmpresa.serialize())
		return false;
	},
	
	modalShowCadastroEmpresa: function(){
		empresa.$modalCadastroEmpresa.show();
		
	},
	
	modalHideCadastroEmpresa: function(){
		empresa.$modalCadastroEmpresa.hide();
	}

}

/*====================================================
****************** Carregar Tela *********************
====================================================*/
$(function(){
	empresa.validaCpfCnpj();
	
	ajaxEmpresa.listar();
});

/*====================================================
********************* Submit *************************
====================================================*/
