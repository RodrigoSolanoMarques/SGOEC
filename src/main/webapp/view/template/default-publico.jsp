<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SGOEC</title>
<link rel="stylesheet"
	href="<c:url value="/static/css/bootstrap.min.css"/>">
<link rel="stylesheet"
	href="<c:url value="/static/css/bootstrap.min.css.map"/>">
</head>
<body>
<!-- HEADER -->
	<div class="container-fluid">
	<div class="row">
	<jsp:include page="/view/template/navbar.jsp"/>
	</div>
		<div class="row">
			<div class="col-md-12">
				<div class="panel panel-primary">
					<div class="panel-heading">
						<h3>Perfil</h3>
					</div>
					<div class="panel-body">
						<div class="row">
							<div class="col-md-9">
								<div class="row">
									<div class="col-md-4">
										<div class="form-group">
											<label>CPF</label> <input type="text" placeholder="CPF"
												class="form-control">
										</div>
									</div>
									<div class="col-md-4">
										<div class="form-group">
											<label>Nome</label> <input type="text" placeholder="Nome"
												class="form-control">
										</div>

									</div>
									<div class="col-md-4">
										<div class="form-group">
											<label>Sobrenome</label> <input type="text" placeholder="Sobrenome"
												class="form-control">
										</div>
									</div>
								</div>
								<!-- Final Primeira Linha: CPF -->
								<h3>Endereço</h3>
								<hr>
								<div class="row">
									<div class="col-md-4">
										<div class="form-group">
											<label>Rua</label> <input type="text" placeholder="Rua"
												class="form-control">
										</div>
									</div>
									<div class="col-md-4">
										<div class="form-group">
											<label>Número</label> <input type="text" placeholder="Número"
												class="form-control">
										</div>
									</div>
									<div class="col-md-4">
										<div class="form-group">
											<label>Bairro</label> <input type="text" placeholder="Bairro"
												class="form-control">
										</div>
									</div>
								</div>
								<!-- Final da segunda linha: Endereço -->
								<div class="row">
									<div class="col-md-4">
										<div class="form-group">
											<label>CEP</label> <input type="text" placeholder="CEP"
												class="form-control">
										</div>
									</div>
									<div class="col-md-4">
										<div class="form-group">
											<label>Cidade</label> <input type="text" placeholder="Cidade"
												class="form-control">
										</div>
									</div>
									<div class="col-md-4">
										<div class="form-group">
											<label>Complemento</label> <input type="text"
												placeholder="Complemento" class="form-control">
										</div>
									</div>
								</div>
								<!-- Final da segunda linha: Complemento -->
								<h3>Contato</h3>
								<hr>
								<div class="row">

									<div class="col-md-12">
										<div class="form-group">
											<label>E-Mail</label> <input type="email" placeholder="E-Mail"
												class="form-control">
										</div>
									</div>

									<div class="col-md-3">
										<div class="form-group">
											<label>Telefone 1</label> <input type="text"
												placeholder="Telefone 1" class="form-control">
										</div>
									</div>
									<div class="col-md-3">
										<div class="form-group">
											<label>Telefone 2</label> <input type="text"
												placeholder="Telefone 2" class="form-control">
										</div>
									</div>
									<div class="col-md-3">
										<div class="form-group">
											<label>Celular 1</label> <input type="text" placeholder="Celular 1"
												class="form-control">
										</div>
									</div>
									<div class="col-md-3">
										<div class="form-group">
											<label>Celular 2</label> <input type="text" placeholder="Celular 2"
												class="form-control">
										</div>
									</div>
								</div>
								<!-- Final da segunda linha: Telefone -->
							</div>
							<!-- Final col-md-8 -->
							<div class="col-md-3">
								<div class="panel panel-primary">
									<div class="panel-heading">Foto</div>
									<div class="panel-body">
										<div class="thumbnail">
											<img src="" alt="Foto" class="img-responsive text-center">
											<div class="caption">
												<h5>Nome do Colaborador</h5>
												<p>
													<a href="#" class="btn btn-primary" role="button">Alterar</a>
													<a href="#" class="btn btn-default" role="button">Excluir</a>
												</p>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>

		</div>
	</div>

</body>
</html>