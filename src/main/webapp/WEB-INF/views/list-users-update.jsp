<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Personal Finance Manager - User Update Form</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="/css/header.css">
    <link rel="stylesheet" type="text/css" href="/css/registration.css">
</head>
<body>

<header>
    <h1>Personal Finance Manager</h1>
    <div>
        <a href="/personal-finance-manager/homepage" class="button">Homepage</a>
        <a href="/personal-finance-manager/logout" class="button">Log out</a>
        <a href="/personal-finance-manager/list-users" class="button">Cancel</a>
    </div>
</header>

<form action="" method="POST">
    <h2>User Update</h2>

    <label for="firstname">First name:</label>
    <input type="text" id="firstname" name="firstName" required>

    <label for="lastname">Last name:</label>
    <input type="text" id="lastname" name="lastName" required>

    <label for="email">Email:</label>
    <input type="email" id="email" name="email" required>

    <label for="password">Password:</label>
    <input type="password" id="password" name="password" required>

    <label for="repeat-password">Repeat Password:</label>
    <input type="password" id="repeat-password" name="repeat-password" required>

    <input type="submit" value="Update">

</form>
</body>
</html>
