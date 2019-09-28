<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: teos
  Date: 15.09.2019
  Time: 14:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
            integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
            integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
            integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
            crossorigin="anonymous"></script>
    <script src="https://kit.fontawesome.com/a0b22afb83.js"></script>

    <title>Logowanie</title>
</head>
<body>
<form method="post" action="/login" class="text-center border border-light p-5">

    <c:if test="${not empty errorMessge}">
        <div style="color:red; font-weight: bold; margin: 30px 0px;">${errorMessge}</div>
    </c:if>

    <p class="h4 mb-4">Login</p>

    <!-- Login -->
    <input type="text" name="login" id="loginFormLogin" class="form-control mb-4" placeholder="Login"/>

    <!-- Password -->
    <input type="password" name="password" id="loginFormPassword" class="form-control mb-4" placeholder="Password"/>

    <div class="d-flex justify-content-around">
        <div>
            <!-- Remember me -->
            <div class="custom-control custom-checkbox">
                <input type="checkbox" class="custom-control-input" id="defaultLoginFormRemember">
                <label class="custom-control-label" for="defaultLoginFormRemember">Remember me</label>
            </div>
        </div>
        <%--        <div>--%>
        <%--            <!-- Forgot password -->--%>
        <%--            <a href="">Forgot password?</a>--%>
        <%--        </div>--%>
    </div>

    <!-- Sign in button -->
    <button class="btn btn-info btn-block" type="submit">Login</button>

    <%--    <div class="text-center">--%>
    <p>Not a member?
        <a href="/register">Register</a>
    </p>

    <%--        <p>or login with:</p>--%>
    <%--        <a type="button" class="light-blue-text mx-2">--%>
    <%--            <i class="fab fa-facebook-f"></i>--%>
    <%--        </a>--%>
    <%--        <a type="button" class="light-blue-text mx-2">--%>
    <%--            <i class="fab fa-twitter"></i>--%>
    <%--        </a>--%>
    <%--        <a type="button" class="light-blue-text mx-2">--%>
    <%--            <i class="fab fa-linkedin-in"></i>--%>
    <%--        </a>--%>
    <%--        <a type="button" class="light-blue-text mx-2">--%>
    <%--            <i class="fab fa-github"></i>--%>
    <%--        </a>--%>
    <%--    </div>--%>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form>
</body>
</html>
