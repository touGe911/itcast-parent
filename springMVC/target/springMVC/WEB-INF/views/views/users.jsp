<%--
  Created by IntelliJ IDEA.
  User: touGe
  Date: 2018/1/12
  Time: 19:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSTL Demo</title>
</head>
<body>
<table cellpadding=0 cellspacing=0 border="1"  style="width: 80%">
    <thead>
    <tr>
        <th>ID</th>
        <th>UserName</th>
        <th>Name</th>
        <th>Age</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${userList}" var="user" >
        <tr>
            <td>${user.id}</td>
            <td>${user.userName}</td>
            <td>${user.name}</td>
            <td>${user.age}</td>
        </tr>
    </c:forEach>

    </tbody>
</table>
</body>
</html>

