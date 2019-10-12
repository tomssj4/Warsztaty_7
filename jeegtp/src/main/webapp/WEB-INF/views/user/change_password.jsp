<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: teos
  Date: 11.10.2019
  Time: 18:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Change password</title>

    <!-- Stylesheet -->
    <link href="../../../css/index2.css" rel="stylesheet" type="text/css">

    <jsp:include page="../header.jsp"/>
</head>
<body>
<!-- Page section -->
<div class="main-page">
    <form:form modelAttribute="new_user_password" method="post" class="text-center">

        <p class="h4 mb-4">Change password</p>

        <!-- Password -->
        <form:password path="password" id="password" class="form-control" placeholder="New password"
                       aria-describedby="registerFormPasswordHelpBlock"/>
        <form:errors path="password"/>
        <small id="registerFormPasswordHelpBlock" class="form-text text-muted mb-4">
            At least 8 characters
        </small>

        <!-- RePassword -->
        <form:password path="rePassword" id="rePassword" class="form-control" placeholder="RePassword"
                       aria-describedby="registerFormRePasswordHelpBlock"/>
        <form:errors path="rePassword"/>
        <small id="registerFormRePasswordHelpBlock" class="form-text text-muted mb-4">
            Must be the same as above!
        </small>

        <button class="btn btn-info my-4 btn-block" type="submit">Change</button>

    </form:form>
</div>
</body>
</html>
