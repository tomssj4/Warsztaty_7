<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: teos
  Date: 11.10.2019
  Time: 18:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Change email</title>

    <!-- Stylesheet -->
    <link href="../../../css/index2.css" rel="stylesheet" type="text/css">

    <jsp:include page="../header.jsp"/>
</head>
<body>
<!-- Page section -->
<div class="main-page">
    <form:form modelAttribute="new_user_email" method="post" class="text-center">

        <p class="h4 mb-4">Change email</p>

        <div class="form-control mb-4">
            Email: ${user_data.email}
        </div>
        <form:input path="email" id="registerFormEmail" class="form-control mb-4" placeholder="New email"/>
        <form:errors path="email"/>

        <button class="btn btn-info my-4 btn-block" type="submit">Change</button>

    </form:form>
</div>
</body>
</html>
