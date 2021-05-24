<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 14.05.2021
  Time: 13:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width,initial-scale=1.0">
    <title>Użytkownik</title>
    <style>
        *{
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }
        #wrapper{
            max-width: 1200px;
            height: 900px;
            margin: 0 auto;
            background-color:lightgray;
        }
        body{
            background-color:lightsteelblue;
        }
        header img{
            width: 100%;
            display: block;
            height: 300px;
        }
        nav{
            background-color: cornflowerblue;
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
        a.menu:hover{
            background-color: crimson;
        }
        a.bottom:hover{
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
            border-spacing: 150px 15px;
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
        <img src="image/user.jpg" alt="user">
        <nav>
            <a href="${pageContext.request.contextPath}/view_user/addUser.jsp" class="menu">Dodaj</a>
            <a href="" class="menu">Edytuj</a>
            <a href="" class="menu">Lista</a>
            <a href="" class="menu">Usuń</a>
        </nav>
    </header>
    <section>
        <article>
            <h1>Ostanio dodani użytkownicy</h1>
            <table>
                <th>Lp.</th>
                <th>Nazwa</th>
                <th>Email</th>
                <th>Id grupy</th>
                <th>Podgląd</th>
                <c:forEach items="${users}" var="user" varStatus="stat">
                <tr>
                    <td>${stat.count}</td>
                    <td>${user.getUserName()}</td>
                    <th>${user.getEmail()}</th>
                    <th>${user.getGroupId()}</th>
                    <th><a href="" class="bottom">Wyświetl</a></th>
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
