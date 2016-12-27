<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags/template/empresa" prefix="template"%>
<%@ taglib tagdir="/WEB-INF/tags/componentes" prefix="componente"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<template:admin>
	<jsp:attribute name="scriptsEspecificos">
		<script type="text/javascript"
			src="/static/js/sgoec/empregador/ajax.js"></script>
			
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

    </jsp:attribute>
	<jsp:body>
	<div class="container-fluid">
		<componente:titulo-pagina>
			<i class="write icon"></i> Cadastrar Empregador
		</componente:titulo-pagina>

		<componente:panel-padrao-sgoec>

		<c:import url="/view/template/form-usuario-conta.jsp"/>
		
		<!-- Inicio do Form Informações Pessoais -->
		<form id="formCadastrarEmpregador" class="form-horizontal">	
		
			
			<div class="form-group">
				<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
				
					<!-- Inicio Informações Básicas -->		
					<div class="panel panel-default">
						<div class="panel-heading text-center">
									<h4>Informações Básicas</h4>
								</div>
						<div class="panel-body">
							<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
								<div class="form-group">
									<div class="col-xs-3 col-sm-2 col-md-1 col-lg-1">
										<label for="id" class="">Id</label> 
										<input type="number" class="hidden" id="contaUsuarioId" name="contaUsuario.id"/>
										<input type="number" class="form-control" id="id" name="id"
													placeholder="" readonly="readonly" value="${id}" />
									</div>
								</div>
							</div>
							<div class="col-xs-12 col-sm-6 col-md-6 col-lg-4">
								<label for="nome" class="">Nome</label> 
								<input type="text" class="form-control" id="nome"
											name="pessoa.nome" data-toggle="tooltip" data-placement="top"
											title="Nome do empregador" placeholder="Nome do Empregador"
											value="${pessoa.nome}" />
							
							</div>
							
							<div class="col-xs-12 col-sm-6 col-md-6 col-lg-4">
								<label for="sobrenome" class="">Sobrenome</label> 
								<input type="text" class="form-control" id="sobrenome"
											name="pessoa.sobrenome" data-toggle="tooltip"
											data-placement="top" title="Sobrenome do empregador"
											placeholder="Sobrenome do Empregador"
											value="${pessoa.sobrenome}" />
							
							</div>
							
							<div class="col-xs-12 col-sm-6 col-md-6 col-lg-2">
								<label for="cpf" class="">CPF</label> 
								<input type="text" class="form-control cpf" id="cpf"
											name="pessoa.cpf" data-toggle="tooltip" data-placement="top"
											title="Digite o CPF" placeholder="Ex: 000.000.000-00"
											value="${pessoa.cpf}" />
							
							</div>
							
							<div class="col-xs-12 col-sm-6 col-md-6 col-lg-2">
								<label for="dataNascimento" class="">Data de Nascimeto</label> 
								<input type="text" class="form-control data" id="dataNascimento"
											data-toggle="tooltip" data-placement="top"
											title="Data de nascimento" name="pessoa.dataNascimento"
											placeholder="__/__/____" value="${pessoa.dataNascimento}" />
							
							</div>
							
							<div class="col-xs-12 col-sm-4 col-md-4 col-lg-4">
								<label for="rua" class="">Rua</label> 
								<input type="text" class="form-control" id="rua"
											name="pessoa.rua" data-toggle="tooltip" data-placement="top"
											title="Digite o nome da rua"
											placeholder="Digite o nome da rua" value="${pessoa.rua}" />
							
							</div>
							<div class="col-xs-12 col-sm-2 col-md-2 col-lg-2">
								<label for="numero" class="">Número</label> 
								<input type="number" class="form-control" id="numero"
											name="pessoa.numero" min="1" data-toggle="tooltip"
											data-placement="top" title="Digite o número da rua"
											placeholder="Digite o número da rua" value="${pessoa.numero}" />
							
							</div>
							<div class="col-xs-12 col-sm-3 col-md-3 col-lg-4">
								<label for="bairro" class="">Bairro</label> 
								<input type="text" class="form-control" id="bairro"
											name="pessoa.bairro" data-toggle="tooltip"
											data-placement="top" title="Digite o nome do bairro"
											placeholder="Digite o nome do bairro"
											value="${pessoa.bairro}" />
							
							</div>
							<div class="col-xs-12 col-sm-3 col-md-3 col-lg-2">
								<label for="cep" class="">CEP</label> 
								<input type="text" class="form-control cep" id="pessoa.cep"
											name="pessoa.cep" data-toggle="tooltip" data-placement="top"
											title="Digite o CEP da rua" placeholder="Ex: 00.000-000"
											value="${pessoa.cep}" />
							
							</div>
							<div class="col-xs-12 col-sm-12 col-md-3 col-lg-3">
								<label for="cargo">Cargo</label>
								<select id="cargo" name="cargo.id" class="form-control">
							        <c:forEach items="${listaCargo}" var="cargo"> 
							            <option value="${cargo.id}">${cargo.nome}</option>
							        </c:forEach>
							    </select>
							</div>
							<div class="col-xs-12 col-sm-4 col-md-3 col-lg-3">
								<label for="estado" class="">Estado</label> 
								<select class="form-control estado" id="estado"
											data-toggle="tooltip" data-placement="top"
											title="Escolha um estado">
							        <c:forEach items="${listaEstado}" var="estado"> 
							            <option value="${estado.id}">${estado.nome}</option>
							        </c:forEach>
							    </select>
							
							</div>
							<div class="col-xs-12 col-sm-4 col-md-3 col-lg-3">
								<label for="cidade" class="">Cidade</label> 
								<select class="form-control cidade" id="cidade"
											name="pessoa.cidade.id" data-toggle="tooltip"
											data-placement="top" title="Escolha uma cidade">
							        <c:forEach items="${listaCidade}" var="cidade"> 
							            <option value="${cidade.id}" name="cidade.id">${cidade.nome}</option>
							        </c:forEach>
							    </select>
							
							</div>
							<div class="col-xs-12 col-sm-4 col-md-3 col-lg-3">
								<label for="complemento" class="">Complemento</label> 
								<input type="text" class="form-control" id="complemento"
											name="pessoa.complemento" data-toggle="tooltip"
											data-placement="top"
											title="Digite um complemento caso queira"
											placeholder="Digite um complemento caso queira"
											value="${pessoa.complemento}" />
							</div>
						</div>
					</div>
					<!-- Final Informações Básicas -->
				</div>
			</div>
			
			
			<!-- Inicio Informações para contato -->
			<div class="form-group">
				<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
					<div class="panel panel-default">
						<div class="panel-heading text-center">
									<h4>Informações para Contato</h4>
								</div>
						<div class="panel-body">
						
							<div class="col-xs-12 col-sm-6 col-md-3 col-lg-3">
								<label for="telefone1" class="">Telefone 1</label> 
								<input type="text" type="text" class="form-control telefone"
											id="telefone1" name="pessoa.telefone1" data-toggle="tooltip"
											data-placement="top" title="Digite um telefone para contato"
											placeholder="(00) 0000-0000" value="${pessoa.telefone1}" />
							
							</div>
							<div class="col-xs-12 col-sm-6 col-md-3 col-lg-3">
								<label for="telefone2" class="">Telefone 2</label> 
								<input type="text" class="form-control telefone" id="telefone2"
											name="pessoa.telefone2" data-toggle="tooltip"
											data-placement="top" title="Outro telefone qualquer"
											placeholder="(00) 0000-0000" value="${pessoa.telefone2}" />
							
							</div>
							<div class="col-xs-12 col-sm-6 col-md-3 col-lg-3">
								<label for="celular1" class="">Celular 1</label> 
								<input type="text" class="form-control celular" id="celular1"
											name="pessoa.celular1" data-toggle="tooltip"
											data-placement="top" title="Digite um celular para contato"
											placeholder="(00) 0000-0000 ou (00) 00000-0000"
											value="${pessoa.celular1}" />
							
							</div>
							<div class="col-xs-12 col-sm-6 col-md-3 col-lg-3">
								<label for="celular2" class="">Celular 2</label> 
								<input type="text" class="form-control celular" id="celular2"
											name="pessoa.celular2" data-toggle="tooltip"
											data-placement="top" title="Outro celular qualquer"
											placeholder="(00) 0000-0000 ou (00) 00000-0000"
											value="${pessoa.celular2}" />
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- Final Informações para contato -->
			
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
		<!-- Final do Form Informações Pessoais-->
		
		</componente:panel-padrao-sgoec>
	</div>
</jsp:body>

</template:admin>