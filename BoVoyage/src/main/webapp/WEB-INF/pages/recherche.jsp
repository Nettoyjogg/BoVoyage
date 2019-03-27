<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!-- ajout de la librairie de spring mvd pour l'ajout des formulaires -->
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!-- inclure la librairie jstl core -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>recherche</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/bootstrap.css" />
</head>
<body>
	<form:form method="POST" action="soumettreRec" commandName="eRec"
		cssClass="form-horizontal">
		<div class="form-group">
			<label for="idID" class="col-sm-2 control-label">ID</label>
			<div class="col-sm-3">
				<form:input cssClass="form-control" id="idID"
					placeholder="Identifiant" path="id" />
			</div>
		</div>

		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-default">Rechercher</button>
			</div>
		</div>
	</form:form>

	<table class="table table-striped">
		<tr>
			<th>ID</th>
			<th>Nom</th>
			<th>Prenom</th>
			<th>Date de naissance</th>
		</tr>
		
			<tr>
				<td>${etu.id}</td>
				<td>${etu.nom}</td>
				<td>${etu.prenom}</td>
				<td>${etu.dn}</td>
			</tr>
		
	</table>

</body>
</html>