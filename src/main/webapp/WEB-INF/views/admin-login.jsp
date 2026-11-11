
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Community Care - Admin Login</title>

<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f2f4f7;
        margin: 0;
        min-height: 100vh;
        display: flex;
        justify-content: center;
        align-items: center;
    }

    .login-container {
        background-color: white;
        width: 350px;
        padding: 30px;
        border: 1px solid #ddd;
        border-radius: 8px;
    }

    h1, h2, p {
        text-align: center;
    }

    input[type="email"],
    input[type="password"] {
        width: 100%;
        padding: 10px;
        margin: 8px 0 15px;
        box-sizing: border-box;
    }

    button {
        width: 100%;
        padding: 10px;
        background-color: #2563eb;
        color: white;
        border: none;
        border-radius: 4px;
        cursor: pointer;
    }

    .links {
        text-align: center;
        margin-top: 18px;
    }
</style>
</head>

<body>

<div class="login-container">

    <h1>Community Care</h1>
    <p>Gated Community Complaint Tracker</p>

    <h2>Admin Login</h2>

    <form action="${pageContext.request.contextPath}/community/admin-login"
          method="post">

        <label>Email Address</label>
        <input type="email" name="email" required>

        <label>Password</label>
        <input type="password" name="password" required>

        <br><br>

        <button type="submit">Login</button>

    </form>

    <div class="links">
        <a href="${pageContext.request.contextPath}/">
            Back to Resident Login
        </a>
    </div>

</div>

</body>
</html>
