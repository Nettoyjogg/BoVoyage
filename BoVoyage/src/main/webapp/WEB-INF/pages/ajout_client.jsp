<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <!-- Ajouter la taglib spring mvc form -->
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    
        <!-- Ajouter la taglib de jstl core -->
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ajout</title>

<!-- Ajouter le fichier bootstrap -->
<link  rel="stylesheet" href="<c:url value='/assets/css/bootstrap.css'/>"/>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>

<body>

<h1 style="color:blue; text-align: center;">AJOUT Client</h1>

<form:form cssClass="form-horizontal" method="POST" action="soumettreAjouter" commandName="cAjout">

  <div class="form-group">
    <label for="idNom" class="col-sm-2 control-label">Nom</label>
    <div class="col-sm-5">
      <form:input  cssclass="form-control" path="nomClient" id="idNom" placeholder="Nom"/>
    </div>
  </div>

  <div class="form-group">
    <label for="idPrenom" class="col-sm-2 control-label">Prenom</label>
    <div class="col-sm-5">
      <form:input  cssclass="form-control" path="prenomClient" id="idPrenom" placeholder="Prenom"/>
    </div>
  </div>
  
    <div class="form-group">
    <label for="idCivilite" class="col-sm-2 control-label">Civilite</label>
    <div class="col-sm-5">
      <form:radiobutton cssclass="form-control" path="civilite" id="idCivilite" value="M" />Monsieur
      <form:radiobutton cssclass="form-control" path="civilite" id="idCivilite" value="Mme" />Madame   
    </div>
  </div>
  
    <div class="form-group">
    <label for="idAdresse" class="col-sm-2 control-label">Adresse</label>
    <div class="col-sm-5">
      <form:input  cssclass="form-control" path="adresse" id="idAdresse" placeholder="Adresse"/>
    </div>
  </div>
  
    <div class="form-group">
    <label for="idTelephone" class="col-sm-2 control-label">Telephone</label>
    <div class="col-sm-5">
      <form:input type="number"  cssclass="form-control" path="telephone" id="idTelephone" placeholder="Telephone"/>
    </div>
  </div>
  
    <div class="form-group">
    <label for="idDateNaissance" class="col-sm-2 control-label">Date Naissance</label>
    <div class="col-sm-5">
      <form:input type="date" cssclass="form-control" path="dateNaissance" id="idDateNaissance" placeholder="Date"/>
    </div>
  </div>

    <div class="form-group">
    <label for="idCarteB" class="col-sm-2 control-label">Numero de carte bancaire</label>
    <div class="col-sm-5">
      <form:input type="number" cssclass="form-control" path="numCarteB" id="idCarteB" placeholder="Numero de carte bancaire"/>
    </div>
  </div>

    <div class="form-group">
    <label for="idSolde" class="col-sm-2 control-label">Solde</label>
    <div class="col-sm-5">
      <form:input type="number" cssclass="form-control" path="Solde" id="idSolde" placeholder="Votre solde"/>
    </div>
  </div>
  
   <div class="form-group">
    <label for="idMail" class="col-sm-2 control-label">Mail</label>
    <div class="col-sm-5">
      <form:input type="email" cssclass="form-control" path="mailClient" id="idMail" placeholder="Mail"/>
    </div>
  </div>
  
   <div class="form-group">
    <label for="idMdp" class="col-sm-2 control-label">Mdp</label>
    <div class="col-sm-5">
      <form:input type="password" cssclass="form-control" path="mdpClient" id="idMdp" placeholder="Mdp"/>
    </div>
  </div>


  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-default">Ajouter</button>
    </div>
  </div>
</form:form>



</body>
</html>