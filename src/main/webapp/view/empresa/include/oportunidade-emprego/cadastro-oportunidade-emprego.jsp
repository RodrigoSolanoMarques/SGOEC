<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags/componentes" prefix="componente"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- Modal -->
<div class="modal scroll" id="modalCadastroOportunidadeEmprego"
	tabindex="-1" role="dialog">
	<div class="modal-dialog modal-lg" role="document">
		<div class="modal-content">
			<div class="modal-header">

				<i class="write icon"></i> Cadastrar Oportunidade de Emprego
				<button type="button" class="close" aria-label="Close"
					onclick="oportunidadeEmprego.modalHideCadastroOportunidadeEmprego();">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>

			<div class="modal-body">

				<!-- Inicio do Form -->

				<form id="modalFormCadastrarOportunidadeEmprego"
					class="form-horizontal">
					
					<div class="form-group">
						<div class="col-xs-3 col-sm-2 col-md-1 col-lg-1">
							<label for="id" class="">Id</label> <input class="form-control"
								id="id" name="id" placeholder="" readonly="readonly" />
						</div>
						<div class="col-xs-9 col-sm-10 col-md-5 col-lg-5">
							<label for="areaProfissional">Área Profissional</label> <select
								id="areaProfissional" class="form-control"
								name="cargo.areaProfissional.id" data-toggle="tooltip"
								data-placement="top" title="Escolha uma Area Profissional">
								<c:forEach items="${listaAreaProfissional}"
									var="areaProfissional">
									<option value="${areaProfissional.id}">${areaProfissional.nome}</option>
								</c:forEach>
							</select>
						</div>

					</div>

					<div class="form-group">
						<div class="col-xs-12 col-sm-12 col-md-6 col-lg-6">

							<div class="form-group">
								<div class="col-xs-12 col-sm-12 col-md-6 col-lg-6">
									<input class="form-control hide" id="idEmpresa"
										name="empresa.id" value="${empresa.id}" readonly> <label
										for="nomeEmpresa">Empresa</label> <input class="form-control"
										id="nomeEmpresa" name="cargo.empresa.nomeFantasia"
										data-toggle="tooltip" data-placement="top" title="Empresa"
										placeholder="Empresa" readonly="readonly"
										value="${empresa.nomeFantasia}" />
								</div>
								<div class="col-xs-12 col-sm-12 col-md-6 col-lg-6">
									<input class="form-control hide" id="idEpregador"
										name="empregador.id" value="${empregador.id}" readonly hidden>
									<label for="empregador">Empregador</label> <input
										class="form-control" id="empregador"
										name="empregador.pessoa.nome" data-toggle="tooltip"
										data-placement="top" title="Empregador"
										placeholder="Empregador" value="${empregador.pessoa.nome}"
										readonly>
								</div>
								<div class="col-xs-12 col-sm-12 col-md-6 col-lg-6">
									<label for="estado">Estado</label> <select id="estado"
										class="form-control estado" name="cidade.estado.id"
										data-toggle="tooltip" data-placement="top"
										title="Escolha um Estado">
										<c:forEach items="${listaEstado}" var="estado">
											<option value="${estado.id}">${estado.nome}</option>
										</c:forEach>
									</select>
								</div>
								<div class="col-xs-12 col-sm-12 col-md-6 col-lg-6">
									<label for="cidade">Cidade</label> <select id="cidade"
										name="cidade.id" data-toggle="tooltip" data-placement="top"
										title="Escolha uma Cidade" class="form-control cidade">
										<c:forEach items="${listaCidade}" var="cidade">
											<option value="${cidade.id}" name="cidade.id">${cidade.nome}</option>
										</c:forEach>
									</select>
								</div>

								<div class="col-xs-12 col-sm-12 col-md-6 col-lg-6">
									<label for="cargo">Cargo</label> <select id="cargo"
										name="cargo.id" data-toggle="tooltip" data-placement="top"
										title="Escolha um Cargo" class="form-control">
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
												class="form-control" data-toggle="tooltip"
												data-placement="top" title="Defina uma Carga Horária"
												placeholder="Ex: 44/h por Semana" />

										</div>
									</div>
								</div>

								<div class="col-xs-12 col-sm-12 col-md-6 col-lg-6">
									<label class="control-label">Salário</label>

									<div class="input-group">
										<span class="input-group-addon"> <input id="isSalario"
											name="isSalario" type="checkbox" onclick="validaIsSalario()">
										</span> <span class="input-group-addon">R$</span> <input
											id="txtSalario" name="salario" data-toggle="tooltip"
											data-placement="top" title="Salário" type="text"
											class="form-control text-right" readonly />

									</div>
								</div>
							</div>
							<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
								<div class="form-group">
									<input id="isFinalizado" name="isFinalizado" type="checkbox">
									<label id="labelIsFinalizado" for="isFinalizado" style="color: blue;">Finalizar está Oportunidade
										de Emprego?</label>
								</div>

							</div>
						</div>

						<div class="col-xs-12 col-sm-12 col-md-6 col-lg-6">
							<div class="form-group">
								<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
									<label for="beneficios" class="">Benefícios</label>
									<textarea id="beneficios" name="beneficios"
										data-toggle="tooltip" data-placement="top"
										title="Detalhe os benefícios que serão disponibilizados ao cargo"
										class="form-control" rows="7"
										placeholder="Detalhe os benefícios que serão disponibilizados ao cargo"></textarea>
								</div>
							</div>
							<div class="form-group">
								<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
									<label for="descricao" class="">Descrição do Cargo</label>
									<textarea id="descricao" name="descricao" data-toggle="tooltip"
										data-placement="top"
										title="Detalhe as atividades exercidas no cargo"
										class="form-control" rows="7"
										placeholder="Detalhe as atividades exercidas no cargo"></textarea>
								</div>
							</div>
						</div>
					</div>
				</form>

				<!-- Fim do Form -->

			</div>

			<div class="modal-footer">

				<button id="btnModalFormSalvarOportunidadeEmprego" type="button"
					class="btn btn-default"
					onclick="oportunidadeEmprego.modalSalvarFormCadastroOportunidadeEmprego()">Salvar</button>
				<button id="btnModalFormLimparOportunidadeEmprego" type="button"
					class="btn btn-default"
					onclick="oportunidadeEmprego.modalLimparFormCadastrarOportunidadeEmprego();">Limpar</button>
				<button id="btnModalFormCancelarOportunidadeEmprego" type="button"
					class="btn btn-default"
					onclick="oportunidadeEmprego.modalHideCadastroOportunidadeEmprego();">Fechar</button>

			</div>
		</div>
	</div>
</div>