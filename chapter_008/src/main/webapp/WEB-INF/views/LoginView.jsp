<%--
  Created by IntelliJ IDEA.
  User: ilux28
  Date: 04.07.2018
  Time: 20:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Login View</title>
</head>
    <body>
    <c:if test="${error != ''}">
        <div style="background-color: red">
            <c:out value="${error}">
        </c:out>
        <form action="${pageContext.servletContext.contextPath}/" method="post">
               <input type='submit' name="Зарегаться">
                </form>
    </c:if>
        <form action="${pageContext.servletContext.contextPath}/signin" method="post">
            Name :  <input type=text' name='name'/></br>
            Password : <input type=text' name='password'/>
            <input type='submit'>
        </form>
    </body>
</html>