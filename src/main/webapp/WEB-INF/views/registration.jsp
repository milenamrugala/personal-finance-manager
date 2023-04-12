<%--
  Created by IntelliJ IDEA.
  User: milenamrugala
  Date: 11/04/2023
  Time: 17:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Personal Finance Manager - User Registration Form</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="/css/header.css">
    <link rel="stylesheet" type="text/css" href="/css/registration.css">
</head>
<body>

<header>
    <h1>Personal Finance Manager</h1>
</header>

<form action="" method="POST">
    <h2>User Registration</h2>

    <label for="firstname">First name:</label>
    <input type="text" id="firstname" name="firstname" required>

    <label for="lastname">Last name:</label>
    <input type="text" id="lastname" name="lastname" required>

    <label for="email">Email:</label>
    <input type="email" id="email" name="email" required>

    <label for="password">Password:</label>
    <input type="password" id="password" name="password" required>

    <label for="repeat-password">Repeat Password:</label>
    <input type="password" id="repeat-password" name="repeat-password" required>

    <input type="submit" value="Register">

    <p>Already have an account? <a href="/personal-finance-manager/login">Click here</a>.</p>

</form>
</body>
</html>
