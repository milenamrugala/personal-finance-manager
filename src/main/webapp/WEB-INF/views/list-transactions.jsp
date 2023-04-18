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
    <title>PFM - Transaction List</title>
</head>
<body>
<header>
    <h1>Personal Finance Manager</h1>
    <div>
        <a href="/personal-finance-manager/homepage" class="button">Homepage</a>
        <a href="/personal-finance-manager/new-transaction" class="button">Add next transaction</a>
        <a href="/personal-finance-manager/logout" class="button">Log out</a>
    </div>
</header>
<table>
    <thead>
    <tr>
        <th>Id</th>
        <th>Category</th>
        <th>Description</th>
        <th>Type</th>
        <th>Update</th>
        <th>Delete</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="transaction" items="${transactions}">
        <tr>
            <td><c:out value="${transaction.id}"/></td>
            <td><c:out value="${transaction.category}"/></td>
            <td><c:out value="${transaction.description}"/></td>
            <td><c:out value="${transaction.type}"/></td>
            <td>
                <a href="/personal-finance-manager/list-transactions/update?id=${transaction.id}" class="button">Update</a>
            </td>
            <td>
                <a href="/personal-finance-manager/list-transactions/delete-confirm?id=${transaction.id}" class="button">Delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>