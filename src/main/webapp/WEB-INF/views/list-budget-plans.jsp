<%
    request.setCharacterEncoding("UTF-8");
    response.setCharacterEncoding("UTF-8");
%>
<%@ page language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="/css/list-users.css">
    <link rel="stylesheet" type="text/css" href="/css/header.css">
    <title>PFM - Transaction List</title>
</head>
<body>

<header>
    <h1>Personal Finance Manager</h1>
    <div>
        <a href="/personal-finance-manager/homepage" class="button">Homepage</a>
        <a href="/personal-finance-manager/transactions-summary" class="button">Summary</a>
        <a href="/personal-finance-manager/new-transaction" class="button">Add next transaction</a>
        <a href="/personal-finance-manager/logout" class="button">Log out</a>
    </div>
</header>

<h1>Budget Plan Details</h1>
<table>
    <tr>
        <td>Name:</td>
        <td>${budgetPlan.name}</td>
    </tr>
    <tr>
        <td>Description:</td>
        <td>${budgetPlan.description}</td>
    </tr>
    <tr>
        <td>Start Date:</td>
        <td><fmt:formatDate value="${budgetPlan.startDate}" pattern="yyyy-MM-dd"/></td>
    </tr>
    <tr>
        <td>End Date:</td>
        <td><fmt:formatDate value="${budgetPlan.endDate}" pattern="yyyy-MM-dd"/></td>
    </tr>
    <tr>
        <td>Amount:</td>
        <td>${budgetPlan.amount}</td>
    </tr>
    <tr>
        <td>Income Transactions:</td>
        <td>
            <ul>
                <c:forEach var="transaction" items="${budgetPlan.incomeTransactions}">
                    <li>${transaction.category} - ${transaction.amount}</li>
                </c:forEach>
            </ul>
        </td>
    </tr>
    <tr>
        <td>Expense Transactions:</td>
        <td>
            <ul>
                <c:forEach var="transaction" items="${budgetPlan.expenseTransactions}">
                    <li>${transaction.category} - ${transaction.amount}</li>
                </c:forEach>
            </ul>
        </td>
    </tr>
</table>
</body>
</html>