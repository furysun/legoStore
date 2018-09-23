<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="../css/style.css">

    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <c:set var="app" value="${pageContext.request.contextPath}"/>

    <title>Hi</title>
</head>
<body>
<div class="header">
    <h1>Hi</h1>
</div>

<form action="${app}/controller" method="post">
    <input type="hidden" name="action" value="LOGIN">
    Hello user <3
</form>

<div class="footer">
    <h1>lego store</h1>
</div>

</body>
</html>