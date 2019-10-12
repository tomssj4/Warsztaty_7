<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: teos
  Date: 28.09.2019
  Time: 12:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create character</title>

    <!-- Stylesheet -->
    <link href="../../../css/index2.css" rel="stylesheet" type="text/css">

    <jsp:include page="../header.jsp"/>
</head>
<body>
<!-- Page section -->
<div class="main-page" style="{position: absolute; top: 50%;}">
    <form:form modelAttribute="new_character" method="post" class = "text-center">

        <p>New Character</p>

        <div>
            <div>
                <!-- Character Name -->
                Name: <form:input path="name" id="name"/>
                <form:errors path="name"/>
            </div>
        </div>

        <!-- Character class -->
        Which class would You like to play?
        <li><form:radiobutton path="type" name="type" value="Sorcerer"/>Sorcerer</li>
        <li><form:radiobutton path="type" name="type" value="Druid"/>Druid</li>
        <li><form:radiobutton path="type" name="type" value="Knight"/>Knight</li>
        <li><form:radiobutton path="type" name="type" value="Palladyn"/>Palladyn</li>

        <!-- Create button -->
        <button type="submit">Create</button>


    </form:form>
</div>
</body>
</html>
