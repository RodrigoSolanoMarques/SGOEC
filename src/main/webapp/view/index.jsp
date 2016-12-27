<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="<c:url value="/static/css/bootstrap.min.css"/>">
<title>SGOEC</title>
</head>
<body>
	<header>
		<jsp:include page="/view/template/navbar.jsp" />
	</header>
	<div class="container-influid">
		<div class="row"></div>
		<div class="row"></div>
		<div class="row"></div>
	</div>
	<footer>
		<jsp:include page="/view/template/footer.jsp"></jsp:include>
	</footer>
</body>
</html>