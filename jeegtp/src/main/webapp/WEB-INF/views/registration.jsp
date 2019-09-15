<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: teos
  Date: 01.09.2019
  Time: 12:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    <script src="https://kit.fontawesome.com/a0b22afb83.js"></script>

    <title>Rejestracja uzytkownika</title>
</head>
<body>
<form class="text-center border border-light p-5" action="/register">

    <p class="h4 mb-4">Sign up</p>

    <div class="form-row mb-4">
        <div class="col">
            <!-- Login -->
            <input type="text" id="registerFormLogin" class="form-control" placeholder="Login">
        </div>
    </div>

    <!-- E-mail -->
    <input type="email" id="registerFormEmail" class="form-control mb-4" placeholder="Email">

    <!-- Password -->
    <input type="password" id="registerFormPassword" class="form-control" placeholder="Password" aria-describedby="registerFormPasswordHelpBlock">
    <small id="registerFormPasswordHelpBlock" class="form-text text-muted mb-4">
        At least 8 characters
    </small>

    <!-- Sign up button -->
    <button class="btn btn-info my-4 btn-block" type="submit">Sign in</button>

    <!-- Social register -->
    <p>or sign up with:</p>

    <a type="button" class="light-blue-text mx-2">
        <i class="fab fa-facebook-f"></i>
    </a>
    <a type="button" class="light-blue-text mx-2">
        <i class="fab fa-twitter"></i>
    </a>
    <a type="button" class="light-blue-text mx-2">
        <i class="fab fa-linkedin-in"></i>
    </a>
    <a type="button" class="light-blue-text mx-2">
        <i class="fab fa-github"></i>
    </a>

</form>
</body>
</html>
