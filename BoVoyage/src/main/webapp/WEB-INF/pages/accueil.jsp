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

	<h1 style="color: black; text-align: center;">liste des voyages</h1>


	<div class="col-md-10" style="margin-left: 100px">
		<c:forEach items="${liste}" var="v">

			<div class="col-md-6" style="text-align: center">
				<div style="color: grey; font: bold; font-size: 8pt">
					<div style="color: grey; font: bold; font-size: 12pt">
						<div style="color: black; font: bold; font-size: 15pt">
							<div>
								<img src="photoVoyage?idVoyage=${v.idVoyage}"
									style="height: 250px; width: 350px" />
							</div>
							${v.destination.pays} 
						</div>
						prix : ${v.prix} euros
					</div>
					offres restantes : ${v.placesLibres}
				</div>
			</div>
		</c:forEach>
	</div>


</body>
</html>