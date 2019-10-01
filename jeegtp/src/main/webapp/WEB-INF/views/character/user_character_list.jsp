<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: teos
  Date: 01.10.2019
  Time: 13:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Your character List</title>
    <jsp:include page="../header.jsp"/>
</head>
<body>
<h2>Character List:</h2>
<br>
<ul>
<c:forEach items="${character_list}" var="character">
    <h1>Name: ${character.name}</h1><div><a href="${pageContext.request.contextPath}/character/play/${character.id}">PLAY</a></div>
    <li>Type: ${character.characterClass.type}</li>
    <li>Lvl: ${character.lvl}</li>
    <li>Health points: ${character.characterClass.healthPoints}</li>
    <div><a href="${pageContext.request.contextPath}/character/delete/${character.id}">Usun</a></div>
    <br>

</c:forEach>
</ul>
</body>
</html>
