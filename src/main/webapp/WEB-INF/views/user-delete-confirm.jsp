<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="/css/header.css">

    <title>Confirmation</title>
</head>
<body>

<header>
    <h1>Personal Finance Manager</h1>
</header>
<h2>Are you sure you want to delete this user?</h2>
<a href="<c:url value="/personal-finance-manager/list-users/delete?id=${id}"/>" class="button">Delete</a>
<a href="<c:url value='/personal-finance-manager/list-users'/>" class="button">Cancel</a>
</body>
</html>