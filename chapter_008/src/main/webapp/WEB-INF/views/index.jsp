<%--
  Created by IntelliJ IDEA.
  User: ilux28
  Date: 18.07.2018
  Time: 0:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Титульная страница</title>
</head>
<body>
<table style="border: 1px solid rgba(123,123,123,0.6);" cellpadding="1" cellspacing="1" border="1">
    <th>Номер</th>
    <th>Имя</th>
    <th>Почта</th>
    <th>Пароль</th>
    <c:forEach items="${users}" var="user">
        <tr>
            <td><c:out value="${user.id}"></c:out></td>
            <td><c:out value="${user.name}"></c:out></td>
            <td><c:out value="${user.email}"></c:out></td>
            <td><c:out value="${user.password}"></c:out></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
