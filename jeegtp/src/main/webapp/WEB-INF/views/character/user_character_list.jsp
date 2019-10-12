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

    <!-- Stylesheet -->
    <link href="../../../css/index2.css" rel="stylesheet" type="text/css">

    <jsp:include page="../header.jsp"/>
</head>
<body>
<!-- Page section -->
<div class="main-page">
    <div class="text-center">
        <h1>Character List:</h1>q
        <c:choose>
            <c:when test="${character_list != null}">
                <ul>
                    <c:forEach items="${character_list}" var="character">
                        <h2>Name: ${character.name}</h2>
                        <div><a href="${pageContext.request.contextPath}/character/play/${character.id}">PLAY</a></div>
                        <li>Type: ${character.characterClass.type}</li>
                        <li>Lvl: ${character.lvl}</li>
                        <li>Health points: ${character.characterClass.healthPoints}</li>
                        <div><a href="${pageContext.request.contextPath}/character/delete/${character.id}">Delete</a>
                        </div>
                        <br>
                    </c:forEach>
                </ul>
            </c:when>
            <c:otherwise>
                ${none}
            </c:otherwise>
        </c:choose>
    </div>
</div>
</body>
</html>
