var loginRegistro = {

	/* Dados da Empresa */
	$cpfCnpj: $("#cpfCnpj"),
	$cpf: $("#cpf"),
	$cnpj: $("#cnpj"),
	$formRegistrarContaUsuario: $('#formRegistrarContaUsuario'),
	classCidade: $(".cidade"),
	classEstado: $(".estado"),
	$divAlertSuccess: $("#divAlertSuccess"),
	$divAlertDanger: $("#divAlertDanger"),
	$divAlertSuccessText: $("#divAlertSuccessText"),
	$divAlertDangerText: $("#divAlertDangerText"),
	
	$entrar: $("#entrar"),

	
	
	
	
	/* Dados do usuário */
		
		
	/* Dados da Conta */
	$username: $("#username"),
	$senha: $("#senha"),
	$compararSenha: $("#compararSenha"),
	$email: $("#email"),
	
	carregarCidadePorEstado: function(idEstado, idCidade){
		debugger;
		ajaxLogin.carregarCidadePorEstado(idEstado, idCidade);
	},
	
	validaCpfCnpj: function(){
		if(loginRegistro.$cpf.is(':checked')){
			loginRegistro.$cpfCnpj.mask('000.000.000-00');
		}else{
			loginRegistro.$cpfCnpj.prop('checked', true);
			loginRegistro.$cpfCnpj.mask("99.999.999/9999-99");
		}
	},
	
}

$(function () {
	
	// Inicia os Tooltips
	$(function () {
	  $('[data-toggle="tooltip"]').tooltip()
	});
	
	
	loginRegistro.classEstado.change(function(){
		debugger;
		loginRegistro.carregarCidadePorEstado(loginRegistro.classEstado.val());
	});
		
    
	loginRegistro.validaCpfCnpj();
	
	loginRegistro.$divAlertSuccess.hide();
	loginRegistro.$divAlertDanger.hide();
	
	/* Efeito login */
    $('.list-inline li > a').click(function () {
        var activeForm = $(this).attr('href') + ' > form';
        //console.log(activeForm);
        $(activeForm).addClass('magictime swap');
        //set timer to 1 seconds, after that, unload the magic animation
        setTimeout(function () {
            $(activeForm).removeClass('magictime swap');
        }, 1000);
    });
});


/* Submit */
loginRegistro.$formRegistrarContaUsuario.submit(function(){
	//showCarregando();
	ajaxLogin.registrar();
	return false;
});