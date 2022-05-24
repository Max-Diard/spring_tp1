<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="../parts/head.jsp" %>

<h2 class="text-center">Ajout d'un produit</h2>
<div class="m-auto">

<form:form cssClass="d-flex flex-column align-items-center" action="create_by_form" method="post" modelAttribute="product">
    <form:label path="name">Nom: </form:label>
    <form:input type="text" path="name"/>
    <form:errors path="name" cssClass="error" />

    <form:label path="description">Description:</form:label>
    <form:input path="description"/>
    <form:errors path="description" cssClass="error" />

    <form:label path="price">Prix: </form:label>
    <form:input type="number" path="price"/>
    <form:errors path="price" cssClass="error" />

    <form:label path="picture">Photo: </form:label>
    <form:input type="text" path="picture"/>
    <form:errors path="picture" cssClass="error" />

    <form:label path="quantity">Quantit&eacute;: </form:label>
    <form:input type="number" path="quantity"/>
    <form:errors path="quantity" cssClass="error" />

    <input class="btn btn-secondary mt-2" type="submit" value="Envoyer"/>
</form:form>
</div>
<%@include file="../parts/footer.jsp" %>