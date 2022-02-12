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

	<h1>Safe Travels</h1>
	<table>
		<thead>
			<tr>
				<th>Name</th>
				<th>Creator</th>
				<th>Version</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="language" items="${languages}">
				
				<tr>
					
					<td><a href="http://localhost:8080/language/${language.id}">
						<c:out value="${language.name}"></c:out>
						</a></td>
					<td><c:out value="${language.creator}"></c:out></td>
					<td><c:out value="${language.version}"></c:out></td>
					
					<td><a href="http://localhost:8080/language/edit/${language.id}">
						Edit
						</a><form action="/language/${language.id}" method="post">
						<input type="hidden" name="_method" value="delete">
						<input type="submit" value="Delete">
						</form></td>
						
						
				</tr>
				
			
			</c:forEach>
		</tbody>
	</table>
	
	
	<h1>Add an language</h1>
	<form:form action="/" method="post" modelAttribute="language">
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

