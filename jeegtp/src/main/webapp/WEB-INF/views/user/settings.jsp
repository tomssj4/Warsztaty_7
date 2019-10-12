<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: teos
  Date: 11.10.2019
  Time: 17:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Settings</title>

    <!-- Stylesheet -->
    <link href="../../../css/index2.css" rel="stylesheet" type="text/css">

    <jsp:include page="../header.jsp"/>
</head>character_list
<body>
<!-- Page section -->
<div class="main-page">
    <div class="text-center">
        <p>Change login:</p>
        <button type="button" class="btn btn-secondary"
                onclick="window.location.href = '${pageContext.request.contextPath}/user/settings/login'">Change
        </button>
    </div>
    <div class="text-center">
        <p>Change email:</p>
        <button type="button" class="btn btn-secondary"
                onclick="window.location.href = '${pageContext.request.contextPath}/user/settings/email'">Change
        </button>
    </div>
    <div class="text-center">
        <p>Change password: </p>
        <button type="button" class="btn btn-secondary"
                onclick="window.location.href = '${pageContext.request.contextPath}/user/settings/password'">Change
        </button>
    </div>
    <div class="text-center">
        <p>Delete account.</p>
        <button type="button" class="btn btn-danger"
                onclick="window.location.href = '${pageContext.request.contextPath}/user/settings/delete'">DELETE
        </button>
    </div>
</div>

</body>
</html>
