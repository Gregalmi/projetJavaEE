<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Achats</title>
	</head>
	<body>
	<%@include file ="menu.jsp" %>
	
	<div>
	<table class="paleBlueRows">
	<caption>Liste de mes achats</caption>
			<th>ID</th><th>NOM</th><th>VENDEUR</th><th>DATE D'ACHAT</th><th>DATE D'EXPEDITION</th><th>ETAT</th>
			  <c:forEach var="achat" items="${model.listeAchats}"> 
				<tr>
					<td><c:out value="${achat.id}"/></td>
					<td><c:out value="${achat.article.nomArticle}"/></td>
					<td><c:out value="${achat.article.vendeur.login}"/></td>
					<td><fmt:formatDate value="${achat.dateAchat}" pattern="dd-MM-yyyy"/></td>
					<td><fmt:formatDate value="${achat.dateExpedition}" pattern="dd-MM-yyyy"/></td>
					<td><c:out value="${achat.etatCommande}"/></td>
					
				</tr> 
		      </c:forEach>
		</table>
		</div>
	
	</body>
</html>