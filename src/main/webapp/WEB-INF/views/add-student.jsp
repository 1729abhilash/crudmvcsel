<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
        pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<title>Add student</title>
</head>
<body>

<h2>Add Student Page</h2>
<div align="center">
<form:form action="saveStudent" modelAttribute="student" method="post">

<form:hidden path="id"/>
<br>

<label>Student Name</label>
<form:input path="name"/>
<br>
<label>Moible  </label>
<form:input path="mobile"/>
<br>
<label>Country  </label>
<form:input path="country"/>
<br>
<input type="submit" value="Submit"/>

</form:form>
</div>

</body>
</html>