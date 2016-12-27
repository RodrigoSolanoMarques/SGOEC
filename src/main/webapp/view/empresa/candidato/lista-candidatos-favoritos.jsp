<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags/template/empresa" prefix="template"%>
<%@ taglib tagdir="/WEB-INF/tags/componentes" prefix="componente"%>
<template:admin>
	<jsp:attribute name="cssEspecificos">
	<link href="/static/css/bootstrap-table/fresh-bootstrap-table.css"
			rel="stylesheet" />	
	<link href="/static/css/bootstrap-table/bootstrap.css" rel="stylesheet" />	
		<link href="/static/css/bootstrap-table/bootstrap-table.min.css"
			rel="stylesheet" />
		
				
		<link
			href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css"
			rel="stylesheet">
		<link href='http://fonts.googleapis.com/css?family=Roboto:400,700,300'
			rel='stylesheet' type='text/css'>
 	</jsp:attribute>

	<jsp:attribute name="scriptsEspecificos">
      <script type="text/javascript"
			src="/static/js/bootstrap-table/jquery-1.11.2.min.js"></script>
		<script type="text/javascript"
			src="/static/js/bootstrap-table/bootstrap-table.min.js"></script>
		<script type="text/javascript"
			src="/static/js/bootstrap-table/bootstrap-table-mobile.min.js"></script>
		
		<script type="text/javascript"
			src="/static/js/sgoec/candidato/favoritos/candidatos-favoritos.js"></script>
		<script type="text/javascript"
			src="/static/js/sgoec/candidato/listar/ajax.js">
				</script>
				<script type="text/javascript" src="/static/js/sgoec/funcoes.js"></script>
    </jsp:attribute>

	<jsp:body>
	<div class="container-fluid">
		
		<componente:titulo-pagina>
			<i class="table icon"></i> Candidatos Favoritos
		</componente:titulo-pagina>
		
		<componente:panel-padrao-sgoec>
			<div class="row">
				<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
					<div class="fresh-table toolbar-color-orange">
				        <table id="tableFavoritosCandidatos" class="table"
								data-mobile-responsive="true">
				            <thead>
				            <tr>
				                <th data-field="candidato.pessoa.id"
											data-align="center">ID</th>
				            	<th data-field="candidato.pessoa.nome"
											data-formatter="nomeCompletoFormatter" data-align="center">Nome</th>
				            	<th data-field="candidato.titulacao"
											data-align="center">Titulação</th>
				            	<th data-field="oportunidadeEmprego.cargo.nome"
											data-align="center">Oportunidade de Emprego</th>
				            	<th data-field="id"
											data-formatter="isCurriculoFormatter" data-align="center">Currículo</th>
				            	<th data-field="candidato.isFavorito"
											data-formatter="isFavoritoFormatter" data-align="center">Favorito</th>
				            </tr>
				            </thead>
				        </table>
	    			</div>
				</div>
			</div>
		</componente:panel-padrao-sgoec>
	</div>
	</jsp:body>
</template:admin>