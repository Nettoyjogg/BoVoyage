<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!-- ajout de la librairie de spring mvd pour l'ajout des formulaires -->
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!-- inclure la librairie jstl core -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ajout</title>
<link rel="stylesheet" href="<c:url value='/assets/css/bootstrap.css'/>" />
</head>
<body>

<form:form method="POST" action="soumettreModifierVoyage" commandName="vModif"
		cssClass="form-horizontal">

		<div class="form-group">
			<label for="idV" class="col-sm-2 control-label">Id du Voyage</label>
			<div class="col-sm-3">
				<form:input cssClass="form-control" id="idV"
					path="idVoyage" type="number" />
			</div>
		</div>

		<div class="form-group">
			<label for="idPlace" class="col-sm-2 control-label">Nombre de places</label>
			<div class="col-sm-3">
				<form:input cssClass="form-control" id="idPlace"
					path="placesLibres" />
			</div>
		</div>
		
		<div class="form-group">
			<label for="idPrix" class="col-sm-2 control-label">Prix</label>
			<div class="col-sm-3">
				<form:input cssClass="form-control" id="idPrix"
					path="prix" />
			</div>
		</div>

		<div class="form-group">
			<label for="idDaDep" class="col-sm-2 control-label">Date de départ</label>
			<div class="col-sm-3">
				<form:input type="date" cssClass="form-control" id="idDaDep"
					path="dateDepart" />
			</div>
		</div>
		
		<div class="form-group">
			<label for="idDaRet" class="col-sm-2 control-label">Date de retour</label>
			<div class="col-sm-3">
				<form:input type="date" cssClass="form-control" id="idDaRet"
					path="dateRetour" />
			</div>
		</div>

		<div class="form-group">
			<label for="idCont" class="col-sm-2 control-label">Destination : continent</label>
			<div class="col-sm-3">
				<form:input cssClass="form-control" id="idCont"
					path="destination.continent" placeholder="Continent"/>
			</div>
		</div>
		
		<div class="form-group">
			<label for="idPay" class="col-sm-2 control-label">Destination : pays</label>
			<div class="col-sm-3">
				<form:input cssClass="form-control" id="idPay"
					path="destination.pays" placeholder="Pays"/>
			</div>
		</div>
		
	

		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-default">Ajouter</button>
			</div>
		</div>
	</form:form>

	

</body>
</html>