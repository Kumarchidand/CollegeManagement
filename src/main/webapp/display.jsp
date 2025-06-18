<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="Com.Student.Student"%>
<!DOCTYPE html>
<html>
<head>
<title>Display Data</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f4;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        margin: 0;
    }
    .container {
        background: white;
        padding: 20px;
        box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
        border-radius: 10px;
        width: 400px;
        text-align: center;
    }
    h2 {
        color: #333;
        margin-bottom: 20px;
    }
    table {
        width: 100%;
        border-collapse: collapse;
        margin-top: 10px;
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
    .no-data {
        color: red;
        font-weight: bold;
    }
</style>
</head>
<body>

    <div class="container">
        <h2>Submitted Data</h2>

        <%
        Student student = (Student) request.getAttribute("student");
        if (student != null) {
        %>
            <table>
                <tr>
                    <th>Field</th>
                    <th>Details</th>
                </tr>
                <tr>
                    <td>Name</td>
                    <td><%= student.getUsername() %></td>
                </tr>
               
                <tr>
                    <td>Email</td>
                    <td><%= student.getEmail() %></td>
                </tr>
                 <tr>
                    <td>Password</td>
                    <td><%= student.getPassword() %></td>
                </tr>
                <tr>
                    <td>Section</td>
                    <td><%= student.getSection() %></td>
                </tr>
            </table>
        <%
        } else {
        %>
            <p class="no-data">No data found.</p>
        <%
        }
        %>
         <br>
        <a href="students" class="btn">View All Students</a> 
        <%--Added a "View All Students" button that links to students (handled by StudentListServlet.java). --%>
    </div>

</body>
</html>
