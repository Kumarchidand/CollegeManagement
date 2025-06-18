<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="Com.Student.Student"%>

<!DOCTYPE html>
<html>
<head>
<title>Student Details</title>
</head>
<body>
	<h2>Student Details</h2>

	<%
	Student student = (Student) request.getAttribute("student");
	if (student != null) {
	%>
	<p>
		Username:
		<%=student.getUsername()%></p>

	<p>
		Email:
		<%=student.getEmail()%></p>
	<p>
		Password:
		<%=student.getPassword()%></p>
	<p>
		Section:
		<%=student.getSection()%></p>
	<%
	} else {
	%>
	<p style="color: red;">Student not found.</p>
	<%
	}
	%>
	<br>
	<a href="TableOfStudent.jsp">Back to Student List</a>
</body>
</html>
