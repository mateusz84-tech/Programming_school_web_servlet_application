<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 13.05.2021
  Time: 20:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head lang="pl">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1.0">
    <title>Grupy</title>
    <style>
        *{
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }
        #wrapper{
            width: 1200px;
            height: 900px;
            margin: 0 auto;
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
        nav{
            background-color: rgb(149, 135, 240) ;
        }
        a.menu{
            display: inline-block;
            width: 24%;
            padding: 15px 30px;
            color: white;
            text-decoration: none;
            text-align: center;
        }
        a.menu:hover{
            background-color: crimson;
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
            border-spacing: 250px 25px;
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
        a.bottom{
            color: aliceblue;
            text-decoration: none;
        }
        a.bottom:hover{
            color: greenyellow;
        }
    </style>
</head>
<body>
<div id="wrapper">
    <header>
        <img src="img/groupHeader.jpg" alt="">
        <nav>
            <a href="/view_group/addGroup.jsp" class="menu">Dodaj</a>
            <a href="#" class="menu">Edytuj</a>
            <a href="#" class="menu">Lista grup</a>
            <a href="#" class="menu">Usuń</a>
        </nav>
    </header>
    <section>
        <article>
            <h1>Ostanio dodane grupy</h1>
            <table>
                <th>Lp.</th>
                <th>Nazwa</th>
                <th>Podgląd</th>
                <c:forEach items="${group}" var="group" varStatus="stat">
                <tr>
                    <td>${stat.count}</td>
                    <td>${group.getName()}</td>
                    <td><a href="#" class="bottom">Wyswietl</a></td>
                </tr>
                </c:forEach>
            </table>
        </article>
    </section>
</div>
<footer class="foot">
    <p>Mede by:  Mateusz Kocierz </p>
    <p>email: mateusz_kocierz@wp.pl</p>
    <p>github: #</p>
</footer>
</body>
</html>
