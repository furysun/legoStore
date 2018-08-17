<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <c:set var="app" value="${pageContext.request.contextPath}"/>

    <title>Hi</title>
</head>
<body>

<form action="${app}/controller" method="post">
    <input type="hidden" name="action" value="LOGIN">
    Hello user <3
</form>
</body>
</html>