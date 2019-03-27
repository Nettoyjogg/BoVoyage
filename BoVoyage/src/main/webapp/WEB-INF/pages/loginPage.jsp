<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!-- ajouter la lib de jstl -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="assets/css/styleLogin.css" />
<title>login</title>
</head>
<body>
	<div class="login-page">
		<!--   <div class="form"> -->
		<!--     <form class="register-form"> -->
		<!--       <input type="text" placeholder="name"/> -->
		<!--       <input type="password" placeholder="password"/> -->
		<!--       <input type="text" placeholder="email address"/> -->
		<!--       <button>create</button> -->
		<!--       <p class="message">Already registered? <a href="#">Sign In</a></p> -->
		<!--     </form> -->
		<form class="fondForm" method="post" action="connexion">
			<input type="text" placeholder="identifiant" name="j_username" /> </br></br>
				<input type="password" placeholder="mot de passe" name="j_password" />  </br></br>
				<button class="bouttonConnexion" type="submit" > Se connecter </button>
			<!--       <button>login</button> -->
			<!--       <p class="message">Not registered? <a href="#">Create an account</a></p> -->
			<c:if test="${not empty erreur}">
				<h4 style="color: red">La connexion a échoué</h4>
			</c:if>
		</form>
	</div>
	</div>

</body>
</html>