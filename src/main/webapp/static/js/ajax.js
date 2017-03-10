var ajaxLogin = {
	carregarCidadePorEstado: function(idEstado, idCidade){
		debugger;
		$.getJSON("/cidade/carregarCidadePorEstado/"+idEstado, function(data){
			debugger
			loginRegistro.classCidade.html("");
			var options = "";
			$.each(data, function (index, obj) {
				if(idCidade == obj.id){
					options += '<option value="' + obj.id + '" selected>' + obj.nome + '</option>';
				}else{
					options += '<option value="' + obj.id + '">' + obj.nome + '</option>';
				}
			});
			loginRegistro.classCidade.html(options);
			//hideCarregando();
		});
	},
	
	registrar :  function(){
debugger
		$.post("/registrar", loginRegistro.$formRegistrarContaUsuario.serialize(), function(data){
			loginRegistro.$divAlertSuccessText.text(data.msg);
			loginRegistro.$divAlertSuccess.show();
			loginRegistro.$formRegistrarContaUsuario[0].reset();
			
			loginRegistro.$entrar.click();
			
//			//hideCarregando();
		}).fail(function(jqXHR, textStatus, errorThrown) {
			loginRegistro.$divAlertDangerText.text(jqXHR.responseJSON.msg);
			loginRegistro.$divAlertDanger.show();
		 });
//		$.ajax({
//			type : "POST",
//			url : "/registrar",
//			data : loginRegistro.$formRegistrarContaUsuario.serialize(),
//			async: false,
//			cache:false,
//			contentType: false,
//			processData: false,
//			success : function(data) {
//				debugger;
//				loginRegistro.$divAlertSuccess.text(data.msg);
//				loginRegistro.$divAlertSuccess.show();
//				//hideCarregando();
//			},
//			error : function(jqXHR, textStatus, errorThrown) {
//				debugger
//				loginRegistro.$divAlertDanger.text(jqXHR.responseJSON.msg);
//				loginRegistro.$divAlertDanger.show();
//				//hideCarregando();
//				
//			}
//		});
		
		
		
	}
	
}