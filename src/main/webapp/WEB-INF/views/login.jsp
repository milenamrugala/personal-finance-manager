<%--
  Created by IntelliJ IDEA.
  User: milenamrugala
  Date: 11/04/2023
  Time: 18:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Personal Finance Manager - User Login</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="/css/header.css">
    <link rel="stylesheet" type="text/css" href="/css/registration.css">
</head>
<body>

<header>
    <h1>Personal Finance Manager</h1>
</header>

<form action="" method="POST">

    <h2>User Login</h2>

    <label for="email">Email:</label>
    <input type="email" id="email" name="email" required>

    <label for="password">Password:</label>
    <input type="password" id="password" name="password" required>

    <input type="submit" value="Log in">

    <p>Sign up and create a new account - <a href="/personal-finance-manager/registration">Click here</a>.</p>

</form>
</body>
</html>
