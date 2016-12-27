<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags/componentes" prefix="componente"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- Modal -->
<div class="modal scroll" id="modalCadastroEmpresa" tabindex="-1"
	role="dialog">
	<div class="modal-dialog modal-lg" role="document">
		<div class="modal-content">
			<div class="modal-header">

				<i class="write icon"></i> Cadastrar Empresa
				<button type="button" class="close" aria-label="Close" onclick="empresa.modalHideCadastroEmpresa();">
				<span aria-hidden="true">&times;</span></button>
			</div>

			<div class="modal-body">

			<!-- Inicio do Form Informações Empresa -->
			<form id="modalFormCadastrarEmpresa" class="form-horizontal">
				
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
										<div class="col-xs-4 col-sm-3 col-md-2 col-lg-2">
											<label for="id" class="">Id</label> 
											<input type="number" class="form-control" id="id" name="id"
													placeholder="" readonly="readonly" value="${id}" />
										</div>
									</div>
									
								</div>
								<div class="col-xs-12 col-sm-6 col-md-6 col-lg-6">
									<label for="razaoSocial" class="">Razão Social</label> 
									<input type="text" class="form-control" id="razaoSocial"
											name="razaoSocial" data-toggle="tooltip" data-placement="top"
											title="Razão Social" placeholder="Razão Social"
											value="${razaoSocial}" />
								
								</div>
								<div class="col-xs-12 col-sm-6 col-md-6 col-lg-6">
									<label for="nomeFantasia" class="">Nome Fantasia</label> 
									<input type="text" class="form-control" id="nomeFantasia"
											name="nomeFantasia" data-toggle="tooltip"
											data-placement="top" title="Nome Fantasia"
											placeholder="Nome Fantasia" value="${nomeFantasia}" />
								
								</div>
								<div class="col-xs-12 col-sm-12 col-md-6 col-lg-6">
									<label for="cpfCnpj" class="">Tipo da Pessoa</label>
									<div class="input-group">
								      <span class="input-group-addon">
								      <label for="inscricaoEstadual" class="">CPF</label>
								        <input id="cpf" type="radio" name="isPessoaJuridica"
												value="true" onclick="empresa.validaCpfCnpj()">
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
								
								<div class="col-xs-12 col-sm-12 col-md-6 col-lg-6">
									<label for="estado" class="">Estado</label> 
									<select class="form-control estado" id="estado"
											name="cidade.estado.id" data-toggle="tooltip" data-placement="top"
											title="Escolha um estado">
								        <c:forEach items="${listaEstado}" var="estado"> 
								            <option value="${estado.id}">${estado.nome}</option>
								        </c:forEach>
								    </select>
								
								</div>
								<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
									<label for="cidade" class="">Cidade</label> 
									<select class="form-control cidade" id="cidade"
											name="cidade.id" data-toggle="tooltip" data-placement="top"
											title="Escolha uma cidade">
								        <c:forEach items="${listaCidade}" var="cidade"> 
								            <option value="${cidade.id}">${cidade.nome}</option>
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
				</form>
			
			</div>

			<div class="modal-footer">

				<button id="btnModalFormSalvarEmpresa" type="button"
					class="btn btn-default"
					onclick="empresa.modalSalvarFormCadastroEmpresa()">Salvar</button>
				<button id="btnModalFormLimparEmpresa" type="button"
					class="btn btn-default"
					onclick="empresa.modalLimparFormCadastrarEmpresa();">Limpar</button>
				<button id="btnModalFormCancelarEmpresa" type="button"
					class="btn btn-default"
					onclick="empresa.modalHideCadastroEmpresa();">Fechar</button>

			</div>
		</div>
	</div>
</div>