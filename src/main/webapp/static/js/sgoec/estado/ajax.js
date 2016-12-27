var ajaxEstado = {
	
	salvar: function(){
		debugger
//		$.post("/cidade/novo", oportunidadeEmprego.formCadastrarOportunidadeEmprego.serialize(), function(data){
//			debugger;
//		});
	},
	
	listar: function(){
		estado.$tableEstados.bootstrapTable({
			toolbar : ".toolbar",
			showRefresh : true,
			search : true,
			showToggle : true,
			showColumns : true,
			pagination : true,
			striped : true,
			sortable : true,
			url : '/estado/listar',
			pageSize : 5,
			pageList : [ 5, 10, 25, 50, 100 ],
			
			icons : {
				refresh : 'fa fa-refresh',
				toggle : 'fa fa-th-list',
				columns : 'fa fa-columns',
				detailOpen : 'fa fa-plus-circle',
				detailClose : 'fa fa-minus-circle'
			}
		});
	},

}