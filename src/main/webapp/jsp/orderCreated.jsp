<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
    <link rel="stylesheet" type="text/css" href="../css/style.css">

    <title>registration</title>
</head>

<body>
<div class="header">
    <h1>Order create</h1>
</div>

<form action="${app}/controller" method="get">
    <input type="hidden" name="command" value="GET_ITEMS"/>

    <input type="submit" value="OK"/>
</form>

<div class="footer">
    <h1>lego store</h1>
</div>

</body>

</html>