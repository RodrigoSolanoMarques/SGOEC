var ajaxEmpregador = {
	
	alterar: function(Empregador){
		cidade.carregarCidadePorEstado(Empregador.pessoa.cidade.estado.id, Empregador.pessoa.cidade.id);
		
		$.getJSON("/empresa/contaUsuario/alterar", {id: Empregador.contaUsuario.id},function(data){
			debugger;
			putResultVal(data, empregador.$modalFormCadastrarContaUsuario);
			empregador.$imagem.attr("src","/imagens/" + data.id + "/"+ data.id + ".jpg");
			
			if( (data != null) && (data.id != null) && (data.id > 0)){
				contaUsuario.$imagem.attr('src', data.pathImagem);
				
				contaUsuario.$username.attr('readonly', true);
				contaUsuario.$senha.attr('readonly', true);
				contaUsuario.$compararSenha.attr('readonly', true);
				
				contaUsuario.$senha.attr('required', false);
				contaUsuario.$compararSenha.attr('required', false);
			}
			
			hideCarregando();
		});
		
		$.getJSON("/empresa/empregador/alterar", {id: Empregador.id},function(data){
			putResultVal(data, empregador.$modalFormCadastrarEmpregador);
			empregador.modalShowCadastroEmpregador();
			hideCarregando();
		});
		
	},
	
	salvar: function(Empregador){
//		$.post("/empresa/empregador/salvar", Empregador, function(data){
//			debugger;
//			empregador.modalLimparFormCadastrarEmpregador();
//			empregador.modalHideCadastroEmpregador();
//			empregador.$tableEmpregadores.bootstrapTable("refresh");
//			hideCarregando();
//		});

	},
	
	listar: function(){
		empregador.$tableEmpregadores.bootstrapTable({
			toolbar : ".toolbar",
			showRefresh : true,
			search : true,
			showToggle : true,
			showColumns : true,
			pagination : true,
			striped : true,
			sortable : true,
			url : '/empresa/empregador/listar',
			pageSize : 5,
			pageList : [ 5, 10, 25, 50, 100 ],
			
			icons : {
				refresh : 'fa fa-refresh',
				toggle : 'fa fa-th-list',
				columns : 'fa fa-columns',
				detailOpen : 'fa fa-plus-circle',
				detailClose : 'fa fa-minus-circle'
			},
			
			onDblClickRow: function(row, $element, field){
				debugger
				showCarregando();
				ajaxEmpregador.alterar(row);
				
			}
		});
		hideCarregando();
	},
};