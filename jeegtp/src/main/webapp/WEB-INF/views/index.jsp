<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: teos
  Date: 01.09.2019
  Time: 14:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">

    <!-- Favicon -->


    <!-- Stylesheet -->
    <link href="../../css/index.css" rel="stylesheet" type="text/css">


    <jsp:include page="header.jsp"/>
</head>
<body>

<!-- Page section -->
<div class="main-page">
    <div class="text-center">
    <!-- Hero section -->
    <section class="hero-section overflow-hidden">
        <div class="hero-slider owl-carousel">
            <div class="hero-item set-bg d-flex align-items-center justify-content-center text-center"
                 data-setbg="img/slider-bg-2.jpg">
                <div class="container">
                    <h2>Game on!</h2>
                    <p>In progress!!!</p>
                </div>
            </div>
        </div>
    </section>
    <!-- Hero section end-->

    <!-- Blog section -->
    <section class="blog-section">
        <div class="container">
            <div class="row">
                <div class="col-xl-9 col-lg-8 col-md-7">
                    <div class="section-title">
                        <h2>Latest News!</h2>
                    </div>
                    <ul class="blog-filter">
                        <li><a href="#">New Monsters</a></li>
                        <li><a href="#">New Items</a></li>
                        <li><a href="#">New Class</a></li>
                        <li><a href="#">New Quests</a></li>
                    </ul>

                </div>
            </div>
        </div>
    </section>
    <!-- Blog section end -->


    <!-- Intro section -->
    <section class="intro-video-section set-bg d-flex align-items-end " data-setbg="">
        <a href="" class="video-play-btn video-popup"><img src="" alt=""></a>
        <div class="container">
            <div class="video-text">
                <h2>Promo video of the game</h2>
                <p>Some comment</p>
            </div>
        </div>
    </section>
    <!-- Intro section end -->


    <!-- Newsletter section -->
    <section class="newsletter-section">
        <div class="container">
            <h2>Subscribe to our newsletter</h2>
            <form class="newsletter-form">
                <label>
                    <input type="text" placeholder="ENTER YOUR E-MAIL" aria-describedby="basic-addon1">
                </label>
                <button type="button" class="btn btn-outline-info">subscribe<img src="" alt=""/></button>
            </form>
        </div>
    </section>
    <!-- Newsletter section end -->


    <!-- Footer section -->
    <footer class="footer-section">
        <div>
            <div>
                <h2>Other content: </h2>
            </div>
            <ul class="main-menu footer-menu">
                <li><a href="">Home</a></li>
                <li><a href="">News</a></li>
                <li><a href="">Contact</a></li>
            </ul>
            <div class="footer-social d-flex justify-content-center">
                <a href="#"><i class="fa fa-pinterest"></i></a>
                <a href="#"><i class="fa fa-facebook"></i></a>
                <a href="#"><i class="fa fa-twitter"></i></a>
            </div>
        </div>
    </footer>
    <!-- Footer section end -->
    </div>
</div>


</body>
</html>

