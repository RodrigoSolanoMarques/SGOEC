var ajaxContaUsuario = {
	
	alterar: function(id){
		$.getJSON("/contaUsuario/alterar", {id: id},function(data){
			contaUsuario.$id.val(data.id);
			contaUsuario.$username.val(data.username);
			contaUsuario.$email.val(data.email);
			
			debugger;
			contaUsuario.$imagem.attr('src', data.pathImagem);
	
		});
	},
	
	salvar: function(ContaUsuario){
		debugger;
//		$.post("/empresa/contaUsuario/salvar/empregador", ContaUsuario, function(data){
//			debugger
//			contaUsuario.$id.val(data.id);
//			empregador.contaUsuarioId.val(contaUsuario.$id.val());
//			contaUsuario.limparFormCadastrarContaUsuario();
//			hideCarregando();
//		});
	
		var formData = new FormData($("#modalFormCadastrarContaUsuario")[0]); 
		formData.append("trocarSenha", contaUsuario.$trocarSenha.is(':checked'));
		
		$.ajax({
			type : "POST",
			url : "/empresa/contaUsuario/salvar/empregador",
			data : formData,
			async: false,
			cache:false,
			contentType: false,
			processData: false,
			success : function(data) {
				debugger;
				
				if(data.contaUsuario.pathImagem != null && data.contaUsuario.pathImagem != "" ){
					contaUsuario.$imagem.attr('src', data.contaUsuario.pathImagem);
				}
				
				contaUsuario.$divAlertSuccessSpan.text(data.msg);
				contaUsuario.$divAlertSuccess.show();
				
				contaUsuario.limparFormCadastrarContaUsuario();
				
				hideCarregando();
			},
			error : function(jqXHR, textStatus, errorThrown) {
				debugger
				contaUsuario.$divAlertDangerSpan.text(jqXHR.responseJSON.msg);
				contaUsuario.$divAlertDanger.show();
				hideCarregando();
				
			}
		});
		
	}
};