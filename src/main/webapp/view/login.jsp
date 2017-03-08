<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Entrar</title>
</head>
<body>
	<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->
	<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->
	<!--[if !IE]><!-->
<html lang="pt-br">
<!--<![endif]-->

<!-- BEGIN HEAD -->
<head>
<meta charset="UTF-8" />
<title>BCORE Admin Dashboard Template | Login Page</title>
<meta content="width=device-width, initial-scale=1.0" name="viewport" />
<meta content="" name="description" />
<meta content="" name="author" />
<!--[if IE]>
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <![endif]-->
<!-- GLOBAL STYLES -->
<!-- PAGE LEVEL STYLES -->
<link rel="stylesheet" href="/static/css/bootstrap/bootstrap.min.css" />
<link rel="stylesheet" href="/static/css/login.css" />
<link rel="stylesheet" href="/static/plugins/magic/magic.css" />
<link rel="stylesheet"	href="<c:url value="/static/css/jquery-loading-modal/jquery-loading-modal.min.css"/>">
<link rel="stylesheet"	href="<c:url value="/static/css/bootstrap-datetimepicker/bootstrap-datetimepicker.min.css"/>">
<link href="/static/css/sgoec/style.css" rel='stylesheet' type='text/css'>

<!-- END PAGE LEVEL STYLES -->
<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
</head>
<!-- END HEAD -->

<!-- BEGIN BODY -->
<body>

	<!-- PAGE CONTENT -->
	<div class="container">
		<div class="text-center">
