<%
    request.setCharacterEncoding("UTF-8");
    response.setCharacterEncoding("UTF-8");
%>
<%@ page language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="/css/list-users.css">
    <link rel="stylesheet" type="text/css" href="/css/header.css">
    <title>PFM - Savings List</title>
</head>
<body>
<header>
    <h1>Personal Finance Manager</h1>
    <div>
        <a href="/personal-finance-manager/homepage" class="button">Homepage</a>
        <a href="/personal-finance-manager/transactions-summary" class="button">Transactions summary</a>
        <a href="/personal-finance-manager/savings-summary" class="button">Savings summary</a>
        <a href="/personal-finance-manager/new-transaction" class="button">Add next transaction</a>
        <a href="/personal-finance-manager/new-saving" class="button">Add next savings goal</a>
        <a href="/personal-finance-manager/new-budget-plan" class="button">Add new budget plan</a>
        <a href="/personal-finance-manager/logout" class="button">Log out</a>
    </div>
</header>
<table>
    <thead>
    <tr>
        <th>Id</th>
        <th>Category</th>
        <th>Description</th>
        <th>Amount</th>
        <th>Start date</th>
        <th>End date</th>
        <th>Update</th>
        <th>Delete</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="saving" items="${savings}">
        <tr>
            <td><c:out value="${saving.id}"/></td>
            <td><c:out value="${saving.category}"/></td>
            <td><c:out value="${saving.description}"/></td>
            <td><c:out value="${saving.amount}"/></td>
            <td><c:out value="${saving.start_date}"/></td>
            <td><c:out value="${saving.end_date}"/></td>
            <td>
                <a href="/personal-finance-manager/list-savings/update?id=${saving.id}" class="button">Update</a>
            </td>
            <td>
                <a href="/personal-finance-manager/list-savings/delete-confirm?id=${saving.id}" class="button">Delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>