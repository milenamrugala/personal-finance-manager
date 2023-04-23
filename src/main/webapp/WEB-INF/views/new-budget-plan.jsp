<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Personal Finance Manager</title>
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

<%--@elvariable id="budgetPlan" type="pl.milenamrugala.personalfinancemanager.entity"--%>
<form action="" method="post">

    <label for="name">Budget Plan Name:</label>
    <input type="text" id="name" name="name" placeholder="e.g. Budget Plan April 2023" required><br>

    <label for="description">Description:</label>
    <input type="text" id="description" name="description" placeholder="e.g. Family incomes and expenses in April" required><br>

    <label for="startDate">Start Date:</label>
    <input type="date" id="startDate" name="startDate" required><br><br>

    <label for="endDate">End Date:</label>
    <input type="date" id="endDate" name="endDate" required><br><br>

      <label for="incomeTransactions">Income Transactions:</label>
      <select multiple id="incomeTransactions" name="incomeTransactions">
          <c:forEach var="transaction" items="${transactions}">
              <c:if test="${transaction.type == 'INCOME'}">
                  <option value="${transaction.id}"> TRANSACTION: ${transaction.description} CATEGORY: ${transaction.category}</option>
              </c:if>
          </c:forEach>
      </select><br><br>
      <label for="expenseTransactions">Expense Transactions:</label>
      <select multiple id="expenseTransactions" name="expenseTransactions">
          <c:forEach var="transaction" items="${transactions}">
              <c:if test="${transaction.type == 'EXPENSE'}">
                  <option value="${transaction.id}"> TRANSACTION: ${transaction.description} CATEGORY: ${transaction.category}</option>
              </c:if>
          </c:forEach>
      </select><br><br>

    <input type="submit" value="Create New Budget Plan">
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
