<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!-- inclure la librairie jstl core -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>accueil</title>

<!-- ajouter le fichier bootstrap -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/bootstrap.css" />
</head>
<body>

	<%@ include file="templates/navbar.html"%>

	<h1 style="color: blue; text-align: center;">liste des voyages</h1>


<div>
	<c:forEach items="${liste}" var="v">
			${v.prix}
			${v.destination.pays}
			${v.placesLibres}
		<img src="photoVoyage?idVoyage=${v.idVoyage}" />

	</c:forEach>
</div>


</body>
</html>