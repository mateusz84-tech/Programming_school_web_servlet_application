<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 13.05.2021
  Time: 19:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="pl">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1.0">
    <title>Strona główna</title>
    <style>
        *{  margin: 0;
            padding: 0;
            box-sizing: border-box;
        }
        #wrapper{
            max-width: 1200px;
            height: 900px;
            margin: 0 auto 0 auto;
            background-color: lightgray;
        }
        body{
            background-color: lightskyblue;
        }
        header img{
            width: 100%;
            display: block;
            height: 300px;
        }
        nav {
            background-color: rgb(149, 135, 240);
        }
        a.menu{
            display: inline-block;
            width: 24%;
            padding: 15px 30px;
            color: white;
            text-decoration: none;
            text-align: center;
        }
        a.bottom{
            color: aliceblue;
            text-decoration: none;
        }
        a.menu:hover {
            background-color: crimson;
        }
        a.bottom:hover {
            color:greenyellow;
        }
        h1{
            text-align: center;
            font-size: 32px;
            color: blue;
        }
        table{
            display:inline-block;
            width: 100%;
            text-align: center;
            border-spacing: 100px 25px;
        }
        .foot{
            margin: 0 auto;
            width: 1200px;
            text-align: center;
            font-size: small;
            font-style: italic;
            color: aquamarine;
            background-color:darkblue;
        }
    </style>
</head>
<body>
<div id="wrapper">
    <header>
        <img src="image/header.jpg" alt="header">
        <nav>
            <a href="${pageContext.request.contextPath}/groupList" class="menu">Grupy</a>
            <a href="${pageContext.request.contextPath}/exerciseList" class="menu">Zadania</a>
            <a href="${pageContext.request.contextPath}/userList" class="menu">Użytkownicy</a>
            <a href="solution.jsp" class="menu">Rozwiązania</a>
        </nav>
    </header>
    <section>
        <article>
            <h1>Ostatnio dodane rozwiązania</h1>
            <table class="table">
                <th>Lp.</th>
                <th>Opis</th>
                <th>Utworzono</th>
                <th>Edytowano</th>
                <th>Id Uzytkownika</th>
                <th>Id Zadania</th>
                <th>Podgląd</th>
                <c:forEach items="${solution}" var="sol" varStatus="step">
                <tr>
                    <td>${step.count}</td>
                    <td>${sol.getDesctiption()}</td>
                    <td>${sol.getCreated()}</td>
                    <td>${sol.getUpdated()}</td>
                    <td>${sol.getUserId()}</td>
                    <td>${sol.getExerciseId()}</td>
                    <td><a href="#" class="bottom">Wyświetl</a></td>
                </tr>
                </c:forEach>
            </table>
        </article>
        <!-- tutaj iframe -->
    </section>
</div>
<footer class="foot">
    <p>Mede by:  Mateusz Kocierz </p>
    <p>email: mateusz_kocierz@wp.pl</p>
    <p>github: #</p>
</footer>
</body>
</html>
