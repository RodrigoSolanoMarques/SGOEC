var ajaxCidade = {
	
	salvar: function(){
		debugger
//		$.post("/cidade/novo", oportunidadeEmprego.formCadastrarOportunidadeEmprego.serialize(), function(data){
//			debugger;
//		});
		hideCarregando()
	},
	
	listar: function(){
			cidade.$tableCidades.bootstrapTable({
				toolbar : ".toolbar",
				showRefresh : true,
				search : true,
				showToggle : true,
				showColumns : true,
				pagination : true,
				striped : true,
				sortable : true,
				url : '/cidade/listar',
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
			hideCarregando();
		},
	
	carregarCidadePorEstado: function(idEstado, idCidade){
		debugger;
		$.getJSON("/cidade/carregarCidadePorEstado/"+idEstado, function(data){
			debugger
			cidade.classCidade.html("");
			var options = "";
			$.each(data, function (index, obj) {
				if(idCidade == obj.id){
					options += '<option value="' + obj.id + '" selected>' + obj.nome + '</option>';
				}else{
					options += '<option value="' + obj.id + '">' + obj.nome + '</option>';
				}
				
			});
			
			cidade.classCidade.html(options);
			hideCarregando();
		});
	}
	
}