<%@ page import="pribytkovi.servlets.User" %>
<%@ page import="pribytkovi.servlets.UserStorage" %>
<%@ page contentType="text/html;charset=UTF-8" language= "java" pageEncoding="ISO-8859-5" %>
<html>
<head>
    <title>������� �������� JSP</title>
</head>
<form action="<%=request.getContextPath()%>/echo" method="post">
    Action: <input type=text' name='action'/></br>
    ID :    <input type=text' name='id'/></br>
    Name :  <input type=text' name='name'/></br>
    Email : <input type=text' name='email'/>
    <input type='submit'>
</form>
<table style="border: 1p solid black;" cellpadding="1" cellspacing="1" border="1">
    <th>�����</th>
    <th>���</th>
    <th>�����</th>
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
