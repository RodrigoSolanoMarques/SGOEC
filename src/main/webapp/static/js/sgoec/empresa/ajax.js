var ajaxEmpresa = {
	
	alterar: function(Empresa){
		
		cidade.carregarCidadePorEstado(Empresa.cidade.estado.id, Empresa.cidade.id);
		
		$.getJSON("/empresa/alterar", {id: Empresa.id},function(data){
			debugger
			if(data.isPessoaJuridica){
				empresa.$cpf.prop('checked', true);
			}else{
				empresa.$cnpj.prop('checked', true);
			}
			putResultVal(data, empresa.$modalFormCadastrarEmpresa);
			empresa.validaCpfCnpj();
			empresa.modalShowCadastroEmpresa();
		});
	},
	
	salvar: function(Empresa){
		debugger
		$.post("/empresa/salvar", Empresa, function(data){
			debugger;
			empresa.modalLimparFormCadastrarEmpresa();
			empresa.$tableEmpresas.bootstrapTable("refresh");
			empresa.modalHideCadastroEmpresa();
			
		});
	},
	
	listar: function(){
		empresa.$tableEmpresas.bootstrapTable({
			toolbar : ".toolbar",
			showRefresh : true,
			search : true,
			showToggle : true,
			showColumns : true,
			pagination : true,
			striped : true,
			sortable : true,
			url : '/empresa/listar',
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
				ajaxEmpresa.alterar(row);
			}
		});
	}
};