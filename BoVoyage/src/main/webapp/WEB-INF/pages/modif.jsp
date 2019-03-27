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
<title>modif</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/bootstrap.css" />
</head>
<body>

	<form:form method="POST" action="soumettreModif" commandName="eModif"
		cssClass="form-horizontal">
		<div class="form-group">
			<label for="idID" class="col-sm-2 control-label">ID</label>
			<div class="col-sm-3">
				<form:input cssClass="form-control" id="idID" placeholder="Identifiant"
					path="id" />
			</div>
		</div>

		<div class="form-group">
			<label for="idNom" class="col-sm-2 control-label">Nom</label>
			<div class="col-sm-3">
				<form:input cssClass="form-control" id="idNom" placeholder="Nom"
					path="nom" />
			</div>
		</div>

		<div class="form-group">
			<label for="idPrenom" class="col-sm-2 control-label">Prenom</label>
			<div class="col-sm-3">
				<form:input cssClass="form-control" id="idPrenom"
					placeholder="Prenom" path="prenom" />
			</div>
		</div>

		<div class="form-group">
			<label for="idDn" class="col-sm-2 control-label">Date de
				naissance</label>
			<div class="col-sm-3">
				<form:input type="date" cssClass="form-control" id="idDn"
					placeholder="Date" path="dn" />
			</div>
		</div>

		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-default">Modifier</button>
			</div>
		</div>
	</form:form>

</body>
</html>