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
			
			<link href="/static/css/sgoec/style.css"
			rel='stylesheet' type='text/css'>
 	</jsp:attribute>

	<jsp:attribute name="scriptsEspecificos">
<!--       <script type="text/javascript" -->
<!-- 			src="/static/js/bootstrap-table/jquery-1.11.2.min.js"></script> -->
		<script type="text/javascript"
			src="/static/js/bootstrap-table/bootstrap-table.min.js"></script>
		<script type="text/javascript"
			src="/static/js/bootstrap-table/bootstrap-table-mobile.min.js"></script>
		
		<script type="text/javascript" src="/static/js/sgoec/empregador/ajax.js"></script>
			
	      <script type="text/javascript"
			src="/static/js/sgoec/empregador/empregador.js"></script>
			
			<script type="text/javascript" src="/static/js/sgoec/cidade/ajax.js"></script>
	    <script type="text/javascript"
			src="/static/js/sgoec/cidade/cidade.js"></script>
			
		<script type="text/javascript" src="/static/js/sgoec/conta-usuario/ajax.js"></script>
		
	    <script type="text/javascript"
			src="/static/js/sgoec/conta-usuario/conta-usuario.js"></script>
			
		<script type="text/javascript"
			src="/static/js/jquery-mask/jquery.mask.min.js"></script>
			
			<script type="text/javascript"
			src="/static/js/sgoec/funcoes.js"></script>
    </jsp:attribute>

	<jsp:body>
	<div class="container-fluid">
		
		<componente:titulo-pagina>
			<i class="table icon"></i> Empregadores
		</componente:titulo-pagina>
		
		<componente:panel-padrao-sgoec>
			<div class="row">
				<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
					<div class="fresh-table toolbar-color-orange" >
						
						<div class="toolbar">
							<button id="btnCadastrarEmpregador" class="btn btn-default" type="button" onclick="empregador.modalShowCadastroEmpregador()">Cadastrar</button>
						</div>
						
				        <table id="tableEmpregadores" class="table"
								data-mobile-responsive="true">
				            <thead>
				            <tr>
				                <th data-field="pessoa.id">ID</th>
				            	<th data-field="pessoa.nome">Nome</th>
				            	<th data-field="pessoa.cpf">CPF</th>
				            	<th data-field="cargo.nome">Cargo</th>
				            	<th data-field="pessoa.dataNascimento">Data Nasc.</th>
				            	<th data-field="pessoa.cidade.nome">Cidade</th>
				            	<th data-field="pessoa.cidade.estado.uf">UF</th>
				            </tr>
				            </thead>
				        </table>
	    			</div>
				</div>
			</div>
		</componente:panel-padrao-sgoec>
		<c:import url="/view/empresa/include/empregador/cadastro-empregador.jsp" />
	</div>
	
	</jsp:body>
</template:admin>