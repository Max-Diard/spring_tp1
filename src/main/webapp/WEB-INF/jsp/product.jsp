<jsp:useBean id="product" scope="request" type="fr.boutique.eboutique.model.Product"/>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="parts/head.jsp" />

<jsp:include page="parts/header.jsp" />

<div class="d-flex justify-content-center align-items-center">
    <h2>${product.name}</h2>
    <img src="${product.picture}" alt="${product.name} en image">
    <p class="">${product.description}</p>
</div>

<jsp:include page="parts/footer.jsp" />