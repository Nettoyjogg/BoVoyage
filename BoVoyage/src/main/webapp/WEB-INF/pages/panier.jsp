<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!-- inclure la librairie jstl core -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>panier</title>

<!-- ajouter le fichier bootstrap -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/bootstrap.css" />
</head>
<body>

	<%@ include file="templates/navbar.html"%>

	<h1 style="color: black; text-align: center;">liste des commandes</h1>


	<div class="col-md-10" style="margin-left: 100px">
		<c:forEach items="${liste}" var="com">

			<div class="col-md-6" style="text-align: center">
				<div style="color: grey; font: bold; font-size: 8pt">
					<div style="color: grey; font: bold; font-size: 12pt">
						<div style="color: black; font: bold; font-size: 15pt">
							Id de la commande: ${com.idCommande} 
						</div>
						Numero de la commande : ${com.numeroCommande}
					</div>
					Assurance : ${com.assurance}
				</div>
				
				<div style="color: grey; font: bold; font-size: 8pt">
					<div style="color: grey; font: bold; font-size: 12pt">
						<div style="color: black; font: bold; font-size: 15pt">
							Etat de la commande: ${com.etat} 
						</div>
						Formule : ${com.formule.nomFormule}
						 ${com.formule.hotel.nomH}
						 ${com.formule.hotel.nombreEtoile}
						 
						 ${com.formule.voiture.categorie}
						 ${com.formule.hotel.nomLoueur}
						 ${com.formule.hotel.nombrePlace}
						 
					</div>
					Prestation : ${com.prestation.type}
				</div>
			</div>
		</c:forEach>
	</div>


</body>
</html>