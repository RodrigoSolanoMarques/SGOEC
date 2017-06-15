<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags/componentes" prefix="componente"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="modal" id="modalCadastroCargo" tabindex="-1" role="dialog">
	<div class="modal-dialog " role="document">
		<div class="modal-content">
			<div class="modal-header">

				<button type="button" class="close" aria-label="Close"
					onclick="cargo.modalHideCadastroCargo();">
					<span aria-hidden="true">&times;</span>
				</button>
				<i class="write icon"></i> Cadastrar Cargo

			</div>
			<div class="modal-body">

				<form id="modalFormCadastrarCargo" class="form-horizontal"
					method="POST">
					<!-- Inicio Informações Básicas -->

					<div class="form-group">
						<div class="col-xs-3 col-sm-2 col-md-2 col-lg-2">
							<label for="id" class="">Id</label> <input class="form-control"
								id="id" name="id" placeholder="" readonly="readonly"
								value="${id}" />
						</div>

						<div class="col-xs-9 col-sm-10 col-md-10 col-lg-10">
							<label for="areaProfissional">Área Profissional</label> <select
								id="areaProfissional" class="form-control"
								name="areaProfissional.id" data-toggle="tooltip"
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
							<label for="nome" class="">Nome</label> <input
								class="form-control" id="nome" name="nome"
								placeholder="Nome do Cargo" value="${nome}" />
						</div>

						<div class="col-xs-12 col-sm-12 col-md-6 col-lg-6">
							<label for="descricao" class="">Descrição</label> <input
								class="form-control" id="descricao" name="descricao"
								placeholder="Descrição do Cargo" value="${descricao}" />
						</div>
					</div>
				</form>

			</div>
			<div class="modal-footer text-right">
				<button id="btnModalFormSalvarCargo" type="button"
					class="btn btn-default"
					onclick="cargo.modalSalvarFormCadastroCargo()">Salvar</button>
				<button id="btnModalFormLimparCargo" type="button"
					class="btn btn-default"
					onclick="cargo.modalLimparFormCadastrarCargo();">Limpar</button>
				<button id="btnModalFormCancelarCargo" type="button"
					class="btn btn-default" onclick="cargo.modalHideCadastroCargo();">Fechar</button>
			</div>
		</div>
	</div>
</div>