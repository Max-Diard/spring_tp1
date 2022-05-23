<%@include file="parts/head.jsp" %>

<security:authorize access="isAuthenticated()">
    <h1>Bonjour <security:authentication property="principal.username" /></h1>
</security:authorize>

<%@include file="parts/footer.jsp" %>
