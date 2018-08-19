<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <c:set var="app" value="${pageContext.request.contextPath}"/>

    <title>login</title>
</head>
<body>

<form action="${app}/controller" method="post">
    <input type="hidden" name="command" value="LOGIN">

    login:
    <input type="text" name="login"/>
    password:
    <input type="password" name="password"/>

    <input type="submit" value="ok"/>
</form>

<c:if test="${error}">
    <h2 style="color: red"> invalid login or password </h2>
</c:if>

</body>
</html>
