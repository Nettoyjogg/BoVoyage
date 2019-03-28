<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!-- inclure la librairie jstl core -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>accueil Conseiller</title>

<!-- ajouter le fichier bootstrap -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/bootstrap.css" />
</head>
<body>
	
<%@ include file="templates/navbarconseiller.html" %>	
	
	<h1 style="color:blue; text-align: center;">liste des voyages</h1>

<table class="table table-striped">
<tr>
<th>Id</th>
<th>places libres </th>

</tr>

<c:forEach items="${liste}" var="v">
<tr>
<td>${v.idVoyage}</td>
<td>${v.placesLibres}</td>
</tr>

</c:forEach>



</table>
	
</body>
</html>