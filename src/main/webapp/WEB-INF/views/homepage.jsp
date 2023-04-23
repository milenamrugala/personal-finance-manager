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
        <div><%= request.getAttribute("loggedAs") %></div>
        <a href="/personal-finance-manager/my-profile" class="button">My profile</a>
        <a href="/personal-finance-manager/transactions-summary" class="button">Transactions summary</a>
        <a href="/personal-finance-manager/savings-summary" class="button">Savings summary</a>
        <a href="/personal-finance-manager/list-users" class="button">View all users</a>
        <a href="/personal-finance-manager/logout" class="button">Log out</a>
    </div>
</header>

<div class="container">
    <div class="row">
        <div class="box">
            <a href="/personal-finance-manager/new-transaction">Add new transaction</a>
        </div>
        <div class="box">
            <a href="/personal-finance-manager/list-transactions">View all transactions</a>
        </div>

        <div class="box">
            <a href="/personal-finance-manager/new-saving">Add new savings goal</a>
        </div>
        <div class="box">
            <a href="/personal-finance-manager/list-savings">View all savings goals</a>
        </div>


        <div class="box">
            <a href="/personal-finance-manager/new-budget-plan">Add new budget plan</a>
        </div>
        <div class="box">
            <a href="/personal-finance-manager/list-budget-plans">View all budget plans</a>
        </div>
    </div>
</div>
</body>
</html>
