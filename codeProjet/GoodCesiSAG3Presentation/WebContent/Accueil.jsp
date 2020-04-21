<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Accueil</title>
</head>
<body>
		<%@include file ="/WEB-INF/menu.jsp" %>
<%-- 	<form action="AccueilServlet" method="get">
	Catégorie : 
		<select name="categorie">
		    <c:forEach var="categorie" items="${model.categories}"> 
		    	<c:if test="${categorie.nomCat != model.nomCat}">
			   		<option value="${categorie.nomCat}"><c:out value="${categorie.nomCat}"/></option>
			   	</c:if>
			   	<c:if test="${categorie.nomCat == model.nomCat}">
			   		<option selected="selected" value="${categorie.nomCat}"><c:out value="${categorie.nomCat}"/></option>
			   	</c:if>
			 </c:forEach>
		</select>
			<input type="submit" value="ok">
	</form>	
		<br/>
		<c:out value="Vous êtes dans la catégorie :"/>
		<c:out value="${model.nomCat}"/>
		<br/>
 --%>
 
 	<p>Bienvenue sur le site d'échanges du CESI !</p>
 	<p>Vous ne vous servez plus d'un objet ? Laissez lui une seconde chance ! Vendez le ! </p>
	
	<table class="paleBlueRows">
	<caption>Tous les articles en vente</caption>
		<th>Id</th><th>NOM</th><th>Description</th><th>Categorie</th><th>prix</th><th>frais de port</th><th>vendeur</th><th>etat</th><th>commander</th>
		  <c:forEach var="article" items="${model.articles}"> 
			<tr>
				<td><c:out value="${article.id}"/></td>
				<td><c:out value="${article.nomArticle}"/></td>
				<td><c:out value="${article.description}"/></td>
				<td><c:out value="${article.categorie.nomCat}"/></td>
				<td><c:out value="${article.prix}"/></td>
				<td><c:out value="${article.fdp}"/></td>
				<td><c:out value="${article.vendeur.login}"/></td>
				<td><c:out value="${article.etatArticle}"/></td>
				<c:if test="${empty sessionScope.login}">
				<td>
					<a href="ConnexionServlet" class="btn2">Commander</a>	
				</td>
				</c:if>
				<c:if test="${!empty sessionScope.login}">
				<td>
					<a href="CommandeServlet?idarticle=${article.id}" class="btn2">Commander</a>	
				</td>
				</c:if>
			</tr> 
	      </c:forEach>
	</table> 
</body>
</html>