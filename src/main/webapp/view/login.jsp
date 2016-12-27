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
			<!--         <img src="assets/img/logo.png" id="logoimg" alt=" Logo" /> -->
			<h1>SGOEC</h1>
		</div>
		<div class="tab-content">
			<div id="login" class="tab-pane active">
				<form action="#" class="form-signin">
					<p
						class="text-muted text-center btn-block btn btn-primary btn-rect">
						Informe os dados abaixo</p>
					<input type="text" placeholder="E-mail/Nome de Usuário"
						class="form-control" name="username"/> 
					<input type="password"
						placeholder="Senha" class="form-control" name="password"/>
					<button class="btn text-muted text-center btn-danger" type="submit">Entrar
					</button>
				</form>
			</div>
			<div id="forgot" class="tab-pane">
				<form action="/empresa/index" class="form-signin">
					<p
						class="text-muted text-center btn-block btn btn-primary btn-rect">Digite
						seu E-mail</p>
					<input type="email" required="required" placeholder="Seu E-mail"
						class="form-control" /> <br />
					<button class="btn text-muted text-center btn-success"
						type="submit">Recuperar Senha</button>
				</form>
			</div>
			<div id="signup" class="tab-pane">
				<form action="#" class="form-signin">
					<p
						class="text-muted text-center btn-block btn btn-primary btn-rect">Preencha os detalhes para se registrar</p>
					<input type="text" placeholder="Primeiro Nome" class="form-control" />
					<input type="text" placeholder="Ultimo Nome" class="form-control" />
					<input type="text" placeholder="Nome de Usuário" class="form-control" />
					<input type="email" placeholder="E-mail" class="form-control" />
					<input type="password" placeholder="Senha" class="form-control" />
					<input type="password" placeholder="Digite novamente a senha"
						class="form-control" />
					<button class="btn text-muted text-center btn-success"
						type="submit">Registrar</button>
				</form>
			</div>
		</div>
		<div class="text-center">
			<ul class="list-inline">
				<li><a class="text-muted" href="#login" data-toggle="tab">Entrar</a></li>
				<li><a class="text-muted" href="#forgot" data-toggle="tab">Esqueceu a
						Senha</a></li>
				<li><a class="text-muted" href="#signup" data-toggle="tab">Inscrever-se</a></li>
			</ul>
		</div>


	</div>

	<!--END PAGE CONTENT -->

	<!-- PAGE LEVEL SCRIPTS -->
	<script src="/static/js/jquery/jquery-2.2.4.min.js"></script>
	<script src="/static/js/bootstrap/bootstrap.min.js"></script>
	<script src="/static/js/login.js"></script>
	<!--END PAGE LEVEL SCRIPTS -->

</body>
<!-- END BODY -->
</html>
