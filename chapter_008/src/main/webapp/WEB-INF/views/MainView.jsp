<%--
  Created by IntelliJ IDEA.
  User: ilux28
  Date: 12.07.2018
  Time: 22:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Главная страница</title>
</head>
<body>
    <form action="${pageContext.servletContext.contextPath}/signin" method="post">
        <input type='submit' value="Войти">
    </form>
    <form action="${pageContext.servletContext.contextPath}/signin" method="post">
       <input type='submit' value="Зарегистрироваться">
    </form>
 </body>
</html>