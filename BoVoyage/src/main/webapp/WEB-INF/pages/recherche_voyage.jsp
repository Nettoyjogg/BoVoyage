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
<title>Rechercher</title>
<link rel="stylesheet" href="<c:url value='/assets/css/bootstrap.css'/>" />
</head>
<body>

<form:form method="POST" action="soumettreRechercherVoyage" commandName="vRec"
		cssClass="form-horizontal">

		<div class="form-group">
			<label for="idV" class="col-sm-2 control-label">Id du Voyage</label>
			<div class="col-sm-3">
			<form:select path="idVoyage" cssClass="form-control" id="idV" items="${listevoyage}" itemLabel="placesLibres" itemValue="idVoyage"></form:select>

			</div>
		</div>

		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-default">Rechercher</button>
			</div>
		</div>
	</form:form>
	
	<h1>${msg}</h1>


<h1 style="color:blue; text-align: center;">liste des voyages</h1>

<table class="table table-striped">
<tr>

<th>Prix </th>
<th>Pays de destination</th>
<th>places libres</th>

</tr>


<tr>
<td>${voyage.prix}</td>
<td>${voyage.destination.pays}</td>
<td>${voyage.placesLibres}</td>
</tr>





</table>


</body>
</html>