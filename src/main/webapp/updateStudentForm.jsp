<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="Com.Student.Student"%>

<%
Student student = (Student) request.getAttribute("student");
if (student == null) {
	response.sendRedirect("TableOfStudent.jsp");
	return;
}
%>

<!DOCTYPE html>
<html>
<head>
<title>Update Student</title>
</head>
<body>
	<h2>Update Student</h2>
	<form action="updateStudent" method="post">
		<input type="hidden" name="id" value="<%=student.getId()%>">

		Username: <input type="text" name="username"
			value="<%=student.getUsername()%>"><br> Email: <input
			type="email" name="email" value="<%=student.getEmail()%>"><br>
			Password: <input
			type="password" name="password" value="<%=student.getPassword()%>"><br>
		Section: <input type="text" name="section"
			value="<%=student.getSection()%>"><br> 

		<input type="submit" value="Update"> <a
			href="TableOfStudent.jsp">Cancel</a>
	</form>
</body>
</html>
