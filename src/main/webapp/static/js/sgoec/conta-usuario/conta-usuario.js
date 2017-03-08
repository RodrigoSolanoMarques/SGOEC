var contaUsuario = {
	$formCadastrarContaUsuario: $("#modalFormCadastrarContaUsuario"),
	$id: $("#id"),
	$username: $("#username"),
	$senha: $("#senha"),
	$compararSenha: $("#compararSenha"),
	$email: $("#email"),
	$imagem: $("#imagem"),
	$foto: $("#foto"),
	$btnFoto: $("#btnFoto"),
	$nomeFoto: $("#nomeFoto"),
	$divSenhas: $("#divSenhas"),
	$trocarSenha: $("#trocarSenha"),
	$divTrocarSenha: $("#divTrocarSenha"),
	$divAlertSuccess: $("#divAlertSuccess"),
	$divAlertDanger: $("#divAlertDanger"),
	
	$divAlertSuccessSpan : $('#divAlertSuccessSpan'),
	$divAlertDangerSpan : $('#divAlertDangerSpan'),
	
	alterar: function(id){
		ajaxContaUsuario.alterar(id);
	},
	
	limparFormCadastrarContaUsuarioAll: function(){
		contaUsuario.$formCadastrarContaUsuario[0].reset();
	},
	
	limparFormCadastrarContaUsuario: function(){
		contaUsuario.$trocarSenha.prop('checked', false);
		contaUsuario.$divSenhas.hide();
    	
    	contaUsuario.$senha.prop('readonly', true);
		contaUsuario.$compararSenha.prop('readonly', true);
    	
    	contaUsuario.$senha.prop('required', false);
		contaUsuario.$compararSenha.prop('required', false);
		
		contaUsuario.$senha.val(null);
		contaUsuario.$compararSenha.val(null);
	}
}

/*====================================================
****************** Carregar Tela *********************
====================================================*/
$(function(){
	
	// Inicia os Tooltips
	$(function () {
	  $('[data-toggle="tooltip"]').tooltip()
	});
	
//	contaUsuario.$foto.change(function(){
//		debugger;
//		contaUsuario.$nomeFoto.text(contaUsuario.$foto.val());
//		// Aqui para fazer um preview
//	});
	
	contaUsuario.$btnFoto.click( function() {
		contaUsuario.$foto.click();
	});	
	
	contaUsuario.$trocarSenha.change(function() {
	    if(this.checked) {
	    	contaUsuario.$divSenhas.show();
	    	
			contaUsuario.$senha.prop('readonly', false);
			contaUsuario.$compararSenha.prop('readonly', false);
	    	
	    	contaUsuario.$senha.prop('required', true);
			contaUsuario.$compararSenha.prop('required', true);
			
	    }else{
	    	contaUsuario.$divSenhas.hide();
	    	
	    	contaUsuario.$senha.prop('readonly', true);
			contaUsuario.$compararSenha.prop('readonly', true);
	    	
	    	contaUsuario.$senha.prop('required', false);
			contaUsuario.$compararSenha.prop('required', false);
			
			contaUsuario.$senha.val(null);
			contaUsuario.$compararSenha.val(null);
	    }
	});
	
	contaUsuario.$divAlertSuccess.hide();
	contaUsuario.$divAlertDanger.hide();
})

/*====================================================
********************* Submit *************************
====================================================*/

contaUsuario.$formCadastrarContaUsuario.submit(function(){
	debugger;
	showCarregando();
	ajaxContaUsuario.salvar(contaUsuario.$formCadastrarContaUsuario.serialize())
	return false;
})
