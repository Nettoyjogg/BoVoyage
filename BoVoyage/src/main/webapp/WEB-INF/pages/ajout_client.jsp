<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!-- Ajouter la taglib spring mvc form -->
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!-- Ajouter la taglib de jstl core -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ajout d'un client</title>

<!-- Ajouter le fichier bootstrap -->
<link rel="stylesheet" href="<c:url value='/assets/css/bootstrap.css'/>" />
<link rel="stylesheet" href="<c:url value='/assets/css/style.css' />" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>

<body>

	<h1 style="color: white; text-align: center; font-weight:bold; text-transform: uppercase ;">Nouveau Client</h1>
			
			<form class="fondForm" method="post" action="soumettreAjouter" commandName="cAjout">
			<label for="idNom" style=" color: white;font-weight:bold; text-decoration:underline;">Nom:</label>
					<input type="text" id="idNom" placeholder="Nom" path="nomClient" /> </br></br>
					
					<label for="idPrenom" style=" color: white;font-weight:bold; text-decoration:underline;">Prénom:</label>
					<input type="text" id="idPrenom" placeholder="Prénom" path="prenomClient" />  </br></br>
					
					
			
				  <label for="idCivilite" style=" color: white;font-weight:bold; text-decoration:underline;">Civilite:</label>
				  <div style=" color: white;">
					Homme:
				    <input type="radio" id="idCivilite" path="civilite"  name="contact" value="M">    
					Femme:
				    <input type="radio" id="idCivilite"  path="civilite"  name="contact" value="Mme">
				      </br> 
				  </div>
					   
					 <label for="idAdresse" style=" color: white;font-weight:bold; text-decoration:underline;">Adresse:</label>
					<input type="text" path="adresse" id="idAdresse" placeholder="Adresse"/>  </br></br>		
					
					<label for="idTelephone" style=" color: white;font-weight:bold; text-decoration:underline;">Téléphone:</label>			
					<input type="number" path="telephone" id="idTelephone" placeholder="Téléphone"/>  </br></br>
					
					<label for="idDateNaissance" style=" color: white;font-weight:bold; text-decoration:underline;">Date de naissance:</label>
					<input type="date" path="dateNaissance" id="idDateNaissance" placeholder="Date de naissance"/>  </br></br>
					
					<label for="idCarteB" style=" color: white;font-weight:bold; text-decoration:underline;">Numéro de carte bancaire:</label>
					<input type="number" path="numCarteB" id="idCarteB" placeholder="n° de carte bancaire"/>  </br></br>
					
					<label for="idSolde" style=" color: white;font-weight:bold; text-decoration:underline;">Solde:</label>
					<input type="number" path="Solde" id="idSolde" placeholder="Votre solde"/>  </br></br>
					
					<label for="idMail" style=" color: white;font-weight:bold; text-decoration:underline;">Mail:</label>
					<input type="email" path="mailClient" id="idMail" placeholder="Mail"/>  </br></br>
					
					<label for="idMdp" style=" color: white;font-weight:bold; text-decoration:underline;">Mot de passe:</label>
					<input type="password" path="mdpClient" id="idMdp" placeholder="Mot de passe"/>  </br></br>
					
					<button class="bouttonConnexion" type="submit" > Ajouter </button>

</body>
</html>