<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags/template/empresa" prefix="template"%>
<%@ taglib tagdir="/WEB-INF/tags/componentes" prefix="componente"%>

<div class="modal scroll" id="modalAvaliarCurriculo" tabindex="-1"
	role="dialog">
	<div class="modal-dialog modal-80">
		<div class="modal-content">
			<div class="modal-header">

				<button type="button" class="close" aria-label="Close"
					
					aria-label="Close" onclick="candidatos.modalHideAvaliarCurriculo();">
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
													<img src="/static/img/nan.jpg">
												</div>
												<div class="content">

													<img class="right floated mini ui image"
														src="/static/img/star-full.png">
													<div class="header"><label id="modalPerfilNome" name="candidatopessoa.nome">Nome do Candidato</label></div>
<!-- 													<div class="meta"><label name="idade">X Anos</label></div> -->
													<div class="meta"><label id="modalPerfilCidade" name="candidato.pessoa.cidade.nome">Cidade -</label><label id="modalPerfilEstado" name="candidato.pessoa.cidade.estado.nome"> UF</label></div>
													<div class="description"><label id="modalPerfilTitulacao" name="titulacao">Titulação</label></div>
												</div>
												<div class="extra content">
													<div class="large ui two buttons">
														<div class="ui toggle green button">
															<i class="thumbs outline up icon"></i>Aprovado
														</div>
														<div class="ui toggle red button">
															<i class="thumbs outline down icon"></i>Reprovado
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
											<button class="large fluid ui toggle teal button">
												<i class="add user icon"></i> Lista de Candidatos Favoritos
											</button>
										</div>
										<div
											class="col-xs-offset-1 col-xs-10 col-sm-offset-1 col-sm-10 col-md-offset-1 col-md-10 col-lg-offset-1 col-lg-10">
											 
											<hr />
										</div>
										<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
											<button class="large fluid ui toggle teal button">
												<i class="remove user icon"></i> Lista de Candidatos
												Favoritos
											</button>
										</div>
										<div
											class="col-xs-offset-1 col-xs-10 col-sm-offset-1 col-sm-10 col-md-offset-1 col-md-10 col-lg-offset-1 col-lg-10">
											
											<hr />
										</div>
										<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
											<button class="large fluid ui toggle teal button">
												<i class="send icon"></i> Pedir Currículo
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
							</div>

						</div>
					</div>

				</div>
			</div>
			<div class="modal-footer text-right">
				<button id="btnModalFormSalvarCargo" type="button" class="btn btn-default" onclick="candidatos.modalHideAvaliarCurriculo()">Cancelar</button>
			</div>
		</div>
	</div>
</div>
