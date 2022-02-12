<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
	<%@ page isErrorPage="true" %>

    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div>
<a href="http://localhost:8080/">Return home</a>
</div>

	<div>
		<form action="/language/${language.id}" method="post">
		<input type="hidden" name="_method" value="delete">
		<input type="submit" value="Delete">
		</form>
	</div>
			<h1>Edit an Language</h1>
	<form:form action="/language/edit/${language.id}" method="post" modelAttribute="language">
	<input type="hidden" name="_method" value="put">
				<p>
					<form:label path="name">Language Name</form:label>
					<form:errors path="name" class="text-danger"/>
					<form:input path="name" />
				</p>
					<form:label path="creator">creator</form:label>
					<form:errors path="creator" class="text-danger"/>
					<form:input path="creator" />
				<p>
					<form:label path="version">Version</form:label>
					<form:errors path="version" class="text-danger"/>
					<form:input path="version" />
				</p>
				<p>
					<input type=submit value="Submit"/>
				</p>
				
				
	</form:form>
	
	
</body>
</html>
