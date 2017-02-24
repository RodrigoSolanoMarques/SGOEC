<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags/componentes" prefix="componente"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="modal scroll" id="modalAvaliarCurriculo" tabindex="-1"
	role="dialog">
	<div class="modal-dialog modal-80" role="document">
		<div class="modal-content">
			<div class="modal-header">

				<button type="button" class="close" aria-label="Close"
					aria-label="Close" onclick="curriculo.modalHideAvaliarCurriculo();">
					<span aria-hidden="true">&times;</span>
				</button>
				<i class="write icon"></i> Avaliação de Currículo

			</div>
			<div class="modal-body">


				<div class="container-fluid">


					<div class="row">
						<div class="col-xs-12 col-sm-5 col-md-4 col-lg-3">

							<div class="panel panel-default">
								<div class="panel-heading text-center">Canditado(a)</div>
								<div class="panel-body">

									<div class="row">
										<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 ">

											<div class="ui centered card">
												<div class="image">
													<img id="modalAvaliarCurriculoFoto" src="/static/img/nan.jpg">
												</div>
												<div class="content">

													<img id="modalAvaliarCurriculoIsFavorito" class="right floated mini ui image" src="/static/img/star-empty.png"/>
													<div class="header"><label id="modalAvaliarCurriculoNome" name="curriculo.candidato.pessoa.nome">Nome do Candidato</label></div>
 													<div class="header"><label id="modalAvaliarCurriculoSobrenome" name="curriculo.candidato.pessoa.sobrenome">Nome do Candidato</label></div>
													<div class="meta"><label id="modalAvaliarCurriculoCidade" name="curriculo.candidato.pessoa.cidade.nome">Cidade</label><label>&nbsp-&nbsp</label><label id="modalPerfilEstado" name="curriculo.candidato.pessoa.cidade.estado.uf"> UF</label></div>
													<div class="meta"><label id="modalAvaliarCurriculoIdade">Idade</label>&nbsp<label>Anos</label></div>
													<div class="description"><label>Titulação:&nbsp</label><label id="modalAvaliarCurriculoTitulacao" name="curriculo.candidato.titulacao">Nome Titulação</label></div>
													
												</div>
												<div class="extra content">
													<div class="large ui two buttons">
														<div id="btnAprovar" class="ui toggle green button" onclick="curriculo.btnAprovar()">
															<i class="thumbs outline up icon"></i>Aprovado
														</div>
														<div id="btnDispensar" class="ui toggle red button" onclick="curriculo.btnDispensar()">
															<i class="thumbs outline down icon"></i>Dispensar
														</div>
													</div>
												</div>
											</div>

										</div>
									</div>

									<div class="row">
										<div
											class="col-xs-offset-1 col-xs-10 col-sm-offset-1 col-sm-10 col-md-offset-1 col-md-10 col-lg-offset-1 col-lg-10">
											
											<hr />
										</div>
										<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
											<button id="btnListaCandidatosFavoritos" class="large fluid ui toggle teal button" onclick="curriculo.btnListaCandidatosFavoritos()">
												<i class="add user icon"></i>Adicionar aos Favoritos
											</button>
										</div>
										<div
											class="col-xs-offset-1 col-xs-10 col-sm-offset-1 col-sm-10 col-md-offset-1 col-md-10 col-lg-offset-1 col-lg-10">
											 
											<hr />
										</div>
										<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
											<button id="btnListaEspera" class="large fluid ui toggle teal button" onclick="curriculo.btnListaEspera()">
												<i class="remove user icon"></i> Remover dos Favoritos
											</button>
										</div>
										<div
											class="col-xs-offset-1 col-xs-10 col-sm-offset-1 col-sm-10 col-md-offset-1 col-md-10 col-lg-offset-1 col-lg-10">
											
											<hr />
										</div>
										<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12" onclick="curriculo.btnSolicitarCurriculo()">
											<button id="btnSolicitarCurriculo" class="large fluid ui toggle teal button">
												<i class="send icon"></i> Solicitar Currículo
											</button>
										</div>

									</div>

								</div>
							</div>

						</div>
						<div class="col-xs-12 col-sm-7 col-md-8 col-lg-9">
							<div class="panel panel-default">
								<div class="panel-heading text-center">Currículo</div>
								<div class="panel-body text-center">Sem Currículo</div>
<!-- 								<iframe src="/empresa/curriculo/curriculoCanditadoPdf" width="600" height="780" style="border: none;"></iframe> -->
							</div>

						</div>
					</div>

				</div>
			</div>
			<div class="modal-footer text-right">
				<button id="btnModalFormSalvarCargo" type="button" class="btn btn-default" onclick="curriculo.modalHideAvaliarCurriculo()">Fechar</button>
			</div>
		</div>
	</div>
</div>

