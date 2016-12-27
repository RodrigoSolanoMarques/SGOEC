<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags/template/empresa" prefix="template"%>
<%@ taglib tagdir="/WEB-INF/tags/componentes" prefix="componente"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<template:admin>

	<jsp:attribute name="scriptsEspecificos">
		<script type="text/javascript"
			src="/static/js/sgoec/empresa/ajax.js"></script>
			
		   <script type="text/javascript"
			src="/static/js/sgoec/empresa/empresa.js"></script>
			
		<script type="text/javascript" src="/static/js/sgoec/cidade/ajax.js"></script>
		   <script type="text/javascript"
			src="/static/js/sgoec/cidade/cidade.js"></script>
			
		<script type="text/javascript"
			src="/static/js/jquery-mask/jquery.mask.min.js"></script>
	
	  </jsp:attribute>

	<jsp:body>
	<div class="container-fluid">
		<componente:titulo-pagina>
			<i class="write icon"></i> Cadastrar Empresa
		</componente:titulo-pagina>

		<componente:panel-padrao-sgoec>
			
			<!-- Inicio do Form Informações Empresa -->
			<form id="formCadastrarEmpresa" class="form-horizontal">
				
				<div class="form-group">
					<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
						
						<!-- Inicio Informações Empresa -->		
						<div class="panel panel-default">
							<div class="panel-heading text-center">
								<h4>Informações</h4>
							</div>
							<div class="panel-body">
								
								<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
								
									<div class="form-group">
										<div class="col-xs-3 col-sm-2 col-md-1 col-lg-1">
											<label for="id" class="">Id</label> 
											<input type="number" class="form-control" id="id" name="id"
													placeholder="" readonly="readonly" value="${id}" />
										</div>
									</div>
									
								</div>
								<div class="col-xs-12 col-sm-6 col-md-4 col-lg-4">
									<label for="razaoSocial" class="">Razão Social</label> 
									<input type="text" class="form-control" id="razaoSocial"
											name="razaoSocial" data-toggle="tooltip" data-placement="top"
											title="Razão Social" placeholder="Razão Social"
											value="${razaoSocial}" />
								
								</div>
								<div class="col-xs-12 col-sm-6 col-md-4 col-lg-4">
									<label for="nomeFantasia" class="">Nome Fantasia</label> 
									<input type="text" class="form-control" id="nomeFantasia"
											name="nomeFantasia" data-toggle="tooltip"
											data-placement="top" title="Nome Fantasia"
											placeholder="Nome Fantasia" value="${nomeFantasia}" />
								
								</div>
								<div class="col-xs-12 col-sm-6 col-md-4 col-lg-4">
									<label for="cpfCnpj" class="">Tipo da Pessoa</label>
									<div class="input-group">
								      <span class="input-group-addon">
								      <label for="inscricaoEstadual" class="">CPF</label>
								        <input id="cpf" type="radio" name="isPessoaJuridica"
												value="true" onclick="empresa.validaCpfCnpj()" checked>
								      </span>
								      <span class="input-group-addon">
								      <label for="inscricaoEstadual" class="">CNPJ</label>
								        <input id="cnpj" type="radio" name="isPessoaJuridica"
												value="false" onclick="empresa.validaCpfCnpj()">
								      </span>
								      <input id="cpfCnpj" name="cpfCnpj" type="text"
												class="form-control">
								    </div>
								
								</div>
								
								<div class="col-xs-12 col-sm-6 col-md-4 col-lg-4">
									<label for="estado" class="">Estado</label> 
									<select class="form-control estado" id="estado"
											data-toggle="tooltip" data-placement="top"
											title="Escolha um estado">
								        <c:forEach items="${listaEstado}" var="estado"> 
								            <option value="${estado.id}">${estado.nome}</option>
								        </c:forEach>
								    </select>
								
								</div>
								<div class="col-xs-12 col-sm-6 col-md-4 col-lg-4">
									<label for="cidade" class="">Cidade</label> 
									<select class="form-control cidade" id="cidade"
											name="cidade.id" data-toggle="tooltip" data-placement="top"
											title="Escolha uma cidade">
								        <c:forEach items="${listaCidade}" var="cidade"> 
								            <option value="${cidade.id}" name="cidade.id">${cidade.nome}</option>
								        </c:forEach>
								    </select>
								
								</div>
								
								<div class="col-xs-12 col-sm-6 col-md-4 col-lg-4 hidden">
									<label for="inscricaoEstadual" class="">Inscrição Estadual</label> 
									<input type="text" class="form-control" id="inscricaoEstadual"
											name="inscricaoEstadual" data-toggle="tooltip"
											data-placement="top" title="Inscrição Estadual"
											placeholder="Inscrição Estadual" value="${inscricaoEstadual}" />
								
								</div>
								
								
								<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
					
									<div class="form-group">
										<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
											<label for="visao" class="">Visão</label>
											<textarea id="visao" name="visao" class="form-control"
													rows="4" placeholder="A visão da empresa"></textarea>
										</div>
									</div>
									<div class="form-group">
										<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
											<label for="missao" class="">Missão</label>
											<textarea id="missao" name="missao" class="form-control"
													rows="4" placeholder="A missão da empresa"></textarea>
										</div>
									</div>
									<div class="form-group">
										<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
											<label for="valores" class="">Valores</label>
											<textarea id="valores" name="valores" class="form-control"
													rows="4" placeholder="Os Valores da empresa"></textarea>
										</div>
									</div>
								</div>
								
							</div>							
						</div>
						<!-- Final Informações Empresa -->	
						
					</div>
				</div>
				
				<hr>
				<!-- Inicio Botões -->
				<div class="form-group">
					<div
							class="col-xs-6 col-sm-offset-6 col-sm-3 col-md-offset-8 col-md-2 col-lg-offset-8 col-lg-2">
						<button type="submit" class="btn btn-default btn-block text-right">Salvar</button>
					</div>
					<div class="col-xs-6 col-sm-3 col-md-2 col-lg-2">
						<button type="reset" class="btn btn-default btn-block text-right">Limpar</button>
					</div>
				</div>
				<!-- Final Botões -->
				
			</form>
			<!-- Final do Form Informações Empresa -->
			
		</componente:panel-padrao-sgoec>
		
	</div>
</jsp:body>

</template:admin>