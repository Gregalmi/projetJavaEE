<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Catégorie</title>
		</head>
	<body>
		<%@include file ="menu.jsp" %>
		
		<div class="form-style-6">
		<h4> Ajouter une Catégorie </h4>	
		<form action="CategorieServlet" method="post">
			<table>
				<tr>
					<td>Nom de la catégorie : </td>
					<td><input type="text" name="nomCategorie"></td>
				</tr>
				
			</table>
			
			<button type="submit"  name="creerCategorie" class="btn2">Créer</button>
		</form>	
		</div>
		<h4>Tableau des Catégories</h4>
	<table class="paleBlueRows">
		<th>CATEGORIE</th>
		  <c:forEach var="categorie" items="${model.categories}"> 
			<tr>
				<td><c:out value="${categorie.nomCat}"/></td>	
			</tr> 
	      </c:forEach>
	</table> 
	
			
	</body>
</html>