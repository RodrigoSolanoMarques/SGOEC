<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags/template/empresa" prefix="template"%>
<%@ taglib tagdir="/WEB-INF/tags/componentes" prefix="componente"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<template:admin>

	<jsp:attribute name="scriptsEspecificos">
		<script type="text/javascript" src="/static/js/sgoec/cargo/ajax.js"></script>
	    <script type="text/javascript"
			src="/static/js/sgoec/cargo/cargo.js"></script>
		<script type="text/javascript" src="/static/js/sgoec/funcoes.js"></script>

    </jsp:attribute>

	<jsp:body>
	<div class="container-fluid">
		<componente:titulo-pagina>
			<i class="write icon"></i> Cadastrar Cargo
		</componente:titulo-pagina>

		<componente:panel-padrao-sgoec>
			<form id="formCadastrarCargo" class="form-horizontal">
			<!-- Inicio Informações Básicas -->		
					<div class="panel panel-default">
						<div class="panel-heading text-right">
							
								<a type="button" id="btnCadastrarCargo" class="btn btn-default"
								href="/empresa/cargo/">Voltar</a>
							
						</div>
						<div class="panel-body">
			
							<div class="form-group">
								<div class="col-xs-3 col-sm-2 col-md-1 col-lg-1">
									<label for="id" class="">Id</label> 
									<input class="form-control" id="id" name="id" placeholder=""
										readonly="readonly" value="${id}" />
								</div>
							</div>
								
							<div class="form-group">
								<div class="col-xs-12 col-sm-12 col-md-6 col-lg-6">
									<label for="nome" class="">Nome</label> 
									<input class="form-control" id="nome" name="nome"
										placeholder="Nome do Cargo" value="${nome}" />
								</div>
							
								<div class="col-xs-12 col-sm-12 col-md-6 col-lg-6">
									<label for="descricao" class="">Descrição</label> 
									<input class="form-control" id="descricao" name="descricao"
										placeholder="Descrição do Cargo" value="${descricao}" />
								</div>
							</div>
							<hr>
							<div class="form-group">
								<div
									class="col-xs-6 col-sm-offset-6 col-sm-3 col-md-offset-8 col-md-2 col-lg-offset-8 col-lg-2">
									<button type="submit"
										class="btn btn-default btn-block text-right">Salvar</button>
								</div>
								<div class="col-xs-6 col-sm-3 col-md-2 col-lg-2">
									<button type="reset"
										class="btn btn-default btn-block text-right">Limpar</button>
								</div>
							</div>
					
						</div>
					</div>
			</form>
		
		</componente:panel-padrao-sgoec>
		
	</div>
</jsp:body>

</template:admin>