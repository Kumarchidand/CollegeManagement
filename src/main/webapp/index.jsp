<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Welcome</title>
<style>
    * {
        margin: 0;
        padding: 0;
        box-sizing: border-box;
        font-family: Arial, sans-serif;
    }
    body {
        background-color: #f4f4f4;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        text-align: center;
    }
    .container {
        background: white;
        padding: 30px;
        box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
        border-radius: 10px;
        width: 400px;
    }
    h1 {
        color: #007bff;
        margin-bottom: 20px;
    }
    h2 {
        color: #333;
        margin-bottom: 15px;
    }
    p {
        font-size: 16px;
        margin-bottom: 20px;
        color: #555;
    }
    .btn-container {
        display: flex;
        flex-direction: column;
        gap: 10px;
    }
    .btn {
        display: inline-block;
        width: 100%;
        padding: 12px;
        text-decoration: none;
        color: white;
        background-color: #007bff;
        border-radius: 5px;
        font-size: 16px;
        font-weight: bold;
        transition: 0.3s ease;
    }
    .btn:hover {
        background-color: #0056b3;
    }
</style>
</head>
<body>

    <div class="container">
        <h1>Welcome!</h1>
        <h2>College Management System</h2>
        <p>Login if you already have an account, or register as a new user.</p>

        <div class="btn-container">
            <a href="profile" class="btn">Login</a>
            <a href="register" class="btn">New Register</a>
        </div>
    </div>

</body>
</html>
