<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags/componentes" prefix="componente"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Inicio do Form Conta -->
<form id="modalFormCadastrarContaUsuario" class="form-horizontal"
	 enctype="multipart/form-data">
	<div class="form-group">
		<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">

			<!-- Inicio Informações da conta -->
			<div class="form-group">
				<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
					<div class="panel panel-default">
						<div class="panel-heading text-center">
							<h4>Informações da Conta</h4>
						</div>
						<div class="panel-body">
						
						<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
						
						<div id="divAlertSuccess" class="alert alert-success alert-dismissible" role="alert">
						  <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
						  <strong>Sucesso! </strong><span id="divAlertSuccessSpan"></span>
						</div>
						
						<div id="divAlertDanger" class="alert alert-danger alert-dismissible" role="alert">
						  <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
						  <strong>Falhou! </strong><span id="divAlertDangerSpan"></span>
						</div>
						
						
						</div>

							<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
								<div class="form-group">

									<div class="col-xs-12 col-sm-3 col-md-2 col-lg-2 ">
										<div class="form-group">

											<div
												class="col-xs-offset-3 col-xs-6 col-sm-offset-0 col-sm-12 col-md-offset-0 col-md-12  col-lg-offset-0 col-lg-12 ">
												<div class="form-group">
												
												<div class="panel panel-default" style="margin-bottom: 6px">
													<div class="panel-body">
														<img id="imagem" name="imagem" class="img-thumbnail" src="/static/img/nan.jpg">
													</div>
												</div>
												<input type="file" id="foto" name="foto" style="display:  none">
												<button id="btnFoto" type="button" class="btn btn-default btn-block">Adicionar</button>
												<label id="nomeFoto" class=""></label>
												</div>
											</div>

										</div>

									</div>

									<div class="col-xs-12 col-sm-9 col-md-10 col-lg-10">
										<label for="username" class="">Nome de Usuário</label> <input
											type="text" class="hidden" id="id" name="id"  /> <input
											type="text" class="form-control" id="username"
											name="username" data-toggle="tooltip" data-placement="top"
											title="Nome de usuário" placeholder="Nome de Usuário"
											value="${contaUsuario.username}" required  />

									</div>
									<div class="col-xs-12 col-sm-9 col-md-10 col-lg-10">
										<label for="email" class="">E-mail</label> <input type="email"
											class="form-control" id="email" name="email"
											data-toggle="tooltip" data-placement="top"
											title="E-mail da conta" placeholder="Digite um E-mail"
											value="${contaUsuario.email}" required  />

									</div>
									<div id="divTrocarSenha" class="col-xs-12 col-sm-9 col-md-10 col-lg-10">
										<input id="trocarSenha" type="checkbox"><label for="trocarSenha" class="">Trocar Senha</label> 
									</div>
									
									<div id="divSenhas">
									<div class="col-xs-12 col-sm-4 col-md-5 col-lg-5">
										<label for="senha" class="">Senha</label> <input
											type="password" class="form-control" id="senha" name="senha"
											data-toggle="tooltip" data-placement="top"
											title="Senha do usuário" placeholder="Senha do usuário"
											required  />

									</div>
									<div class="col-xs-0 col-sm-1 col-md-0 col-lg-0"></div>
									<div class="col-xs-12 col-sm-4 col-md-5 col-lg-5">
										<label for="compararSenha" class="">Digite Novamente a
											Senha</label> <input type="password" class="form-control"
											id="compararSenha" name="compararSenha" data-toggle="tooltip"
											data-placement="top" title="Digite novamente a senha"
											placeholder="Digite novamente a senha" required  />

									</div>

									</div>
									
<!-- 									<div class="col-xs-12 col-sm-9 col-md-5 col-lg-5"> -->
<!-- 										<label for="permissoes">Permissão</label> <select id="permissoes" -->
<!-- 											name="permissoes" class="form-control" required> -->
<%-- 											<c:forEach items="${listaPermissao}" var="permissao"> --%>
<%-- 												<option value="${permissao.id}">${permissao.permissao}</option> --%>
<%-- 											</c:forEach> --%>
<!-- 										</select> -->
<!-- 									</div> -->

								</div>
								<hr>
								<!-- Inicio Botões -->
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
								<!-- Final Botões -->
							</div>

						</div>
						<!-- Final Panel Body -->

					</div>
				</div>
			</div>
			<!-- Final Informações da conta -->


		</div>
	</div>

</form>
<!-- Final do Form Conta -->