<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


  <% String message = (String) request.getAttribute("success"); %>
        <% if (message != null) { %>
            <p class="message success"><%= message %></p>
        <% } %>
     <% 
   String name = (String) request.getAttribute("username"); 
%>



<%= "Welcome " + name %>
     <a href="students">view table</a>
</body>
</html>