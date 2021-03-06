<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SGOEC</title>
<link rel="stylesheet"
	href="<c:url value="/static/css/bootstrap.min.css"/>">
<link rel="stylesheet"
	href="<c:url value="/static/css/bootstrap.min.css.map"/>">
	<link rel="stylesheet"
	href="<c:url value="/static/css/font-awesome.min.css"/>">
</head>
<body>
	<header>
		<jsp:include page="../usuario/navbar.jsp" />
	</header>
	<div class="container-fluid">
		<div class="row">
			<div class="offset-xs-4 col-xs-4 offset-sm-4 col-sm-4 offset-md-4 col-md-4 offset-lg-4 col-lg-4">
				<h2 class="text-xs-center text-sm-center text-md-center">
					<i class="fa fa-sitemap" aria-hidden="true"></i>
					SGOEC
				</h2>
				<hr />
			</div>
		</div>
		
		<div class="row">
			<div class="col-xs-12 col-sm-12 col-md-12">
				<div class="card card-inverse">
					<div class="card-header text-xs-center text-sm-center text-md-center text-lg-center" style="background-color: #007E80">
						SGOEC - Sistema de Gerenciamento de Oportunidade de Emprego e Curriculo
					</div>
					<div class="card-block">
						Corpo
					</div>
				</div>
			</div>
		</div>
	</div>
	<footer>
		<jsp:include page="../usuario/footer.jsp" />
	</footer>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.0.0/jquery.min.js" integrity="sha384-THPy051/pYDQGanwU6poAc/hOdQxjnOEXzbT+OuUAFqNqFjL+4IGLBgCJC3ZOShY" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.2.0/js/tether.min.js" integrity="sha384-Plbmg8JY28KFelvJVai01l8WyZzrYWG825m+cZ0eDDS1f7d/js6ikvy1+X+guPIB" crossorigin="anonymous"></script>
	<script type="text/javascript" src="/static/js/bootstrap.min.js"></script>
</body>
</html>