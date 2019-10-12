<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: teos
  Date: 11.10.2019
  Time: 17:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Change login</title>

    <!-- Stylesheet -->
    <link href="../../../css/index2.css" rel="stylesheet" type="text/css">


    <jsp:include page="../header.jsp"/>
</head>
<body>
<!-- Page section -->
<div class="main-page">

    <form:form modelAttribute="new_user_login" method="post" class="text-center">

        <p class="h4 mb-4">Change login</p>

        <div class="form-row mb-4">

            <div class="col">
                <!-- Login -->
                <div class="form-control">
                    Login: ${user_data.login}
                </div>
                <form:input path="login" type="login" id="registerFormLogin" class="form-control" placeholder="New login"/>
                <form:errors path="login"/>
            </div>
        </div>

        <button class="btn btn-info my-4 btn-block" type="submit">Change</button>

    </form:form>
</div>
</body>
</html>
