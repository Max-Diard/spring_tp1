<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="../../../resources/css/bootstrap.css">
    <link rel="stylesheet" href="../../../resources/css/styles.css">
    <meta charset="UTF-8">
    <title>Produits Satisfactory</title>
</head>
<body class="bg-light">

<header>
    <nav class="navbar navbar-expand-lg navbar-warning bg-warning justify-content-between">
        <div class="navbar-nav">
            <a class="nav-link" style="color: indigo" href="/">Home</a>
            <a class="nav-link" style="color: indigo" href="/products">All Products</a>
        </div>
        <div class="navbar-nav">
            <security:authorize access="isAuthenticated()">
                <a class="nav-link" style="color: indigo" href="account/my-account">Mon compte</a>
                <a class="nav-link" style="color: indigo" href="logout">Logout</a>
            </security:authorize>
            <security:authorize access="!isAuthenticated()">
                <a class="nav-link" style="color: indigo" href="/account/create">Créer un compte</a>
                <a class="nav-link" style="color: indigo" href="/login">Connexion</a>
            </security:authorize>
        </div>
    </nav>
</header>