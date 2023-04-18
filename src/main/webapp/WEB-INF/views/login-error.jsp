<%--
  Created by IntelliJ IDEA.
  User: milenamrugala
  Date: 11/04/2023
  Time: 21:32
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="/css/header.css">
    <link rel="stylesheet" type="text/css" href="/css/simple-body.css">

    <title>Personal Finance Manager - Error</title>
</head>
<body>
<header>
    <h1>Personal Finance Manager</h1>
</header>
<h2>Sorry! Login details submission failed. Please make sure your email and password are correct.</h2>
<a href="<c:url value='/personal-finance-manager/login'/>" class="button">Try again</a>
</body>
</html>