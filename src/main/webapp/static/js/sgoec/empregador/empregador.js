var empregador = {
	$tableEmpregadores: $("#tableEmpregadores"),
	$modalCadastroEmpregador: $("#modalCadastroEmpregador"),
	$modalFormCadastrarEmpregador: $("#modalFormCadastrarEmpregador"),
	$modalFormCadastrarContaUsuario: $("#modalFormCadastrarContaUsuario"),
	$senha: $("#senha"),
	$compararSenha: $("#compararSenha"),
	$imagem: $("#imagem"),
	
	classCpf: $(".cpf"),
	classData: $(".data"),
	classCep: $(".cep"),
	classTelefone: $(".telefone"),
	classCelular: $(".celular"),
	contaUsuarioId: $("#contaUsuarioId"),
	
		
	alterar: function(id){
		showCarregando();
		ajaxEmpregador.alterar(id);
	},
	
	modalSalvarFormCadastroEmpregador: function(){
		showCarregando();
		empregador.contaUsuarioId.val(contaUsuario.$id.val());
		ajaxEmpregador.salvar(empregador.$modalFormCadastrarEmpregador.serialize());
	},
	
	modalShowCadastroEmpregador: function(){
		debugger
		showCarregando();
		empregador.$modalCadastroEmpregador.show();
		
		if(contaUsuario.$id.val()){
			contaUsuario.$username.prop('readonly', true);
			contaUsuario.$senha.prop('required', false);
			contaUsuario.$compararSenha.prop('required', false);
		}else{
			contaUsuario.$username.prop('readonly', false);
			contaUsuario.$senha.prop('readonly', false);
			contaUsuario.$compararSenha.prop('readonly', false);
			
			contaUsuario.$senha.prop('required', true);
			contaUsuario.$compararSenha.prop('required', true);
			
			contaUsuario.$imagem.attr('src', '/static/img/nan.jpg');
		}
		hideCarregando();
	},
	
	modalHideCadastroEmpregador: function(){
		showCarregando();
		empregador.$modalFormCadastrarEmpregador[0].reset();
		
		contaUsuario.limparFormCadastrarContaUsuarioAll();
		empregador.$modalCadastroEmpregador.hide();
		hideCarregando();
	},
	
	modalLimparFormCadastrarEmpregador: function(){
		empregador.$modalFormCadastrarEmpregador[0].reset();
		cidade.carregarCidadePorEstado(cidade.classEstado.val());
		
	},
}

/*====================================================
****************** Carregar Tela *********************
====================================================*/
$(function(){
	showCarregando();
	// Inicia os Tooltips
	 $('[data-toggle="tooltip"]').tooltip(); 
		
	// Mascara
	empregador.classCpf.mask('000.000.000-00');
	empregador.classData.mask('00/00/0000');
	empregador.classCep.mask('00.000-000');
	empregador.classTelefone.mask('(00) 0000-0000');
	empregador.classCelular.mask('(00) 00000-0000');
	
	$(".data").datetimepicker({format: "DD/MM/YYYY"});
	
	ajaxEmpregador.listar();
})

/*====================================================
********************* Submit *************************
====================================================*/
empregador.$modalFormCadastrarEmpregador.submit(function(){
	empregador.modalSalvarFormCadastroEmpregador();
})
