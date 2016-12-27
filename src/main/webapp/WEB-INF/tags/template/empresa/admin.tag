<%@ tag pageEncoding="UTF-8"%>

<%@ attribute name="cssEspecificos" fragment="true" required="false"%>
<%@ attribute name="scriptsEspecificos" fragment="true" required="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>SGOEC</title>
<link rel="stylesheet"
	href="<c:url value="/static/css/bootstrap/bootstrap.min.css"/>">
	<link rel="stylesheet"
	href="<c:url value="/static/css/semantic/semantic.min.css"/>">
	<link rel="stylesheet"
	href="<c:url value="/static/css/font-awesome/font-awesome.min.css"/>">
	<link rel="stylesheet"
	href="<c:url value="/static/css/jquery-loading-modal/jquery-loading-modal.min.css"/>">
	<link rel="stylesheet"
	href="<c:url value="/static/css/bootstrap-datetimepicker/bootstrap-datetimepicker.min.css"/>">

	<jsp:invoke fragment="cssEspecificos"></jsp:invoke>
</head>
<body>
	<header>
		<nav class="navbar navbar-default" role="navigation">
			<div class="container-fluid">
				<!-- Brand and toggle get grouped for better mobile display -->
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
						aria-expanded="false">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="/empresa/index"><i
						class="fa fa-sitemap" aria-hidden="true"></i> SGOEC</a>
				</div>

				<div class="collapse navbar-collapse"
					id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav">
						<li class=""><a href="/empresa/index">Inicio</a></li>
						
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown" role="button" aria-haspopup="true"
							aria-expanded="false">Cadastros Básicos<span
								class="caret"></span></a>
							<ul class="dropdown-menu">
								<li><a href="/empresa/cargo/">Cargo</a></li>
								<li><a href="/cidade/">Cidade</a></li>
								<li><a href="/empresa/empregador/">Empregador</a></li>
								<li><a href="/empresa/">Empresa</a></li>
								<li><a href="/estado/">Estado</a></li>
							</ul></li>
						
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown" role="button" aria-haspopup="true"
							aria-expanded="false">Oportunidade de Emprego <span
								class="caret"></span></a>
							<ul class="dropdown-menu">
								<li><a href="/empresa/oportundadeemprego/cadastrar">Cadastrar</a></li>
								<li><a href="/empresa/oportundadeemprego/">Listar</a></li>
							</ul></li>
							
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown" role="button" aria-haspopup="true"
							aria-expanded="false">Candidato <span
								class="caret"></span></a>
							<ul class="dropdown-menu">
								<li><a href="/empresa/candidato/favoritos">Favoritos</a></li>
								<li><a
									href="/empresa/candidato/listar">Listar</a></li>
							</ul></li>
						
						<li class="dropdown"><a class="dropdown-toggle" href="#"
							data-toggle="dropdown">Curriculo <b class="caret"></b></a>
							<ul class="dropdown-menu">
								<li><a href="/empresa/curriculo/avaliar">Avaliar</a></li>
								<li><a href="/empresa/curriculo/recentes">Recentes</a></li>
								<li><a href="/empresa/curriculo/listar">Listar</a></li>
							</ul></li>
						<li><a href="#">Sobre</a></li>
					</ul>
					<a class="btn btn-default navbar-btn navbar-right" type="button"
						href="entrar">Sair</a>
				</div>
				<!-- /.navbar-collapse -->
			</div>
			<!-- /.container -->
		</nav>
	</header>

	<!-- Conteúdo da Página -->
	<jsp:doBody />
	

	<footer class="footer">
		<hr />
		<div class="container">
			<div class="row">
				<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
					<div class="footer-logo pull-left">
						<button class="ui circular facebook icon button">
							<i class="facebook icon"></i>
						</button>
						<button class="ui circular twitter icon button">
							<i class="twitter icon"></i>
						</button>
						<button class="ui circular linkedin icon button">
							<i class="linkedin icon"></i>
						</button>
						<button class="ui circular google plus icon button">
							<i class="google plus icon"></i>
						</button>
					</div>

					<div class="footer-text pull-right">
						<i class="fa fa-sitemap" aria-hidden="true"></i> <span
							class="text-footer-div">|</span> <span class="text-footer">&copy;
							2016 Rodrigo Solano Marques</span>
					</div>
				</div>
			</div>
		</div>
	</footer>

	<script type="text/javascript" src="/static/js/jquery/jquery-2.2.4.min.js"></script>
	<script type="text/javascript" src="/static/js/bootstrap/bootstrap.min.js"></script>
	<script type="text/javascript" src="/static/js/semantic/semantic.min.js"></script>
	<script type="text/javascript" src="/static/js/jquery-loading-modal/jquery-loading-modal.min.js"></script>
	<script type="text/javascript" src="/static/js/moment/moment.js"></script>
	<script type="text/javascript" src="/static/js/bootstrap-datetimepicker/bootstrap-datetimepicker.min.js"></script>
	
	<jsp:invoke fragment="scriptsEspecificos"></jsp:invoke>
</body>
</html>