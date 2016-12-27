


//FUNÇÃO PARA FORMATAR CPF
function formataCPF(campo) {
    campo.value = filtraCampo(campo);
    vr = LimparMoeda(campo.value, "0123456789");
    tam = vr.length;
    if (tam <= 2) {
        campo.value = vr;
    }
    if (tam > 2 && tam <= 5) {
        campo.value = vr.substr(0, tam - 2) + '-' + vr.substr(tam - 2, tam);
    }
    if (tam >= 6 && tam <= 8) {
        campo.value = vr.substr(0, tam - 5) + '.' + vr.substr(tam - 5, 3) + '-' + vr.substr(tam - 2, tam);
    }
    if (tam >= 9 && tam <= 11) {
        campo.value = vr.substr(0, tam - 8) + '.' + vr.substr(tam - 8, 3) + '.' + vr.substr(tam - 5, 3) + '-' + vr.substr(tam - 2, tam);
    }
}

//FUNÇÃO VALIDAÇÃO PARA CPF
function validarCPF(cpf) {
    cpf = cpf.replace(/[^\d]+/g, '');

    if (cpf == '') return false;

    // Elimina CPFs invalidos conhecidos
    if (cpf.length != 11 || cpf == "00000000000" || cpf == "11111111111" || cpf == "22222222222" ||
        cpf == "33333333333" || cpf == "44444444444" || cpf == "55555555555" || cpf == "66666666666" ||
        cpf == "77777777777" || cpf == "88888888888" || cpf == "99999999999")
        return false;

    // Valida 1º digito
    add = 0;

    for (i = 0; i < 9; i++)
        add += parseInt(cpf.charAt(i)) * (10 - i);

    rev = 11 - (add % 11);

    if (rev == 10 || rev == 11)
        rev = 0;

    if (rev != parseInt(cpf.charAt(9)))
        return false;

    // Valida 2º digito
    add = 0;

    for (i = 0; i < 10; i++)
        add += parseInt(cpf.charAt(i)) * (11 - i);

    rev = 11 - (add % 11);

    if (rev == 10 || rev == 11)
        rev = 0;

    return rev == parseInt(cpf.charAt(10));
}

//FUNÇÃO VALIDAÇÃO PARA CNPJ
function validarCNPJ(cnpj) {
    cnpj = cnpj.replace(/[^\d]+/g, '');

    if (cnpj == '') return false;

    if (cnpj.length != 14)
        return false;

    // Elimina CNPJs invalidos conhecidos
    if (cnpj == "00000000000000" || cnpj == "11111111111111" || cnpj == "22222222222222" || cnpj == "33333333333333" ||
        cnpj == "44444444444444" || cnpj == "55555555555555" || cnpj == "66666666666666" || cnpj == "77777777777777" ||
        cnpj == "88888888888888" || cnpj == "99999999999999")
        return false;

    // Valida DVs
    tamanho = cnpj.length - 2
    numeros = cnpj.substring(0, tamanho);
    digitos = cnpj.substring(tamanho);
    soma = 0;
    pos = tamanho - 7;

    for (i = tamanho; i >= 1; i--) {
        soma += numeros.charAt(tamanho - i) * pos--;
        if (pos < 2)
            pos = 9;
    }
    resultado = soma % 11 < 2 ? 0 : 11 - soma % 11;

    if (resultado != digitos.charAt(0))
        return false;

    tamanho = tamanho + 1;
    numeros = cnpj.substring(0, tamanho);
    soma = 0;
    pos = tamanho - 7;

    for (i = tamanho; i >= 1; i--) {
        soma += numeros.charAt(tamanho - i) * pos--;
        if (pos < 2)
            pos = 9;
    }

    resultado = soma % 11 < 2 ? 0 : 11 - soma % 11;

    return resultado == digitos.charAt(1);
}


//FORMATA DATE NO FORMATO DD/MM/YYYY
function formatDate(d) {
    var dd = d.getDate();
    if (dd < 10) dd = '0' + dd;

    var mm = d.getMonth() + 1;
    if (mm < 10) mm = '0' + mm;

    return dd + '/' + mm + '/' + d.getFullYear();
}

//FORMATA TIME NO FORMATO HH:MM
function formatTime(d) {
    var hh = d.getHours();
    if (hh < 10) hh = '0' + hh;

    var mm = d.getMinutes();
    if (mm < 10) mm = '0' + mm;

    return hh + ':' + mm;
}

//FORMATA DATETIME NO FORMATO DD/MM/YYYY HH:MM
function formatDateTime(d) {
    return formatDate(d) + ' ' + formatTime(d);
}

//OBTER DATA E HORA ATUAL FORMATO DD/MM/YYYY HH:MM
function getDateTime() {
    var data = new Date();
    return formatDate(data) + ' ' + formatTime(data);
}

//OBTER DATA ATUAL FORMATO DD/MM/YYYY
function getDate() {
    var data = new Date();
    return formatDate(data);
}


//COLOCAR OS VALORES DO RESULT NOS ELEMENTOS INPUT E SELECT DE DETERMINADO FORM
//PARAMETROS
// RESULT => VALORES QUE VEM DO SERVIDOR
// ELEID => ID DO FORM ONDE SERÁ COLOCADO OS VALORES
function putResultVal(result, eleid) {
    $(eleid).find("input, select, textarea").each(function () {
        putObjcValue(result, $(this));
    });
}

function putObjcValue(result, ele) {
    
	if(!(ele.attr("name") == undefined)){
		var nameArray = ele.attr("name").split(".");
	    var value = "";

	    for (var i = 0; i < nameArray.length; i++) {
	        value += '[nameArray[' + i + ']]';
	    }

	    try {
	        ele.val(eval("result" + value));
	    } catch (e) {
	        ele.val("");
	    }
	}

}

function showCarregando(){
	// Carrega o Componente
	$('body').loadingModal({
		  text: 'Carregando...',
		  animation: 'threeBounce'
	});
	$('body').loadingModal('show');
}

function hideCarregando(){
	//hide the loading modal
	$('body').loadingModal('hide');
}

function destroyCarregando(){
	//destroy the plugin
	$('body').loadingModal('destroy');
}

