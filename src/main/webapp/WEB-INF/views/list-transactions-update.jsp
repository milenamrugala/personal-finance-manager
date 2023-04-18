<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Personal Finance Manager - Add New Transaction</title>
    <link rel="stylesheet" type="text/css" href="/css/header.css">
    <link rel="stylesheet" type="text/css" href="/css/registration.css">
    <link rel="stylesheet" type="text/css" href="/css/sidebar.css">
</head>
<body>

<header>
    <h1>Personal Finance Manager</h1>
    <div>
        <a href="/personal-finance-manager/my-profile" class="button">My profile</a>
        <a href="/personal-finance-manager/list-transactions" class="button">Cancel</a>
        <a href="/personal-finance-manager/logout" class="button">Log out</a>
    </div>
</header>

<%--@elvariable id="transaction" type="pl.milenamrugala.personalfinancemanager.entity"--%>
<form:form action="" method="POST" modelAttribute="transaction">

    <label for="category">Transaction category:</label>
    <form:input path="category"/>

    <br>
    <label for="description">Description of transaction (expense or income):</label>
    <form:input path="description"/>

    <br>
    <label for="type">Type:</label>
    <select id="type" name="type">
        <option value="INCOME">Income</option>
        <option value="EXPENSE">Expense</option>
    </select>
    <br><br>
    <input type="submit" value="Submit">
</form:form>

</body>
</html>