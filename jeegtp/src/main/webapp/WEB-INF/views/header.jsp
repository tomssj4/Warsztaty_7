<%--
  Created by IntelliJ IDEA.
  User: teos
  Date: 15.09.2019
  Time: 15:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>GTP</title>
</head>
<body>
<div class="header-warp">
    <div class="header-social d-flex justify-content-end">
        <p>Follow us:</p>
        <a href="#"><i class="fa fa-facebook"></i></a>
        <a href="#"><i class="fa fa-twitter"></i></a>
    </div>
    <div class="header-bar-warp d-flex">
        <!-- site logo -->
        <a href="/home" class="site-logo">
            <img src="./img/logo.png" alt="">
        </a>
        <nav class="top-nav-area w-100">
            <div class="user-panel">
                <a href="">Settings</a>
            </div>
            <div class="user-panel">
                <a href="">Logout</a>
            </div>
            <!-- Menu -->
            <ul class="main-menu primary-menu">
                <li><a href="${pageContext.request.contextPath}/home">Home</a></li>
                <li><a href="">Monster list</a></li>
                <li><a href="">Contact</a></li>
            </ul>
        </nav>
    </div>
</div>

</body>
</html>
