<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
        pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<title>Students data</title>
</head>
<body>
<h1>Abhi Express</h1>
<h2>Students list</h2>
<div align="center">
<a href="/showAddStudentPage">add student page</a>

<table border="1">
<thead>
<tr>
<td>id</td>
<td>name</td>
<td>mobile</td>
<td>country</td>
<td>update</td>
<td>delete</td>
</tr>
</thead>
<tbody>
<c:forEach var="students" items="${studentList}">
<tr>
<td>${students.id}</td>
<td>${students.name}</td>
<td>${students.mobile}</td>
<td>${students.country}</td>
<td><a href=/updateStudent?userId=${students.id}>update</a></td>
<td><a href=/deleteStudent?userId=${students.id} onClick="if(!(confirm('are your sure you want to delete')))return false">delete</a></td>

</tr>

</c:forEach>
</tbody>
</table>
</div>
</body>
</html>