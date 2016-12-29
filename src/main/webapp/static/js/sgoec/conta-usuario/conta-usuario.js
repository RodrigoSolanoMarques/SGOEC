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
	
	alterar: function(id){
		ajaxContaUsuario.alterar(id);
	},
	
	limparFormCadastrarContaUsuarioAll: function(){
		contaUsuario.$formCadastrarContaUsuario[0].reset();
	},
	
	limparFormCadastrarContaUsuario: function(){
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
