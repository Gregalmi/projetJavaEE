<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="entite.Role" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<link href="<c:url value="style.css"/>" rel="stylesheet">
		<title>Menu</title>
	</head>
	<body>
	<h1>Le Good CESI</h1>
		<c:if test="${empty sessionScope.login}">
			<a href="AccueilServlet" class="btn">Accueil</a>
			<a href="InscriptionServlet" class="btn">Inscription</a>
			<a href="ConnexionServlet" class="btn">Connexion</a>
		</c:if>
		<c:if test="${!empty sessionScope.login}">			
			<c:if test="${sessionScope.role == Role.ADMINISTRATEUR}">
				<a href="CategorieServlet" class="btn">Catégories</a>
			</c:if>
			<c:if test="${sessionScope.role == Role.UCONNECTE}">
				<a href="AccueilServlet" class="btn">Accueil</a>
				<a href="AchatServlet" class="btn">Achats</a>
				<a href="VenteServlet" class="btn">Ventes</a>
				<a href="ArticleServlet" class="btn">Articles</a>
			</c:if>
			<a href="DeconnexionServlet" class="btn">Deconnexion</a>
		</c:if>
		<br><br>
	</body>
</html>