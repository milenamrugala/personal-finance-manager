<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: milenamrugala
  Date: 11/04/2023
  Time: 21:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="/css/header.css">
    <link rel="stylesheet" type="text/css" href="/css/simple-body.css">
    <title>Personal Finance Manager - Success</title>
</head>
<body>
<header>
    <h1>Personal Finance Manager</h1>
</header>
<h2>Congratulations! Registration is successful.</h2>
<a href="<c:url value='/personal-finance-manager/login'/>" class="button">Login</a>
</body>
</html>
