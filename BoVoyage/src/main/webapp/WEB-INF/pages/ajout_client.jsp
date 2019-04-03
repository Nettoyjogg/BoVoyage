<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!-- Ajouter la taglib spring mvc form -->
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!-- Ajouter la taglib de jstl core -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Ajout d'un client</title>

<!-- Ajouter le fichier bootstrap -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/bootstrap.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/style.css" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>

<body>

	<div class="login-page">

		<form:form cssClass="fondForm" method="post" action="soumettreAjouter"
			commandName="cAjout">
			<label for="idNom"
				style="color: white; font-weight: bold; text-decoration: underline;">Nom:</label>
			<form:input type="text" id="idNom" placeholder="Nom" path="nomClient" />
			<br />

			<label for="idPrenom"
				style="color: white; font-weight: bold; text-decoration: underline;">Prénom:</label>
			<form:input type="text" id="idPrenom" placeholder="Prénom"
				path="prenomClient" />
			<br />

			<label
				style="color: white; font-weight: bold; text-decoration: underline;">Civilite:</label>
			<div style="color: white;">
				Homme:
				<form:radiobutton path="civilite" value="M" />
				Femme:
				<form:radiobutton path="civilite" value="Mme" />

			</div>

			<label for="idAdresse"
				style="color: white; font-weight: bold; text-decoration: underline;">Adresse:</label>
			<form:input type="text" path="adresse" id="idAdresse"
				placeholder="Adresse" />
			<br />

			<label for="idTelephone"
				style="color: white; font-weight: bold; text-decoration: underline;">Téléphone:</label>
			<form:input type="number" path="telephone" id="idTelephone"
				placeholder="Téléphone" />
			<br />

			<label for="idDateNaissance"
				style="color: white; font-weight: bold; text-decoration: underline;">Date
				de naissance:</label>
			<form:input type="date" path="dateNaissance" id="idDateNaissance"
				placeholder="Date de naissance" />
			<br />

			<label for="idCarteB"
				style="color: white; font-weight: bold; text-decoration: underline;">Numéro
				de carte bancaire:</label>
			<form:input type="number" path="numCarteB" id="idCarteB"
				placeholder="n° de carte bancaire" />
			<br />

			<label for="idSolde"
				style="color: white; font-weight: bold; text-decoration: underline;">Solde:</label>
			<form:input type="number" path="Solde" id="idSolde"
				placeholder="Votre solde" />
			<br />

			<label for="idMail"
				style="color: white; font-weight: bold; text-decoration: underline;">Mail:</label>
			<form:input type="email" path="mailClient" id="idMail"
				placeholder="Mail" />
			<br />

			<label for="idMdp"
				style="color: white; font-weight: bold; text-decoration: underline;">Mot
				de passe:</label>
			<form:input type="password" path="mdpClient" id="idMdp"
				placeholder="Mot de passe" />
			<br />

			<button class="bouttonConnexion" type="submit">Ajouter</button>
		</form:form>
	</div>
</body>
</html>