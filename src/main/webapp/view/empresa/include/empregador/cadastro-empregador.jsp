<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags/componentes" prefix="componente"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- Modal -->
<div class="modal scroll" id="modalCadastroEmpregador" tabindex="-1"
	role="dialog">
	<div class="modal-dialog modal-lg" role="document">
		<div class="modal-content">
			<div class="modal-header">

				<i class="write icon"></i> Cadastrar Empregador
				<button type="button" class="close" aria-label="Close"
					onclick="empregador.modalHideCadastroEmpregador();">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>

			<div class="modal-body">

				<c:import url="/view/template/form-usuario-conta.jsp"></c:import>

				<!-- Inicio do Form Informações Pessoais -->
				<form id="modalFormCadastrarEmpregador" class="form-horizontal">


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
											<div class="col-xs-3 col-sm-3 col-md-2 col-lg-2">
												<label for="id" class="">Id</label> <input type="number"
													class="" id="contaUsuarioId" name="contaUsuario.id" hidden/>
												<input type="number" class="form-control" id="id" name="id"
													placeholder="" readonly="readonly" value="${id}" />
											</div>
										</div>
									</div>
									<div class="col-xs-12 col-sm-6 col-md-6 col-lg-6">
										<label for="nome" class="">Nome</label> 
										<input type="number" class="form-control hidden" name="pessoa.id"
													placeholder="" readonly="readonly" value="${pessoa.id}" />
										<input type="text"
											class="form-control" id="nome" name="pessoa.nome"
											data-toggle="tooltip" data-placement="top"
											title="Nome do empregador" placeholder="Nome do Empregador"
											value="${pessoa.nome}" required/>

									</div>

									<div class="col-xs-12 col-sm-6 col-md-6 col-lg-6">
										<label for="sobrenome" class="">Sobrenome</label> <input
											type="text" class="form-control" id="sobrenome"
											name="pessoa.sobrenome" data-toggle="tooltip"
											data-placement="top" title="Sobrenome do empregador"
											placeholder="Sobrenome do Empregador"
											value="${pessoa.sobrenome}" required/>

									</div>

									<div class="col-xs-12 col-sm-6 col-md-6 col-lg-3">
										<label for="cpf" class="">CPF</label> <input type="text"
											class="form-control cpf" id="cpf" name="pessoa.cpf"
											data-toggle="tooltip" data-placement="top"
											title="Digite o CPF" placeholder="Ex: 000.000.000-00"
											value="${pessoa.cpf}" required/>

									</div>

									<div class="col-xs-12 col-sm-6 col-md-6 col-lg-3">
										<label for="dataNascimento" class="">Data de Nasc.</label> <input
											type="text" class="form-control data" id="dataNascimento"
											data-toggle="tooltip" data-placement="top"
											title="Data de nascimento" name="pessoa.dataNascimento"
											placeholder="__/__/____" value="${pessoa.dataNascimento}" required/>

									</div>

									<div class="col-xs-12 col-sm-12 col-md-12 col-lg-6">
										<label for="cargo">Cargo</label> <select id="cargo"
											name="cargo.id" class="form-control" required>
											<c:forEach items="${listaCargo}" var="cargo">
												<option value="${cargo.id}">${cargo.nome}</option>
											</c:forEach>
										</select>
									</div>

									<div class="col-xs-12 col-sm-9 col-md-4 col-lg-4">
										<label for="rua" class="">Rua</label> <input type="text"
											class="form-control" id="rua" name="pessoa.rua"
											data-toggle="tooltip" data-placement="top"
											title="Digite o nome da rua"
											placeholder="Digite o nome da rua" value="${pessoa.rua}" required/>

									</div>
									<div class="col-xs-12 col-sm-3 col-md-2 col-lg-2">
										<label for="numero" class="">Número</label> <input
											type="number" class="form-control" id="numero"
											name="pessoa.numero" min="1" data-toggle="tooltip"
											data-placement="top" title="Digite o número da rua"
											placeholder="Digite o número da rua" value="${pessoa.numero}" required/>

									</div>
									<div class="col-xs-12 col-sm-6 col-md-3 col-lg-4">
										<label for="bairro" class="">Bairro</label> <input type="text"
											class="form-control" id="bairro" name="pessoa.bairro"
											data-toggle="tooltip" data-placement="top"
											title="Digite o nome do bairro"
											placeholder="Digite o nome do bairro"
											value="${pessoa.bairro}" required/>

									</div>
									<div class="col-xs-12 col-sm-6 col-md-3 col-lg-2">
										<label for="cep" class="">CEP</label> <input type="text"
											class="form-control cep" id="pessoa.cep" name="pessoa.cep"
											data-toggle="tooltip" data-placement="top"
											title="Digite o CEP da rua" placeholder="Ex: 00.000-000"
											value="${pessoa.cep}" required/>

									</div>
									<div class="col-xs-12 col-sm-6 col-md-3 col-lg-3">
										<label for="estado" class="">Estado</label> <select
											class="form-control estado" id="estado" data-toggle="tooltip"
											data-placement="top" title="Escolha um estado" name="pessoa.cidade.estado.id" required>
											<c:forEach items="${listaEstado}" var="estado">
												<option value="${estado.id}">${estado.nome}</option>
											</c:forEach>
										</select>

									</div>
									<div class="col-xs-12 col-sm-6 col-md-3 col-lg-3">
										<label for="cidade" class="">Cidade</label> <select
											class="form-control cidade" id="cidade"
											name="pessoa.cidade.id" data-toggle="tooltip"
											data-placement="top" title="Escolha uma cidade" required>
											<c:forEach items="${listaCidade}" var="cidade">
												<option value="${cidade.id}">${cidade.nome}</option>
											</c:forEach>
										</select>

									</div>
									<div class="col-xs-12 col-sm-12 col-md-6 col-lg-6">
										<label for="complemento" class="">Complemento</label> <input
											type="text" class="form-control" id="complemento"
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
										<label for="telefone1" class="">Telefone 1</label> <input
											type="text" type="text" class="form-control telefone"
											id="telefone1" name="pessoa.telefone1" data-toggle="tooltip"
											data-placement="top" title="Digite um telefone para contato"
											placeholder="(00) 0000-0000" value="${pessoa.telefone1}" />

									</div>
									<div class="col-xs-12 col-sm-6 col-md-3 col-lg-3">
										<label for="telefone2" class="">Telefone 2</label> <input
											type="text" class="form-control telefone" id="telefone2"
											name="pessoa.telefone2" data-toggle="tooltip"
											data-placement="top" title="Outro telefone qualquer"
											placeholder="(00) 0000-0000" value="${pessoa.telefone2}" />

									</div>
									<div class="col-xs-12 col-sm-6 col-md-3 col-lg-3">
										<label for="celular1" class="">Celular 1</label> <input
											type="text" class="form-control celular" id="celular1"
											name="pessoa.celular1" data-toggle="tooltip"
											data-placement="top" title="Digite um celular para contato"
											placeholder="(00) 0000-0000 ou (00) 00000-0000"
											value="${pessoa.celular1}" />

									</div>
									<div class="col-xs-12 col-sm-6 col-md-3 col-lg-3">
										<label for="celular2" class="">Celular 2</label> <input
											type="text" class="form-control celular" id="celular2"
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
					
					<div class="modal-footer">

						<button id="btnModalFormSalvarCargo" type="submit"
							class="btn btn-default">Salvar</button>
						<button id="btnModalFormLimparCargo" type="button"
							class="btn btn-default"
							onclick="empregador.modalLimparFormCadastrarEmpregador();">Limpar</button>
						<button id="btnModalFormCancelarCargo" type="button"
							class="btn btn-default"
							onclick="empregador.modalHideCadastroEmpregador();">Fechar</button>
		
					</div>
					
				</form>
			</div>

			
		</div>
	</div>
</div>