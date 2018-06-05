<%@ page import="pribytkovi.servlets.User" %>
<%@ page import="pribytkovi.servlets.UserStorage" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="ISO-8859-5" %>
<html>
<head>
    <title>Главная страница JSP</title>
</head>
<form action="<%=request.getContextPath()%>/" method="post">
    Action : <input type=text' name='action'/>
    ID : <input type=text' name='id'/>
    Name : <input type=text' name='name'/>
    Email : <input type=text' name='email'/>
    <input type='submit'>
</form>
<table>
    <th>Номер</th>
    <th>Имя</th>
    <th>Почта</th>
<% for (User user : UserStorage.getInstance().getUsers()) {%>
<tr>
    <td><%=user.getId()%></td>
    <td><%=user.getName()%></td>
    <td><%=user.getEmail()%></td>
</tr>
<% } %>
</table>
<h1>Ogogo</h1>
</body>
</html>
