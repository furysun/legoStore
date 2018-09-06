<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="app" value="${pageContext.request.contextPath}"/>

<link rel="stylesheet" type="text/css" href="css/style.css">

<div class="header">
    <h1>entrance</h1>
</div>

<div class="position-center">
<form class="center" action="${app}/controller" method="get">
    <input type="hidden" name="command" value="GO_TO_LOGIN">
    <input id="log"type="submit" value="login"/>
</form>
</div>

<div class="position-center">
<form action="${app}/controller" method="get">
    <input type="hidden" name="command" value="GO_TO_REGISTRATION">
    <input id="reg" type="submit" value="Registration"/>
</form>
</div>
<div class="footer">
    <h1>lego store</h1>
</div>