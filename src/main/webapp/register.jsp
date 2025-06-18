<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>
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
        padding: 30px;
        box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
        border-radius: 10px;
        width: 350px;
        text-align: center;
    }
    h2 {
        margin-bottom: 20px;
        color: #333;
    }
    p {
        font-size: 14px;
    }
    .message {
        padding: 10px;
        border-radius: 5px;
        margin-bottom: 10px;
    }
    .success {
        background: #d4edda;
        color: #155724;
        border: 1px solid #c3e6cb;
    }
    .error {
        background: #f8d7da;
        color: #721c24;
        border: 1px solid #f5c6cb;
    }
    form {
        display: flex;
        flex-direction: column;
        gap: 15px;
    }
    input {
        padding: 10px;
        border: 1px solid #ccc;
        border-radius: 5px;
        font-size: 14px;
    }
    input[type="submit"] {
        background: #28a745;
        color: white;
        border: none;
        cursor: pointer;
        font-size: 16px;
    }
    input[type="submit"]:hover {
        background: #218838;
    }
    a {
        color: #007bff;
        text-decoration: none;
    }
    a:hover {
        text-decoration: underline;
    }
</style>
</head>
<body>

    <div class="container">
        <h2>User Registration</h2>

        <%-- Show success message --%>
        <% String message = (String) request.getAttribute("message"); %>
        <% if (message != null) { %>
            <p class="message success"><%= message %></p>
        <% } %>

        <%-- Show error message --%>
        <% String error = (String) request.getAttribute("error"); %>
        <% if (error != null) { %>
            <p class="message error"><%= error %></p>
        <% } %>

        <form action="register" method="post">
            <input type="text" name="username" placeholder="Username" required>
                        <input type="email" name="email" placeholder="Email" required>
            <input type="password" name="password" placeholder="Password" required>

            <input type="text" name="section" placeholder="Section" required>
            <input type="submit" value="Register">
        </form>

        <p>Have an account? <a href="profile.jsp">Login here</a></p>
    </div>

</body>
</html>
