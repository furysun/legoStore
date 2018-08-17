<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="app" value="${pageContext.request.contextPath}"/>

<form action="${app}/controller" method="get">
    <input type="hidden" name="command" value="GO_TO_LOGIN">
    <input type="submit" value="login"/>
</form>

<form action="${app}/controller" method="get">
    <input type="hidden" name="command" value="GO_TO_REGISTRATION">
    <input type="submit" value="Registration"/>
</form>