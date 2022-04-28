<%@include file="../parts/head.jsp" %>

<a class="link-info" href="products/add">Ajouter un produit</a>

<div class="all-product-content">
<c:forEach items="${products}" var="p">
    <div class="card m-3 img-product" >
        <img src="${p.picture}" class="card-img-top m-auto w-50" alt="${p.name} en image">
        <div class="card-body d-flex flex-column">
            <div class="d-flex justify-content-between">
                <h5 class="card-title">${p.name}</h5>
                <p>${p.price} &euro;</p>
            </div>
            <div class="d-flex flex-column">
                <a href="products/${p.id}" class="btn btn-primary align-self-center mb-2">Voir le produit</a>
                <a href="products/delete/${p.id}" class="btn btn-danger align-self-center">Supprimer le produit</a>
            </div>
        </div>
    </div>
</c:forEach>
</div>
<%@include file="../parts/footer.jsp" %>