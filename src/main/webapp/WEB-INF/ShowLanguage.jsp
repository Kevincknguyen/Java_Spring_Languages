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


<a href="http://localhost:8080/">Return home</a>
<h1>

			
			Language Details for: <c:out value="${language.name}" ></c:out>
			</h1>
			
			
			<p>Creator:<c:out value="${language.creator}" ></c:out></p>
			<p>Version: <c:out value="${language.version}" ></c:out></p>

			
			<a href="http://localhost:8080/language/edit/${language.id}">
						Edit
						</a>
			
			<form action="/language/${language.id}" method="post">
						<input type="hidden" name="_method" value="delete">
						<input type="submit" value="Delete">
						</form>
	
</body>
</html>