<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modifier un article</title>
</head>
<body>
<%@include file ="menu.jsp" %>
		
		<div class="form-style-6">
		<h4> Modifier un article en vente </h4>
		<form action="ModifierArticleServlet" method="post">
		<%--  <input type="hidden" name="vendeur" value="${model.promotion.acronyme}" /> --%>
			<table>
				<tr>
					<td>Nom de l'article : </td>
					<td><input type="text" required="required" name="nomArticle"></td>
				</tr>
				<tr>
					<td>Description de l'article : </td>
					<td><input type="text" required="required" name="description"></td>
				</tr>
				<tr>
					<td>Prix : </td>
					<td><input type="text" required="required" name="prix"></td>
				</tr>
				<tr>
					<td>Frais de port : </td>
					<td><input type="text" required="required" name="fdp"></td>
				</tr>
				<tr>
					<td>Catégorie : </td>
					<td><select name="categorie">
					    <c:forEach var="categorie" items="${model.categories}"> 
					   	<c:if test="${categorie.nomCat != model.nomCat}">
						   		<option value="${categorie.nomCat}"><c:out value="${categorie.nomCat}"/></option>
						</c:if>
					   	<c:if test="${categorie.nomCat == model.nomCat}"> --%>
						   		<option selected="selected" value="${categorie.nomCat}"><c:out value="${categorie.nomCat}"/></option>
					  	</c:if>  
						</c:forEach>
					</select></td>
					<%-- <td><input type="text" name="intitule"></td> --%>
				</tr>
			<%-- 	<tr>
					<td></td>
					<td></td>
				</tr>--%>
			</table>
			<button type="submit"  name="mettreajour" class="btn2">Modifier</button>
		</form>	
		</div>
		<c:out value="${msgErreur}"/><br>

</body>
</html>