<!-- 			        <img src="assets/img/logo.png" id="logoimg" alt=" Logo" /> -->
			<h1>SGOEC</h1>
		</div>
		<div class="tab-content">
			<div id="login" class="tab-pane active">
				<form name="f" action="/login" method="post" class="form-signin">
					<p class="text-muted text-center btn-block btn btn-primary btn-rect">Informe os dados abaixo</p>
					<input type="text" placeholder="Nome de Usuário"
						class="form-control" name="username"/> 
					<input type="password"
						placeholder="Senha" class="form-control" name="password"/>
						
						
							<div id="divAlertSuccess" class="alert alert-success alert-dismissible" role="alert">
							  <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
							  <span id="divAlertSuccessText"/>
							</div>
							
						
					<button class="btn text-muted text-center btn-success  btn-block" type="submit">Entrar
					</button>
				</form>
				<div class="text-center">
					<ul class="list-inline">				
						<li><a class="text-muted" href="#signup" data-toggle="tab">Inscrever-se</a></li>
					</ul>
				</div>
			</div>

			<div id="signup" class="tab-pane">
				
				<form id="formRegistrarContaUsuario" class="form-horizontal">
					<div class="form-group">
					
						<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
							<div class="panel panel-default">
								<div class="panel-heading text-center">
								<h4>Informações da Empresa</h4>
							</div>
							<div class="panel-body">
								<div class="col-xs-12 col-sm-6 col-md-6 col-lg-6">
									<label for="razaoSocial" class="">Razão Social</label> 
									<input type="text" class="form-control" id="razaoSocial"
											name="razaoSocial" data-toggle="tooltip" data-placement="top"
											title="Razão Social" placeholder="Razão Social"
											value="${razaoSocial}" required />
								
								</div>
								<div class="col-xs-12 col-sm-6 col-md-6 col-lg-6">
									<label for="nomeFantasia" class="">Nome Fantasia</label> 
									<input type="text" class="form-control" id="nomeFantasia"
											name="nomeFantasia" data-toggle="tooltip"
											data-placement="top" title="Nome Fantasia"
											placeholder="Nome Fantasia" value="${nomeFantasia}" required/>
								
								</div>
								<div class="col-xs-12 col-sm-12 col-md-6 col-lg-6">
									<label for="cpfCnpj" class="">Tipo da Pessoa</label>
									<div class="input-group">
								      <span class="input-group-addon">
								      <label for="cpf" class="">CPF</label>
								        <input id="cpf" type="radio" name="isPessoaJuridica"
												value="true" onclick="loginRegistro.validaCpfCnpj()" required>
								      </span>
								      <span class="input-group-addon">
								      <label for="cnpj" class="">CNPJ</label>
								        <input id="cnpj" type="radio" name="isPessoaJuridica"
												value="false" onclick="loginRegistro.validaCpfCnpj()" required >
								      </span>
								      <input id="cpfCnpj" name="cpfCnpj" type="text"
												class="form-control" required>
								    </div>
								
								</div>
								
								<div class="col-xs-12 col-sm-12 col-md-6 col-lg-6">
									<label for="estado" class="">Estado</label> 
									<select class="form-control estado" id="estado"
											name="cidade.estado.id" data-toggle="tooltip" data-placement="top"
											title="Escolha um estado" required>
								        <c:forEach items="${listaEstado}" var="estado"> 
								            <option value="${estado.id}">${estado.nome}</option>
								        </c:forEach>
								    </select>
								
								</div>
								<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
									<label for="cidade" class="">Cidade</label> 
									<select class="form-control cidade" id="cidade"
											name="cidade.id" data-toggle="tooltip" data-placement="top"
											title="Escolha uma cidade" required>
								        <c:forEach items="${listaCidade}" var="cidade"> 
								            <option value="${cidade.id}">${cidade.nome}</option>
								        </c:forEach>
								    </select>
								
								</div>
							</div>
							</div>
						</div>
						
						<div class="form-group">
						<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">

							<!-- Inicio Informações Básicas -->
							<div class="panel panel-default">
								<div class="panel-heading text-center">
									<h4>Informações do Usuário</h4>
								</div>
								<div class="panel-body">
									<div class="col-xs-12 col-sm-6 col-md-6 col-lg-6">
										<label for="nome" class="">Nome</label> 
										<input type="text"
											class="form-control" id="nome" name="nome"
											data-toggle="tooltip" data-placement="top"
											title="Nome do empregador" placeholder="Nome do Empregador"
											value="${pessoa.nome}" required/>

									</div>

									<div class="col-xs-12 col-sm-6 col-md-6 col-lg-6">
										<label for="sobrenome" class="">Sobrenome</label> <input
											type="text" class="form-control" id="sobrenome"
											name="sobrenome" data-toggle="tooltip"
											data-placement="top" title="Sobrenome do empregador"
											placeholder="Sobrenome do Empregador"
											value="${pessoa.sobrenome}" required/>

									</div>
								</div>
							</div>
							<!-- Final Informações Básicas -->
						</div>
					</div>
						
						<div class="form-group">
							<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
								<div class="panel panel-default">
									<div class="panel-heading text-center">
									<h4>Informações da Conta</h4>
								</div>
								<div class="panel-body">
		
									<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
										<label for="username" class="">Nome de Usuário</label> <input
											type="text" class="form-control" id="username"
											name="username" data-toggle="tooltip" data-placement="top"
											title="Nome de usuário" placeholder="Nome de Usuário"
											value="${contaUsuario.username}" required  />
		
									</div>
									<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
										<label for="email" class="">E-mail</label> <input type="email"
											class="form-control" id="email" name="email"
											data-toggle="tooltip" data-placement="top"
											title="E-mail da conta" placeholder="Digite um E-mail"
											value="${contaUsuario.email}" required  />
		
									</div>
									<div id="divSenhas">
										<div class="col-xs-12 col-sm-5 col-md-6 col-lg-6">
											<label for="senha" class="">Senha</label> <input
												type="password" class="form-control" id="senha" name="senha"
												data-toggle="tooltip" data-placement="top"
												title="Senha do usuário" placeholder="Senha do usuário"
												required  />
		
										</div>
										<div class="col-xs-0 col-sm-2 col-md-0 col-lg-0"></div>
										<div class="col-xs-12 col-sm-5 col-md-6 col-lg-6">
											<label for="compararSenha" class="">Digite Novamente a
												Senha</label> <input type="password" class="form-control"
												id="compararSenha" name="compararSenha" data-toggle="tooltip"
												data-placement="top" title="Digite novamente a senha"
												placeholder="Digite novamente a senha" required  />
		
										</div>
									</div>
		
								</div>								
							</div>
						</div>
					</div>		
					<div class="form-group">
						<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
							
							
							<div id="divAlertDanger" class="alert alert-danger alert-dismissible" role="alert">
							  <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
							  <span id="divAlertDangerText" />
							</div>
						</div>
					</div>

					<button class="btn text-muted text-center btn-success btn-block"
						type="submit">Registrar</button>
				</form>				
				<div class="text-center hidden">
					<ul class="list-inline">				
						<li><a id="entrar" class="text-muted" href="#login" data-toggle="tab">Inscrever-se</a></li>
					</ul>
				</div>			
			</div>
		</div>
	</div>

	<!--END PAGE CONTENT -->

	<!-- PAGE LEVEL SCRIPTS -->
	<script type="text/javascript" src="/static/js/jquery/jquery-2.2.4.min.js"></script>
	<script type="text/javascript" src="/static/js/bootstrap/bootstrap.min.js"></script>
	<script type="text/javascript" src="/static/js/login.js"></script>
	<script type="text/javascript" src="/static/js/ajax.js"></script>
	<script type="text/javascript" src="/static/js/moment/moment.js"></script>
	<script type="text/javascript" src="/static/js/bootstrap-datetimepicker/bootstrap-datetimepicker.min.js"></script>
	<script type="text/javascript" src="/static/js/jquery-mask/jquery.mask.min.js"></script>
	<script type="text/javascript" src="/static/js/sgoec/funcoes.js"></script>
	<!--END PAGE LEVEL SCRIPTS -->

</body>
<!-- END BODY -->
</html>
