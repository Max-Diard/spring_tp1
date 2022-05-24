<%@include file="parts/head.jsp" %>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<c:if test="${param.error != null}">
    <p>Invalid username or password</p>
</c:if>

<h2 class="text-center">Login</h2>
<div class="m-auto">
    <form:form name="f" cssClass="d-flex flex-column align-items-center" action="login" method="post">
        <label for="username">Username: </label>
        <input type="text" name="username" id="username" required/>
<%--        <form:errors path="username" cssClass="error" />--%>

        <label for="password">Mot de passe: </label>
        <input type="text" name="password" id="password" required/>
<%--        <form:errors path="password" cssClass="error" />--%>

        <input class="btn btn-secondary mt-2" type="submit" value="Envoyer"/>
    </form:form>
</div>



<%@include file="parts/footer.jsp" %>