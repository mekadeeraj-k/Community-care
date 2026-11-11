
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Community Care - Resident Registration</title>

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

    .registration-container {
        background-color: white;
        width: 380px;
        padding: 30px;
        border: 1px solid #ddd;
        border-radius: 8px;
        margin: 20px;
    }

    h1, h2, p {
        text-align: center;
    }

    input {
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

    .message {
        text-align: center;
        margin-bottom: 15px;
    }

    .links {
        text-align: center;
        margin-top: 18px;
    }
</style>
</head>

<body>

<div class="registration-container">

    <h1>Community Care</h1>
    <p>Gated Community Complaint Tracker</p>

    <h2>Resident Registration</h2>

    <% if (request.getAttribute("error") != null) { %>
        <p class="message" style="color: red;">
            <%= request.getAttribute("error") %>
        </p>
    <% } %>

    <% if (request.getAttribute("success") != null) { %>
        <p class="message" style="color: green;">
            <%= request.getAttribute("success") %>
        </p>
    <% } %>

    <form action="register" method="post">

        <label>Resident Name</label>
        <input type="text" name="residentName" required>

        <label>Email Address</label>
        <input type="email" name="email" required>

        <label>Contact Number</label>
        <input type="text" name="contactNumber" required>

        <label>Flat Number</label>
        <input type="text" name="flatNumber" required>

        <label>Password</label>
        <input type="password" name="password" minlength="8" required>

        <label>Confirm Password</label>
        <input type="password" name="confirmPassword" minlength="8" required>

        <button type="submit">Register</button>

    </form>

    <div class="links">
        <p>Already have an account?</p>
        <a href="${pageContext.request.contextPath}/">
            Login Here
        </a>
    </div>

</div>

</body>
</html>
