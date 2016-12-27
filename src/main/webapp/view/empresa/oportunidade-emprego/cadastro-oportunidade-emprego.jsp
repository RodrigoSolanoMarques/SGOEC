<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags/template/empresa" prefix="template"%>
<%@ taglib tagdir="/WEB-INF/tags/componentes" prefix="componente"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<template:admin>

	<jsp:attribute name="scriptsEspecificos">
	<script type="text/javascript"
			src="/static/js/sgoec/oportunidade-emprego/ajax.js"></script>
      <script type="text/javascript"
			src="/static/js/sgoec/oportunidade-emprego/oportunidade-emprego.js"></script>
			
			<script type="text/javascript" src="/static/js/sgoec/cidade/ajax.js"></script>
	      <script type="text/javascript"
			src="/static/js/sgoec/cidade/cidade.js"></script>
			
			<script type="text/javascript"
			src="/static/js/jquery-mask/jquery.mask.min.js"></script>			
    </jsp:attribute>

	<jsp:body>
	<div class="container-fluid">
		<componente:titulo-pagina>
			<i class="write icon"></i> Cadastrar Oportunidade de Emprego
		</componente:titulo-pagina>

		<componente:panel-padrao-sgoec>
			<form id="formCadastrarOportunidadeEmprego" class="form-horizontal">
				<div class="form-group">
					<div class="col-xs-3 col-sm-2 col-md-1 col-lg-1">
						<label for="id" class="">Id</label> <input class="form-control"
								id="id" name="id" placeholder="" readonly="readonly" />
					</div>
				</div>
				
					
				<div class="form-group">
					<div class="col-xs-12 col-sm-12 col-md-6 col-lg-6">
						
						
						<div class="form-group">
							<div class="col-xs-12 col-sm-12 col-md-6 col-lg-6">
								<input class="form-control" id="idEmpresa" name="empresa.id"
										value="${empresa.id}" readonly hidden>
								<label for="nomeEmpresa">Empresa</label> <input
										class="form-control" id="nomeEmpresa"
										name="empresa.nomeFantasia" placeholder="Empresa"
										readonly="readonly" value="${empresa.nomeFantasia}" />
							</div>
							<div class="col-xs-12 col-sm-12 col-md-6 col-lg-6">
							<input class="form-control" id="idEpregador" name="empregador.id"
										value="${empregador.id}" readonly hidden>
								<label for="empregador">Empregador</label> 						
								<input class="form-control" id="empregador"
										name="empregador.pessoa.nome" placeholder="Empregador"
										value="${empregador.pessoa.nome}" readonly>
							</div>
							<div class="col-xs-12 col-sm-12 col-md-6 col-lg-6">
								<label for="estado">Estado</label> 
								<select id="estado" class="form-control estado">
							        <c:forEach items="${listaEstado}" var="estado"> 
							            <option value="${estado.id}">${estado.nome}</option>
							        </c:forEach>
							    </select>
							</div>
							<div class="col-xs-12 col-sm-12 col-md-6 col-lg-6">
								<label for="cidade">Cidade</label> 
								<select id="cidade" name="cidade.id" class="form-control cidade">
							        <c:forEach items="${listaCidade}" var="cidade"> 
							            <option value="${cidade.id}" name="cidade.id">${cidade.nome}</option>
							        </c:forEach>
							    </select>
							</div>
							
							<div class="col-xs-12 col-sm-12 col-md-6 col-lg-6">
								<label for="cargo">Cargo</label>
								<select id="cargo" name="cargo.id" class="form-control">
							        <c:forEach items="${listaCargo}" var="cargo"> 
							            <option value="${cargo.id}">${cargo.nome}</option>
							        </c:forEach>
							    </select>
							</div>
							
							<div class="col-xs-12 col-sm-12 col-md-6 col-lg-6">
								<div class="form-group">
									<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
										<label class="control-label">Carga Horária</label>
									</div>
									<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
										
											<input type="text" id="cargaHoraria" name="cargaHoraria"
												class="form-control" placeholder="Ex: 44/h por Semana" />
													
									</div>
								</div>
							</div>
							
							<div class="col-xs-12 col-sm-12 col-md-6 col-lg-6">
							<label class="control-label">Salário</label>

								<div class="input-group">
									<span class="input-group-addon">
							        	<input id="isSalario" name="isSalario"
											type="checkbox" onclick="validaIsSalario()">
							      	</span>
								  <span class="input-group-addon">R$</span>
								  <input id="txtSalario" name="salario" type="text"
											class="form-control text-right" readonly />
								  
								</div>
							</div>
						</div>
					</div>
					
					<div class="col-xs-12 col-sm-12 col-md-6 col-lg-6">
					
						<div class="form-group">
							<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
								<label for="beneficios" class="">Benefícios</label>
								<textarea id="beneficios" name="beneficios" class="form-control"
										rows="4"
										placeholder="Detalhe os benefícios que serão disponibilizado ao cargo"></textarea>
							</div>
						</div>
						<div class="form-group">
							<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
								<label for="descricao" class="">Descrição do Cargo</label>
								<textarea id="descricao" name="descricao" class="form-control"
										rows="4"
										placeholder="Detalhe as atividades exercidas no cargo"></textarea>
							</div>
						</div>
					</div>
				</div>
				<hr />
				<div class="form-group">
					<div
							class="col-xs-6 col-sm-offset-6 col-sm-3 col-md-offset-8 col-md-2 col-lg-offset-8 col-lg-2">
						<button type="submit" class="btn btn-default btn-block text-right">Salvar</button>
					</div>
					<div class="col-xs-6 col-sm-3 col-md-2 col-lg-2">
						<button type="reset" class="btn btn-default btn-block text-right">Limpar</button>
					</div>
				</div>
			</form>
		</componente:panel-padrao-sgoec>
		
	</div>
</jsp:body>
</template:admin>