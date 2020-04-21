<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Mes ventes en cours</title>
</head>
<body>
	<%@include file ="menu.jsp" %>

	<form action="VenteServlet" method="post">
	<table class="paleBlueRows">
	<caption>Mes ventes en cours</caption>
			<th>Id</th><th>NOM DE L'ARTICLE</th><th>ACHETEUR</th><th>PRIX</th><th>FRAIS DE PORT</th><th>DATE D'ACHAT</th><th>DATE D'EXPEDITION</th><th>ETAT</th><th>ETAT EN COURS</th><th>ETAT VALIDE</th><th>ETAT ENVOYE</th>
			  <c:forEach var="vente" items="${model.listeVentes}"> 
				<tr>
					<td><c:out value="${vente.id}"/></td>
					<td><c:out value="${vente.article.nomArticle}"/></td>
					<td><c:out value="${vente.acheteur.login}"/></td>
					<td><c:out value="${vente.article.prix}"/></td>
					<td><c:out value="${vente.article.fdp}"/></td>
					<td><fmt:formatDate value="${vente.dateAchat}" pattern="dd-MM-yyyy"/></td>
					<td><fmt:formatDate value="${vente.dateExpedition}" pattern="dd-MM-yyyy"/></td>
					<td><c:out value="${vente.etatCommande}"/></td>
					<td><a href="VenteServlet?encours=${vente.id}" class="btn2">En cours</a></td>
					<td><a href="VenteServlet?valide=${vente.id}" class="btn2">Valide</a></td>
					<td><a href="VenteServlet?envoye=${vente.id}" class="btn2">Envoye</a></td>
				</tr> 	
	
									<%-- <td>
											<select name="etatCommande">
											<c:forEach var="etatCommande" items="${model.etatCommandes}"> 
												<option selected="selected" value="${etatCommande}"><c:out value="${etatCommande}"/></option>
									        </c:forEach>
									        </select> 
										</td>
										<td><input type="submit" value="ok"></td>
										
									
									--%>	
		      </c:forEach>
		</table>
		</form>
</body>
</html>