
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="app" value="${pageContext.request.contextPath}"/>

<html>
<head>
    <link rel="stylesheet" type="text/css" href="../css/style.css">

    <title>items</title>
</head>
<body>

<div class="header">
    <h1>Items</h1>
</div>

<table>
    <tr>
        <th>name</th>
        <th>price</th>
    </tr>

    <c:forEach items="${items}" var="item">
        <tr>
            <td class="color" > <c:out value="${item.name}"/></td>
            <td class="price_color"> <c:out value="${item.price}"/>$</td>
        </tr>
    </c:forEach>
</table>


<div class="footer">
    <h1>lego store</h1>
</div>


</body>
</html>
