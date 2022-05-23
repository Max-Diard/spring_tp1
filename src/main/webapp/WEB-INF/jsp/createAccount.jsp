<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="parts/head.jsp" %>

<h2 class="text-center">Créer un compte</h2>
<div class="m-auto">
    <form:form cssClass="d-flex flex-column align-items-center" action="create-by-form" method="post" modelAttribute="account">
        <form:label path="username">Username: </form:label>
        <form:input type="text" path="username"/>
        <form:errors path="username" cssClass="error" />

        <form:label path="password">Mot de passe: </form:label>
        <form:input type="text" path="password"/>
        <form:errors path="password" cssClass="error" />

        <input class="btn btn-secondary mt-2" type="submit" value="Envoyer"/>
    </form:form>
</div>

<%@include file="parts/footer.jsp" %>
