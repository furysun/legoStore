<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <c:set var="app" value="${pageContext.request.contextPath}"/>

    <title>login</title>
</head>
<body>

<div class="header">
    <h1>Registration</h1>
</div>

<form action="${app}/controller" method="post">
    <input type="hidden" name="command" value="REGISTRATION">
    name:
    <input type="text" name="name"/>

    login:
    <input type="text" name="login"/>
    password:
    <input type="password" name="password"/>

    Confirm password:
    <input type="password" name="confirmPassword"/>
    <input type="submit" value="ok"/>

</form>
<c:if test="${error}">
    <h2 style="color: red"> passwords do not match</h2>
</c:if>


<div class="footer">
    <h1>lego store</h1>
</div>

</body>
</html>
