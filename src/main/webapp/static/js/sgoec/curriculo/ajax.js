var ajaxCurriculo = {
		
		carregar: function(curriculo){
			$.getJSON("/empresa/candidato/carregar", {id: curriculo.id},function(data){
				//putResultVal(data, "Aqui vai o Id pai tanto faz for form ou div");
				curriculo.modalShowAvaliarCurriculo();
				hideCarregando();
			});
		}
};