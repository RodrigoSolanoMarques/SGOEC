var ajaxOportunidadeEmprego = {
		
	salvar: function(OportunidadeEmprego){
		debugger
		$.post("/empresa/oportundadeemprego/salvar", OportunidadeEmprego, function(data){
			debugger;
			oportunidadeEmprego.modalLimparFormCadastrarOportunidadeEmprego();
			oportunidadeEmprego.modalHideCadastroOportunidadeEmprego();
			oportunidadeEmprego.$tableOportunidadeEmprego.bootstrapTable("refresh");
			hideCarregando();
		});
	},
	
	alterar: function(OportunidadeEmprego){
		cidade.carregarCidadePorEstado(OportunidadeEmprego.cidade.estado.id, OportunidadeEmprego.cidade.id);
		$.getJSON("/empresa/oportundadeemprego/alterar", {id: OportunidadeEmprego.id},function(data){
			debugger
			putResultVal(data, oportunidadeEmprego.$modalFormCadastrarOportunidadeEmprego);
			
			// Validações de Campos. Verificar se no limpar campos é preciso reverter.
			oportunidadeEmprego.$areaProfissional.prop("disabled", true);
			oportunidadeEmprego.$cidade.prop("disabled", true);
			oportunidadeEmprego.$estado.prop("disabled", true);
			oportunidadeEmprego.$cargaHoraria.prop("readonly", true);
			oportunidadeEmprego.$cargo.prop("disabled", true);
			
			if(data.isSalario){
				oportunidadeEmprego.$isSalario.prop("checked","true");
			};
			
			oportunidadeEmprego.$txtSalario.prop("readonly", true);
			oportunidadeEmprego.$isSalario.prop("disabled", true);
			
			
			oportunidadeEmprego.modalShowCadastroOportunidadeEmprego();
			hideCarregando();
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
			sortOrder: 'desc',
			sortName: 'id',
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
				ajaxOportunidadeEmprego.alterar(row);
				
			}
		});
		hideCarregando();
	}
	
}