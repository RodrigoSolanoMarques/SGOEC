<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SGOEC</title>
<link rel="stylesheet"
	href="<c:url value="/static/css/bootstrap.min.css"/>">
	<link rel="stylesheet"
	href="<c:url value="/static/css/font-awesome.min.css"/>">
</head>
<body>
<nav class="navbar navbar-default" role="navigation">
	<div class="container-fluid">
		<div class="navbar-header">
			<button class="navbar-toggle" type="button" data-toggle="collapse"
				data-target="#bs-example-navbar-collapse-1">
				<span class="sr-only">Toggle navigation</span>
			</button>
			<a class="navbar-brand" href="#"><i class="fa fa-sitemap"
				aria-hidden="true"></i> SGOEC</a>
		</div>

		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li class="active"><a href="#">Inicio</a></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">Oportunidade de Emprego <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="#">Cadastrar</a></li>
						<li class="divider"></li>
						<li><a href="#">Lista de Candidatos</a></li>
					</ul></li>
				<li>
				<li class="dropdown"><a class="dropdown-toggle" href="#"
					data-toggle="dropdown">Curriculo <b class="caret"></b></a>
					<ul class="dropdown-menu">
						<li><a href="#">Avaliar</a></li>
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
	<jsp:doBody/>
	<script type="text/javascript" src="/static/js/jquery-2.2.4.min.js"></script>
	<script type="text/javascript" src="/static/js/bootstrap.min.js"></script>
</body>
</html>