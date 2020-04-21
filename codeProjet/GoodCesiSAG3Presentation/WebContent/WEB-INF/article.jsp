<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Mes articles en ventes</title>
</head>
<body>
	<%@include file ="menu.jsp" %>
	

	<form action="ArticleServlet" method="post">
	<table class="paleBlueRows">
	<caption>Mes articles en vente</caption>
		<th>Id</th><th>NOM</th><th>Description</th><th>Categorie</th><th>prix</th><th>frais de port</th><th>etat</th><th>supprimer</th><th>modifier</th>
		  <c:forEach var="article" items="${model.articles}"> 
			<tr>
				<td><c:out value="${article.id}"/></td>
				<td><c:out value="${article.nomArticle}"/></td>
				<td><c:out value="${article.description}"/></td>
				<td><c:out value="${article.categorie.nomCat}"/></td>
				<td><c:out value="${article.prix}"/></td>
				<td><c:out value="${article.fdp}"/></td>
				<td><c:out value="${article.etatArticle}"/></td>
				<td>
					<a href="ArticleServlet?supprimer=${article.id}" class="btn2">supprimer</a>	
				</td>
				<td>
					<a href="ModifierArticleServlet?modifier=${article.id}" class="btn2">modifier</a>	
				</td>
			</tr> 
	      </c:forEach>
	</table> 
	<h4>Déposer une annonce :</h4>
	<td><input type="submit" value="creer" name="creer" class="btn2"></td>
	</form>
	
	<c:out value="${msgErreur}"/><br>

</body>
</html>