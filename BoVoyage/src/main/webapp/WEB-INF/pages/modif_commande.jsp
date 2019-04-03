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
<title>Modifier une commande</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/bootstrap.css" />
</head>
<body>

	<form:form method="POST" action="soumettreModifier" commandName="comModif"
		cssClass="form-horizontal">
		<div class="form-group">
			<label for="idID" class="col-sm-2 control-label">ID</label>
			<div class="col-sm-3">
				<form:input cssClass="form-control" id="idID" placeholder="Identifiant"
					path="idCommande" />
			</div>
		</div>

		<div class="form-group">
			<label for="idNum" class="col-sm-2 control-label">Numéro de la commande</label>
			<div class="col-sm-3">
				<form:input cssClass="form-control" id="idNum" placeholder="Num"
					path="numeroCommande" />
			</div>
		</div>

		<div class="form-group">
			<label for="idEtat" class="col-sm-2 control-label">Etat de la commande</label>
			<div class="col-sm-3">
				<form:input cssClass="form-control" id="idEtat" placeholder="Etat" 
					path="Etat" />
			</div>
		</div>

		<div class="form-group">
			<label for="idAssurance" class="col-sm-2 control-label">Assurance</label>
			<div class="col-sm-3">
				<form:input cssClass="form-control" id="idAssurance" placeholder="Assurance"
					 path="assurance" />
			</div>
		</div>


		<div class="form-group">
			<label for="idFormule" class="col-sm-2 control-label">Formule</label>
			<div class="col-sm-3">
				<form:select cssClass="form-control" id="idFormule"
					 path="formule" items="${formules}" itemLabel="nomFormule" onkeyup=""/>
			</div>
		</div>

		<div class="form-group">
			<label for="idHotel" class="col-sm-2 control-label">Hotels</label>
			<div class="col-sm-3">
				<form:select cssClass="form-control" id="idHotel"
					path="formule.hotel" items="${hotels}" />
			</div>
		</div>
		
		<div class="form-group">
			<label for="idVoiture" class="col-sm-2 control-label">Voitures</label>
			<div class="col-sm-3">
				<form:select cssClass="form-control" id="idVoiture"
					path="formule.voiture" items="${voitures}" />
			</div>
		</div>

		<div class="form-group">
			<label for="idPrestation" class="col-sm-2 control-label">Prestation</label>
			<div class="col-sm-3">
				<form:select cssClass="form-control" id="idPrestation"
					 path="prestation" items="${prestations}" itemLabel="type"/>
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