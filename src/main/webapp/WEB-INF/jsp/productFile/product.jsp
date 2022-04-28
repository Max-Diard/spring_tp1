<%@include file="../parts/head.jsp" %>

<div class="d-flex flex-column align-items-center fst-italic">
    <h2 class="m-3">${product.name}</h2>
    <div class="card img-product" style="width: 18rem">
        <img src="${product.picture}" alt="${product.name} en image">
        <div class="text-center mt-1">Quantit&eacute; : ${product.quantity}</div>
        <div class="text-center mt-1">${product.price} &euro;</div>
    </div>
    <p class="mt-3">${product.description}</p>
</div>

<%@include file="../parts/footer.jsp"%>