<jsp:include page="parts/head.jsp" />

<jsp:include page="parts/header.jsp" />

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:useBean id="products" scope="request" type="java.util.List"/>

<div class="d-flex justify-content-center flex-row align-items-center m-2">
<c:forEach items="${products}" var="product">
    <div class="card m-3 img-product" style="width: 18rem;">
        <img src="${product.picture}" class="card-img-top " alt="${product.name} en image">
        <div class="card-body">
            <h5 class="card-title">${product.name}</h5>
            <a href="products/${product.id}" class="btn btn-primary">Voir le produit</a>
        </div>
    </div>
</c:forEach>
</div>
<jsp:include page="parts/footer.jsp" />