var ajaxCargo = {
		
	cadastrar: function(){
		$.getJSON("/empresa/cargo/cadastrar",function(data){debugger
			
			
		});
	},
	
	alterar: function(id){
		$.getJSON("/empresa/cargo/alterar", {id: id}, function(data){
			debugger;
			putResultVal(data, cargo.$modalFormCadastrarCargo);
			cargo.modalShowCadastroCargo();
		});
	},
	
	salvar: function(Cargo){
		$.post("/empresa/cargo/salvar", Cargo, function(data){
			debugger;
			cargo.modalLimparFormCadastrarCargo();
			cargo.modalHideCadastroCargo();
			cargo.$tableCargos.bootstrapTable("refresh");
		});
	},
	
	listar: function(){
		cargo.$tableCargos.bootstrapTable({
			toolbar : ".toolbar",
			showRefresh : true,
			search : true,
			showToggle : true,
			showColumns : true,
			pagination : true,
			striped : true,
			sortable : true,
			sortName: 'id',
			url : '/empresa/cargo/listar',
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
				ajaxCargo.alterar(row.id);
			}
		});
	}
	
};