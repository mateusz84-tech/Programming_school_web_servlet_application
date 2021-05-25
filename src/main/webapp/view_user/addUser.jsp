<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 24.05.2021
  Time: 20:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1.0">
    <title>Dodawanie użytkownika</title>
    <style>
        *{
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }
        h1{
            color: coral;
            text-align: center;
        }
        p{
            color: black;
            font-family: "DejaVu Sans",sans-serif;
            text-align: center;
            font-size: 28px;
        }
        form{
            display: block;
            text-align: center;
        }
    </style>
</head>
<body>
<div>
    <header>
        <h1>Użytkownicy</h1>
    </header>
<br><br>
    <p>Wypełni formularz</p>
    <br><br>
    <form method="post" action="${pageContext.request.contextPath}/addUserServlet">
        <label>
            Nazwa użytkownika
        </label>
        <br>
        <label>
            <input type="text" name="userName">
        </label>
        <br>
        <label>
            Email
        </label>
        <br>
        <label>
            <input type="text" name="email">
        </label>
        <br>
        <label>
            Hasło
        </label>
        <br>
        <label>
            <input type="text" name="password">
        </label>
        <br>
        <label>
            Id grupy
        </label>
        <br>
        <label>
            <input type="number" min="1" step="1" name="user_group_id">
        </label>
        <br><br>
        <input type="submit">
    </form>
</div>
</body>
</html>
