<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags/template/empresa" prefix="template"%>
<%@ taglib tagdir="/WEB-INF/tags/componentes" prefix="componente"%>
<template:admin>
	<jsp:attribute name="cssEspecificos">
	<link href="/static/css/bootstrap-table/fresh-bootstrap-table.css"
			rel="stylesheet" />	
	<link href="/static/css/bootstrap-table/bootstrap.css" rel="stylesheet" />	
		<link href="/static/css/bootstrap-table/bootstrap-table.min.css"
			rel="stylesheet" />
		
				
		<link
			href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css"
			rel="stylesheet">
		<link href='http://fonts.googleapis.com/css?family=Roboto:400,700,300'
			rel='stylesheet' type='text/css'>
 	</jsp:attribute>

	<jsp:attribute name="scriptsEspecificos">
      <script type="text/javascript"
			src="/static/js/bootstrap-table/jquery-1.11.2.min.js"></script>
		<script type="text/javascript"
			src="/static/js/bootstrap-table/bootstrap-table.min.js"></script>
		<script type="text/javascript"
			src="/static/js/bootstrap-table/bootstrap-table-mobile.min.js"></script>
		
		<script type="text/javascript"
			src="/static/js/sgoec/oportunidade-emprego/listar-candidato.js"></script>
		<script type="text/javascript">
			
		</script>
    </jsp:attribute>

	<jsp:body>
	<div class="container-fluid">
		
		<componente:titulo-pagina>
			<i class="table icon"></i> Currículos
		</componente:titulo-pagina>
		
		<componente:panel-padrao-sgoec>
			<div class="row">
				<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
					<div class="fresh-table toolbar-color-orange" data-toggle="table">
<!-- 	   			        <div class="toolbar"> -->
<!-- 				            <button id="alertBtn" class="btn btn-default">Alert</button> -->
<!-- 				        </div> -->
	
				        <table id="fresh-table" class="table"
								data-mobile-responsive="true">
				            <thead>
				            <tr>
				                <th data-field="id">ID</th>
				            	<th data-field="name">Name</th>
				            	<th data-field="salary">Salary</th>
				            	<th data-field="country">Country</th>
				            	<th data-field="city">City</th>
				            </tr>
				            </thead>
				            <tbody>
				                <tr>
				                	<td>1</td>
				                	<td>Dakota Rice</td>
				                	<td>$36,738</td>
				                	<td>Niger</td>
				                	<td>Oud-Turnhout</td>
				                </tr>
				                
								
				                <tr>
				                	<td>1</td>
				                	<td>Dakota Rice</td>
				                	<td>$36,738</td>
				                	<td>Niger</td>
				                	<td>Oud-Turnhout</td>
				                </tr>
				                
				                <tr>
				                	<td>1</td>
				                	<td>Dakota Rice</td>
				                	<td>$36,738</td>
				                	<td>Niger</td>
				                	<td>Oud-Turnhout</td>
				                </tr>
			                </tbody>
				        </table>
	    			</div>
				</div>
			</div>
		</componente:panel-padrao-sgoec>
	</div>
	</jsp:body>
</template:admin>