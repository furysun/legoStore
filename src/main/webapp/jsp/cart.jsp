<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
    <link rel="stylesheet" type="text/css" href="../css/style.css">

    <title>registration</title>
</head>

<body>
<div class="header">
    <h1>Cart</h1>
</div>
<table>
    <c:forEach items="${items}" var="item">

        <tr>
            <td class="color"><c:out value="${item.name}"/></td>
            <td class="price_color"><c:out value="${item.price}"/>$</td>
        </tr>
    </c:forEach>
</table>

<form action="${app}/controller" method="get">
    <input type="hidden" name="command" value="GO_TO_CHECKOUT"/>
    <input type="submit" value="checkout"/>
</form>
total: <c:out value="${sum}"/>$


<div class="footer">
    <h1>lego store</h1>
</div>

</body>

</html>
