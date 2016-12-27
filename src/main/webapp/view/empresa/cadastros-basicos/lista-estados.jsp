<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags/template/empresa" prefix="template"%>
<%@ taglib tagdir="/WEB-INF/tags/componentes" prefix="componente"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<template:admin>

	<jsp:attribute name="cssEspecificos">
		<link href="/static/css/bootstrap-table/fresh-bootstrap-table2.css"
			rel="stylesheet" />	
				
		<link href="/static/css/bootstrap-table/bootstrap.css"
			rel="stylesheet" />	
			
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
		
		<script type="text/javascript" src="/static/js/sgoec/estado/ajax.js"></script>
			
	      <script type="text/javascript"
			src="/static/js/sgoec/estado/estado.js"></script>
    </jsp:attribute>

	<jsp:body>
	<div class="container-fluid">
		
		<componente:titulo-pagina>
			<i class="table icon"></i> Estados
		</componente:titulo-pagina>
		
		<componente:panel-padrao-sgoec>
			<div class="row">
				<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
					<div class="fresh-table toolbar-color-orange" >
						
<!-- 						Talvez -->
<!-- 						<div class="toolbar"> -->
<!-- 							<button id="btnCadastrarCargo" class="btn btn-default" type="button" onclick="cargo.modalShowCadastroCargo()">Cadastrar</button> -->
<!-- 						</div> -->
						
				        <table id="tableEstados" class="table"
								data-mobile-responsive="true">
				            <thead>
				            <tr>
				                <th data-field="id">ID</th>
				            	<th data-field="nome">Nome</th>
				            </tr>
				            </thead>
				        </table>
	    			</div>
				</div>
			</div>
		</componente:panel-padrao-sgoec>
<!-- 		Talvez -->
<%-- 		<c:import url="/view/empresa/include/cidade/cadastro-cidade.jsp" /> --%>
	</div>
	
	</jsp:body>
</template:admin>