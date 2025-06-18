<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List, Com.Student.Student"%>

<!DOCTYPE html>
<html>
<head>
<title>Student List</title>
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f4f4f4;
	text-align: center;
}

.container {
	margin: 50px auto;
	width: 80%;
	background: white;
	padding: 20px;
	border-radius: 10px;
	box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
}

table {
	width: 100%;
	border-collapse: collapse;
	margin-top: 20px;
}

th, td {
	padding: 10px;
	border: 1px solid #ddd;
	text-align: left;
}

th {
	background-color: #007bff;
	color: white;
}

tr:nth-child(even) {
	background-color: #f2f2f2;
}

.btn {
	padding: 5px 10px;
	border: none;
	color: white;
	cursor: pointer;
	border-radius: 5px;
}

.update {
	background: orange;
}

.delete {
	background: red;
}

.find {
	background: green;
}
</style>
</head>
<body>

	<div class="container">
		<h2>Student List</h2>


		<%
		if (request.getAttribute("message") != null) {
		%>
		<p style="color: green;"><%=request.getAttribute("message")%></p>
		<%
		}
		%>

		<%
		if (request.getAttribute("error") != null) {
		%>
		<p style="color: red;"><%=request.getAttribute("error")%></p>
		<%
		}
		%>

		<table>
			<tr>
				<th>Username</th>
				<th>Email</th>
				<th>Password</th>
				<th>Section</th>
				<th>Actions</th>
			</tr>

			<%
			List<Student> students = (List<Student>) request.getAttribute("students");
			if (students != null) {
				for (Student student : students) {
			%>
			<tr>

				<td><%=student.getUsername()%></td>
				<td><%=student.getEmail()%></td>
				<td><%=student.getPassword()%></td>
				<td><%=student.getSection()%></td>

				<%-- is ke ander servlet ka link he --%>

				<td><a href="updateStudent?id=<%=student.getId()%>"
					class="btn update">Update</a> 
					
					<%-- 	<form action="updateStudent" method="post" >
					<input type="hidden" name="id" value="<%=student.getId()%>">
					<input type="submit" value="Update" class= "btn update">Update
					</form>		--%> 
					<a href="deleteStudent?id=<%=student.getId()%>"
					class="btn delete">Delete</a> <a
					href="findStudent?email=<%=student.getEmail()%>" class="btn find">Find</a></td>
			</tr>
			<%
			}
			} else {
			%>
			<tr>
				<td colspan="6" style="text-align: center;">No students found.</td>
			</tr>
			<%
			}
			%>

		</table>
	</div>

</body>
</html>
