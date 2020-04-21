<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Inscription</title>
	</head>
	<body>
		<%@include file ="/WEB-INF/menu.jsp" %>
		
		<div class="form-style-6">
		<h4>Veuillez vous inscrire</h4>
		
		<form action="InscriptionServlet" method="post">
		
			<table>
			<tr>
			<td><label for="login">Votre login :</label></td>
			<td><input type="text" required="required" id="login" name="login"></td>
			</tr>
			<tr>
			<td><label for="password">Votre mot de passe :</label></td>
			<td><input type="text" required="required" id="password" name="password"></td>
			</tr>
			</table>
			<%-- <tr class="button">--%>
			<button type="submit" name="creeruUtilisateur" class="btn2">S'inscrire</button>

		</form>
		</div>
		
	
	</body>
</html>