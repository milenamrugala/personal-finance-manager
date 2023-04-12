<%--
  Created by IntelliJ IDEA.
  User: milenamrugala
  Date: 11/04/2023
  Time: 20:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Personal Finance Manager - New Expense Category</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="/css/header.css">
    <link rel="stylesheet" type="text/css" href="/css/registration.css">
    <link rel="stylesheet" type="text/css" href="/css/sidebar.css">

</head>
<body>

<header>
    <h1>Personal Finance Manager</h1>
</header>

<form action="" method="POST">
    <h2>Expense Type</h2>

    <label for="expense-type">Add one new expense type:</label>
    <input type="text" id="expense-type" name="expense-type"
           placeholder="e.g: bank loan, credit loan, fuel bill etc." required>
    <input type="submit" value="Add">

</form>

<div class="sidebar">
    <ul>
        <li><a href="/personal-finance-manager/homepage">Homepage</a></li>
        <li><a href="/personal-finance-manager/new-expense-type">New expense type</a></li>
        <li><a href="/personal-finance-manager/all-expense-types">My expense types</a></li>
        <li><a href="/personal-finance-manager/new-income-type">New income type</a></li>
        <li><a href="/personal-finance-manager/all-income-types">My income types</a></li>
        <li><a href="/personal-finance-manager/new-budget-plan">New budget plan</a></li>
        <li><a href="/personal-finance-manager/all-budget-plans">My budget plans</a></li>
    </ul>
</div>

</body>
</html>
