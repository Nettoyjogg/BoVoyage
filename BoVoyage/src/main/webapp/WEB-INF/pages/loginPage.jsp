<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
	  <!-- ajouter la lib de jstl -->
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>login</title>
</head>
<body>

	<form method="post" action="connexion">
		Identifiant:<input type="text" name="j_username"> 
		<br /> 
		Mot de Passe:<input type="password" name="j_password"> 
		<br /> 
		<input type="submit" value="se connecter">
	</form>
<c:if test="${not empty erreur}">
<h4 style="color:red">La connexion a échoué</h4>
</c:if>
</body>
</html>