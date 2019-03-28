<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!-- inclure la librairie jstl core -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../../../favicon.ico">

<title>Narrow Jumbotron Template for Bootstrap</title>

<!-- Bootstrap core CSS -->
<link href="../../css/editor.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="narrow-jumbotron.css" rel="stylesheet">

<title>Map</title>

</head>
<body>

	<div class="container">
		<div class="header clearfix">
			<button type="button" class="btn btn-outline-info">Acceuil</button>

		</div>

		<div class="jumbotron" style="height: 478px;">
			<div data-component-maps=""
				style="min-height: 350px; min-width: 350px; position: relative; height: 381px;">
				<iframe width="630" height="525" frameborder="0" scrolling="no"
					marginheight="0" marginwidth="0"
					src="https://www.openstreetmap.org/export/embed.html?bbox=-57.55267544408621%2C10.189270848606254%2C23.482480805913806%2C57.54164349185712&amp;layer=hot"
					style="border: 1px solid black"></iframe>
				<br />
			</div>
		</div>

		<div class="row marketing"></div>

		<footer class="footer">
			<p>© Company 2017</p>
		</footer>

	</div>
	<!-- /container -->




</body>
</html>