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
<title>Cloture</title>
<link rel="stylesheet" href="<c:url value='/assets/css/bootstrap.css'/>" />
</head>
<body>

<form:form method="POST" action="soumettreClore" commandName="vClot"
		cssClass="form-horizontal" enctype="multipart/form-data">

		<div class="form-group">
			<label for="idV" class="col-sm-2 control-label">Id du Voyage</label>
			<div class="col-sm-3">
				<form:input cssClass="form-control" id="idV"
					path="idVoyage" type="number" />
			</div>
		</div>
		
	

		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-default">Clore</button>
			</div>
		</div>
	</form:form>

	

</body>
</html>