<jsp:useBean id="product" scope="request" type="fr.boutique.eboutique.model.Product"/>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="parts/head.jsp" />

<jsp:include page="parts/header.jsp" />

<div class="text-center fst-italic">
    <h2 class="m-3">${product.name}</h2>
    <img class="img-product" src="${product.picture}" alt="${product.name} en image">
    <p class="mt-3">${product.description}</p>
</div>

<jsp:include page="parts/footer.jsp" />