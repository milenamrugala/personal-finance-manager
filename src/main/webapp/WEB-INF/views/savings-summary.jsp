<%@ page import="java.time.LocalDate" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="/css/list-users.css">
    <link rel="stylesheet" type="text/css" href="/css/header.css">
    <link rel="stylesheet" type="text/css" href="/css/welcome-page.css">
    <title>PFM - Transaction Summary</title>
</head>
<body>

<header>
    <h1>Personal Finance Manager</h1>
    <div>
        <a href="/personal-finance-manager/homepage" class="button">Homepage</a>
        <a href="/personal-finance-manager/transactions-summary" class="button">Transactions summary</a>
        <a href="/personal-finance-manager/savings-summary" class="button">Savings summary</a>
        <a href="/personal-finance-manager/new-transaction" class="button">Add next transaction</a>
        <a href="/personal-finance-manager/list-transactions" class="button">View all transactions</a>
        <a href="/personal-finance-manager/new-saving" class="button">Add next savings goal</a>
        <a href="/personal-finance-manager/list-savings" class="button">View all savings goals</a>
        <a href="/personal-finance-manager/new-budget-plan" class="button">Add new budget plan</a>
        <a href="/personal-finance-manager/list-budget-plans" class="button">View all budget plans</a>
        <a href="/personal-finance-manager/logout" class="button">Log out</a>
    </div>
</header>
<br><br>

<h2>Total amount to save: ${totalToSave}</h2>
<br>
<h2>Amount to save each month: ${totalToSave/12}</h2>
<br>
<h2>Number of savings goals: ${numOfItems}</h2>



</body>
</html>