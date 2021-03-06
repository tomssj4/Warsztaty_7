<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: teos
  Date: 01.10.2019
  Time: 17:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Battle</title>

    <!-- Stylesheet -->
    <link href="../../css/index2.css" rel="stylesheet" type="text/css">

    <jsp:include page="header.jsp"/>
</head>
<body>
<!-- Page section -->
<div class="main-page">
    <div class="text-center">
        <!-- Character data -->
        <c:choose>
            <c:when test="${character_data.characterClass.type == 'Sorcerer'}">
                <div>
                    <div>
                        <img src="">
                    </div>
                    <div>
                        <table class="character-table">
                            <tbody>
                            <tr>
                                <td>Name:</td>
                                <td>${character_data.name}</td>
                            </tr>
                            <tr>
                                <td>Type:</td>
                                <td>${character_data.characterClass.type}</td>
                            </tr>
                            <tr>
                                <td>LVL:</td>
                                <td>${character_data.lvl}</td>
                            </tr>
                            <tr>
                                <td>Experience points:</td>
                                <td>${character_data.experiencePoint}</td>
                            </tr>
                            <tr>
                                <td>Magic lvl:</td>
                                <td>${character_data.characterClass.magicLvl}</td>
                            </tr>
                            <tr>
                                <td>Magic power:</td>
                                <td>${character_data.characterClass.magicPower}</td>
                            </tr>
                            <tr>
                                <td>Health points:</td>
                                <td>${character_data.characterClass.healthPoints}</td>
                            </tr>
                            <tr>
                                <td>Mana points:</td>
                                <td>${character_data.characterClass.manaPoints}</td>
                            </tr>
                            <tr>
                                <td>Armour:</td>
                                <td>${character_data.characterClass.armour}</td>
                            </tr>
                            <tr>
                                <td>Attack speed:</td>
                                <td>${character_data.characterClass.attackSpeed}</td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </c:when>
            <c:when test="${character_data.characterClass.type == 'Druid'}">
                <div>
                    <div>
                        <img src="">
                    </div>
                    <div>
                        <table class="character-table">
                            <tbody>
                            <tr>
                                <td>Name:</td>
                                <td>${character_data.name}</td>
                            </tr>
                            <tr>
                                <td>Type:</td>
                                <td>${character_data.characterClass.type}</td>
                            </tr>
                            <tr>
                                <td>LVL:</td>
                                <td>${character_data.lvl}</td>
                            </tr>
                            <tr>
                                <td>Experience points:</td>
                                <td>${character_data.experiencePoint}</td>
                            </tr>
                            <tr>
                                <td>Magic lvl:</td>
                                <td>${character_data.characterClass.magicLvl}</td>
                            </tr>
                            <tr>
                                <td>Magic power:</td>
                                <td>${character_data.characterClass.magicPower}</td>
                            </tr>
                            <tr>
                                <td>Health points:</td>
                                <td>${character_data.characterClass.healthPoints}</td>
                            </tr>
                            <tr>
                                <td>Mana points:</td>
                                <td>${character_data.characterClass.manaPoints}</td>
                            </tr>
                            <tr>
                                <td>Armour:</td>
                                <td>${character_data.characterClass.armour}</td>
                            </tr>
                            <tr>
                                <td>Attack speed:</td>
                                <td>${character_data.characterClass.attackSpeed}</td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </c:when>
            <c:when test="${character_data.characterClass.type == 'Knight'}">
                <div>
                    <div>
                        <img src="">
                    </div>
                    <div>
                        <table class="character-table">
                            <tbody>
                            <tr>
                                <td>Name:</td>
                                <td>${character_data.name}</td>
                            </tr>
                            <tr>
                                <td>Type:</td>
                                <td>${character_data.characterClass.type}</td>
                            </tr>
                            <tr>
                                <td>LVL:</td>
                                <td>${character_data.lvl}</td>
                            </tr>
                            <tr>
                                <td>Experience points:</td>
                                <td>${character_data.experiencePoint}</td>
                            </tr>
                            <tr>
                                <td>Attack damage:</td>
                                <td>${character_data.characterClass.attackDamage}</td>
                            </tr>
                            <tr>
                                <td>Health points:</td>
                                <td>${character_data.characterClass.healthPoints}</td>
                            </tr>
                            <tr>
                                <td>Armour:</td>
                                <td>${character_data.characterClass.armour}</td>
                            </tr>
                            <tr>
                                <td>Attack speed:</td>
                                <td>${character_data.characterClass.attackSpeed}</td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </c:when>
            <c:when test="${character_data.characterClass.type == 'Palladyn'}">
                <div>
                    <div>
                        <img src="">
                    </div>
                    <div>
                        <table class="character-table">
                            <tbody>
                            <tr>
                                <td>Name:</td>
                                <td>${character_data.name}</td>
                            </tr>
                            <tr>
                                <td>Type:</td>
                                <td>${character_data.characterClass.type}</td>
                            </tr>
                            <tr>
                                <td>LVL:</td>
                                <td>${character_data.lvl}</td>
                            </tr>
                            <tr>
                                <td>Experience points:</td>
                                <td>${character_data.experiencePoint}</td>
                            </tr>
                            <tr>
                                <td>Attack damage:</td>
                                <td>${character_data.characterClass.attackDamage}</td>
                            </tr>
                            <tr>
                                <td>Health points:</td>
                                <td>${character_data.characterClass.healthPoints}</td>
                            </tr>
                            <tr>
                                <td>Armour:</td>
                                <td>${character_data.characterClass.armour}</td>
                            </tr>
                            <tr>
                                <td>Attack speed:</td>
                                <td>${character_data.characterClass.attackSpeed}</td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </c:when>
        </c:choose>



        <!-- Button trigger modal -->
        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModalCenter"
                onclick="window.location.href='${pageContext.request.contextPath}/battle/score/${character_data.id}/${monster_data.id}'">
            Battle!
        </button>


            <!-- Monster data -->
            <div>
                <img src="">
            </div>
            <div>
                <table class="monster-table">
                    <tbody>
                    <tr>
                        <td>Name:</td>
                        <td>${monster_data.name}</td>
                    </tr>
                    <tr>
                        <td>Experience points:</td>
                        <td>${monster_data.experiencePoints}</td>
                    </tr>
                    <tr>
                        <td>Attack damage:</td>
                        <td>${monster_data.damagePoints}</td>
                    </tr>
                    <tr>
                        <td>Health points:</td>
                        <td>${monster_data.healthPoints}</td>
                    </tr>
                    <tr>
                        <td>Armour:</td>
                        <td>${monster_data.armour}</td>
                    </tr>
                    <tr>
                        <td>Attack speed:</td>
                        <td>${monster_data.attackSpeed}</td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
</body>
</html>
