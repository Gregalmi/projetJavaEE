<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Connexion</title>
	<%@include file="/WEB-INF/menu.jsp" %>
	
	<div class="form-style-6">
	<h4>Connexion à votre compte utilisateur</h4>
		<form action="ConnexionServlet" method="post">
			<table>
				<tr>
					<td>Votre login  </td>
					<td><input type="text" required="required" name="login"></td>
				</tr>
				<tr>
					<td>Votre mot de passe  </td>
					<td><input type="text" required="required" name="password"></td>
				</tr>
	<%-- 			<tr>
					<td></td>
					<td><input type="submit" value="S'identifier" name="connecter" class="btn2"></td>
				</tr>--%>
			</table>
			<button type="submit"  name="connecter" class="btn2">S'identifier</button>
		</form>	
		</div>
		<br>
		<c:out value="${msgErreur}"/><br>
        
	
</head>
<body>

</body>
</html>