<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>
<h1>ça marche les products</h1>
<jsp:useBean id="products" scope="request" type="java.util.List"/>
<c:forEach items="${products}" var="product">
    <div>
        <p>${product.name}</p>
    </div>
</c:forEach>
</body>
</html>