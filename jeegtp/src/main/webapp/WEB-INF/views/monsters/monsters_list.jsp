<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: teos
  Date: 28.09.2019
  Time: 12:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Monster list</title>
    <jsp:include page="../header.jsp"/>
</head>
<body>
<h1>Monsters</h1>
<table>
    <th>
    <th>Name</th>
    <th>Health Points</th>
    <th>Armour</th>
    <th>Damage Points</th>
    <th>Attack Speed</th>
    <th>Experience Points</th>

    <tbody>
    <c:forEach items="${monster-list}" var="monster">
        <tr>
            <td>${monster.name}</td>
            <td>${monster.healthPoints}</td>
            <td>${monster.armour}</td>
            <td>${monster.damagePoints}</td>
            <td>${monster.AttackSpeed}</td>
            <td>${monster.experiencePoints}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
