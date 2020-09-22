<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
	<title>Company Home Page</title>
</head>
<body>
	<h2>Company Home Page</h2>
	<hr>
	<p>
	Welcome to the company home page!
	<br><br>
	User: <security:authentication property="principal.username" />
	<br>
	Role(s): <security:authentication property="principal.authorities" />
	</p>
	
	<hr>
	<p>
		<security:authorize access="hasRole('MANAGER')"> 
			<a href="${pageContext.request.contextPath}/leaders">Leadership meeting</a>	
		</security:authorize>
		<br>
		<security:authorize access="hasRole('ADMIN')">
			<a href="${pageContext.request.contextPath}/systems">Admin meeting</a>
		</security:authorize>
	</p>
	
	<!-- Add a logout button -->
	<form:form action="${pageContext.request.contextPath}/logout" 
			   method="POST">
	
		<input type="submit" value="Logout" />
	
	</form:form>

</body>
</html>









