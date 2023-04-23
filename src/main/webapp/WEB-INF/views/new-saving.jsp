<%@ page import="java.time.LocalDate" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <a href="/personal-finance-manager/homepage" class="button">Homepage</a>
        <a href="/personal-finance-manager/my-profile" class="button">My profile</a>
        <a href="/personal-finance-manager/logout" class="button">Log out</a>
    </div>
</header>

<form action="" method="post">

    <label for="category">Savings goal category:</label>
    <input type="text" id="category" name="category" placeholder="e.g. Home, Transport, Health." required>

    <br>
    <label for="description">Description of savings goal:</label>
    <input type="text" id="description" name="description" placeholder="e.g. New Car for Transport category." required>

    <label for="amount">Amount:</label>
    <input type="number" id="amount" name="amount" placeholder="Here provide amount" required>
    <br><br>

    <label for="start_date">Start date for savings goal:</label>
    <input type="date" id="start_date" name="start_date" required><br><br>

    <label for="end_date">End date for savings goal:</label>
    <input type="date" id="end_date" name="end_date" required><br><br>

    <input type="submit" value="Submit">
</form>

<div class="sidebar">
    <ul>
        <li><a href="/personal-finance-manager/new-transaction">Add new transaction</a></li>
        <li><a href="/personal-finance-manager/list-transactions">View all transactions</a></li>
        <li><a href="/personal-finance-manager/transactions-summary">Transactions summary</a></li>
        <li><a href="/personal-finance-manager/new-saving">Add new savings goal</a></li>
        <li><a href="/personal-finance-manager/list-savings">View all savings goal</a></li>
        <li><a href="/personal-finance-manager/savings-summary">Savings summary</a></li>
        <li><a href="/personal-finance-manager/new-budget-plan">Add new budget plan</a></li>
        <li><a href="/personal-finance-manager/list-budget-plans">View all budget plans</a></li>
        <li><a href="/personal-finance-manager/list-users">View all users</a></li>
    </ul>
</div>
</body>
</html>