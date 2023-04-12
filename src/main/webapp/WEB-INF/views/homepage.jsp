<%--
  Created by IntelliJ IDEA.
  User: milenamrugala
  Date: 11/04/2023
  Time: 18:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Personal Finance Manager - Homepage</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="/css/header.css">
    <link rel="stylesheet" type="text/css" href="/css/homepage.css">
    <link rel="stylesheet" type="text/css" href="/css/sidebar.css">
</head>
<body>

<header>
    <h1>Personal Finance Manager</h1>
    <div>
        <a href="/personal-finance-manager/my-profile" class="button">My profile</a>
        <a href="/personal-finance-manager/logout" class="button">Log out</a>
    </div>
</header>

<div class="container">
    <div class="row">
        <div class="box">
            <a href="/personal-finance-manager/new-expense-type">New expense type</a>
        </div>
        <div class="box">
            <a href="/personal-finance-manager/all-expense-types">My expense types</a>
        </div>
        <div class="box">
            <a href="/personal-finance-manager/new-income-type">New income type</a>
        </div>
    </div>
    <div class="row">
        <div class="box">
            <a href="/personal-finance-manager/all-income-types">My income types</a>
        </div>
        <div class="box">
            <a href="/personal-finance-manager/new-budget-plan">New budget plan</a>
        </div>
        <div class="box">
            <a href="/personal-finance-manager/all-budget-plans">My budget plans</a>
        </div>
    </div>
</div>
</body>
</html>
