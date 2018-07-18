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
    <c:if test="${name != ''}">

        <c:out value="${name}">
            <h1>Привет vaLUE</h1>
        </c:out>
        </c:if>
    <c:if test="${error != ''}">
        <div style="background-color: #c9ff79">
            <c:out value="${error}">
        </c:out>
    </c:if>
        <form action="${pageContext.servletContext.contextPath}/signin" method="post">
            Name :  <input type=text' name='name'/></br>
            Password : <input type=text' name='password'/>
            <input type='submit'>
        </form>
    </body>
</html>