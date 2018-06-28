<%@ page import="pribytkovi.servlets.User" %>
<%@ page import="pribytkovi.servlets.UserStorage" %>
<%@ page contentType="text/html;charset=UTF-8" language= "java" pageEncoding="ISO-8859-5" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Главная страница JSP</title>
</head>
<form action="${pageContext.servletContext.contextPath}/" method="post">
    Action: <input type=text' name='action'/></br>
    ID :    <input type=text' name='id'/></br>
    Name :  <input type=text' name='name'/></br>
    Email : <input type=text' name='email'/>
    <input type='submit'>
</form>
<table style="border: 1px solid black;" cellpadding="1" cellspacing="1" border="1">
    <th>Номер</th>
    <th>Имя</th>
    <th>Почта</th>
<c:forEach items="${users}" var="user">
<tr>
    <td><c:out value="${user.id}"></c:out></td>
    <td><c:out value="${user.name}"></c:out></td>
    <td><c:out value="${user.email}"></c:out></td>
</tr>
</c:forEach>
</table>
<h1>Ogogo</h1>
</body>
</html>
