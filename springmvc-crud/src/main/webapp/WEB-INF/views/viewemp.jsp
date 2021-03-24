<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
            <%@page isELIgnored="false" %>
            
        
   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Employee List</h1>
<table border="2" width="70" >
<tr><th>Id</th><th>Name</th><th>Salary</th><th>Designantion</th><th>Edit</th><th>Delete</th></tr>
<c:forEach var="emp" items="${list}">
<tr>
<td>${emp.id}</td>
<td>${emp.name}</td>
<td>${emp.salary}</td>
<td>${emp.designation}</td>
<td><a href="editemp/${emp.id}">Edit</a></td>
<td><a href="deleteemp/${emp.id}">Delete</a>
</c:forEach>

</table>
<br/>
<a href="empform">Add New Employee</a>

</body>
</html>