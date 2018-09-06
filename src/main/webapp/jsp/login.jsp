<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="../css/style.css">

    <script src="../js/loginPage.js"></script>

    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <c:set var="app" value="${pageContext.request.contextPath}"/>

    <title>login</title>
</head>
<body>
<div class="header">
    <h1>login</h1>
</div>

<form action="${app}/controller" method="post">
    <input type="hidden" name="command" value="LOGIN">
    <div class="position-center">
        <input id="login" type="text" name="login" placeholder="login" required/>
    </div>
    <div class="position-center">
        <input id="password" type="password" name="password" placeholder="password" required/>
    </div>

    <div class="position-center">
        <input type="submit"<%-- onclick="test()"--%> value="ok"/>
    </div>
</form>

<c:if test="${loginError}">
    <h2 style="color: red"> invalid login or password </h2>
</c:if>


<div class="footer">
    <h1>lego store</h1>
</div>

</body>

</html>
