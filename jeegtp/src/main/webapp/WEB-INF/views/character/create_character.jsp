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
    <jsp:include page="../header.jsp"/>
</head>
<body>
<form:form modelAttribute="new_character" method="post">

    <p>New Character</p>

    <div>
        <div>
            <!-- Character Name -->
            <form:input path="name" id="name"/>
            <form:errors path="name"/>
        </div>
    </div>

    <!-- Character class -->
    <li><form:radiobutton path="type" value="Sorcerer"/>Sorcerer</li>
    <li><form:radiobutton path="type" value="Driud"/>Driud</li>
    <li><form:radiobutton path="type" value="Knigth"/>Knigth</li>
    <li><form:radiobutton path="type" value="Palladyn"/>Palladyn</li>

    <!-- Create button -->
    <button type="submit">Create</button>


</form:form>

</body>
</html>
