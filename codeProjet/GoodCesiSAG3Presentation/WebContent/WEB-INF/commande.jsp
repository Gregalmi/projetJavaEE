<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Transaction bancaire</title>
</head>
<body>	
	<%@include file ="menu.jsp" %>

		
<%--		<h4>Récapitulatif de votre commande</h4>
		
 		<th>Id article</th><th>NOM article</th><th>prix</th><th>frais de port</th>
			<tr>
				<td><c:out value="${article.id}"/></td>
				<td><c:out value="${article.nomArticle}"/></td>
				<td><c:out value="${article.prix}"/></td>
				<td><c:out value="${article.fdp}"/></td>
			</tr> 
--%>		
		
		<h4>Votre paiement</h4>
		<form action="CommandeServlet" method="post">
		<tr>
			<td>Numéro de carte : </td>
			<td><input type="text" name="numCarte"></td>
		</tr>
		<td><input type="submit" value="payer" name="payer"></td>
		</form>
		<br>
		<c:out value="${msgErreur}"/><br>
		
</body>
</html>