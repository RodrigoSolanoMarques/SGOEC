var ajaxOportunidadeEmprego = {
	
	salvar: function(){
		debugger
		$.post("/empresa/OportundadeEmprego/novo", oportunidadeEmprego.formCadastrarOportunidadeEmprego.serialize(), function(data){
			debugger;
		});
	},
	
	listar: function(){
		oportunidadeEmprego.$tableOportunidadeEmprego.bootstrapTable({
			toolbar : ".toolbar",
			showRefresh : true,
			search : true,
			showToggle : true,
			showColumns : true,
			pagination : true,
			striped : true,
			sortable : true,
			url : '/empresa/oportundadeemprego/listar',
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
				//showCarregando();
				//ajaxEmpregador.alterar(row);
				
			}
		});
		hideCarregando();
	}
	
}