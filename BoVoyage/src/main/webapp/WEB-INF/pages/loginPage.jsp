<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!-- ajouter la lib de jstl -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="assets/css/style.css" />
<title>login</title>
</head>

<body>
	<div class="login-page">
		

		<form class="fondForm" method="post" action="connexion">
			<input type="text" placeholder="identifiant" name="j_username" /> </br>
			</br> <input type="password" placeholder="mot de passe" name="j_password" />
			</br>
			</br>
			<button class="bouttonConnexion" type="submit">Se connecter
			</button>

			<p class="message">
				Pas encore client(e)? <a
					href="${pageContext.request.contextPath}/client/afficheAjouter">
					Cr�er un compte</a>
			</p>

			<c:if test="${not empty erreur}">
				<h4 style="color: red">La connexion a �chou�</h4>
			</c:if>
		</form>
	</div>
	

</body>
</html>