<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
<%--@elvariable id="user" type="pl.milenamrugala.personalfinancemanager.entity"--%>
<form:form action="" method="POST" modelAttribute="user">
    <h2>User Update</h2>

    <label>First name:</label>
    <form:input path="firstName"/>

    <label>Last name:</label>
    <form:input path="lastName"/>

    <label>Email:</label>
    <form:input path="email"/>

    <label>Password:</label>
    <form:input path="password"/>

    <label>Repeat password:</label>
    <form:input path="repeatPassword"/>

    <input type="submit" value="Update">

</form:form>
</body>
</html>
