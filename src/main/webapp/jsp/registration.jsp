<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="../css/style.css">

    <script src="../js/registrationPage.js"></script>

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

    <div class="position-center">
        <input id="name" type="text" name="name" placeholder="name" required/>
    </div>

    <div class="position-center">
        <input id="login" type="text" name="login" placeholder="login" required/>
    </div>

    <div class="position-center">
        <input id="password" type="password" name="password" placeholder="password" required/>
    </div>

    <div class="position-center">
        <input id="confirmPassword" type="password" name="confirmPassword" placeholder="confirmPassword"
               oninput="validateConfirm()" required/>
    </div>
    <div class="position-center">
        <input type="submit" id="submit" value="ok"/>
    </div>

    <div class="position-center">

        <h2 hidden class="error-message" id="error-message"> passwords do not match1</h2>


        <c:if test="${registrationError}">
            <h2 class="error-message"> passwords do not match</h2>
        </c:if>


    </div>
</form>

<div class="footer">
    <h1>lego store</h1>
</div>

</body>
</html>
