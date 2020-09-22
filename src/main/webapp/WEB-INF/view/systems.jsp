<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin page</title>
</head>
<body>
	<h2>Page for admins</h2>
	<c:forEach var="temp" items="${username}">
		<tr>
			<td> ${temp.username} </td>
		</tr>
	</c:forEach>
	
</body>
</html>