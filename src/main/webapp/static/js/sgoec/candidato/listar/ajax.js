var ajaxCandidatos = {
	
	carregar: function(curriculo){
		$.getJSON("/empresa/candidato/carregar", {id: curriculo.id},function(data){
			//putResultVal(data, "Aqui vai o Id pai tanto faz for form ou div");
			candidatosFavoritos.modalShowAvaliarCurriculo();
			hideCarregando();
		});
	},
	
	listar : function() {

		debugger
		$('#tableCandidatos').bootstrapTable({
			toolbar : ".toolbar",
			showRefresh : true,
			search : true,
			showToggle : true,
			showColumns : true,
			pagination : true,
			striped : true,
			sortable : true,
			url: '/empresa/candidato/listarCandidatos',
			pageSize : 2,
			pageList : [ 2, 10, 25, 50, 100 ],
			formatShowingRows : function(pageFrom, pageTo, totalRows) {
				// // do nothing here, we don't want to show the text
				// "showing x of y
				// // from..."
			},
			formatRecordsPerPage : function(pageNumber) {
				return pageNumber + " Linhas";
			},
			icons : {
				refresh : 'fa fa-refresh',
				toggle : 'fa fa-th-list',
				columns : 'fa fa-columns',
				detailOpen : 'fa fa-plus-circle',
				detailClose : 'fa fa-minus-circle'
			}
		});
	}
}