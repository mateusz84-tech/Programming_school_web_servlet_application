<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 15.05.2021
  Time: 14:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width,initial-scale=1.0">
  <title>Dodawanie zadania</title>
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
      text-align: center;
      font-family: "DejaVu Sans",sans-serif;
      color: black;
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
    <h1>Zadania</h1>
  </header>
  <br><br>
  <div>
    <p>Wypełni formularz</p>
    <br><br>
    <form method="post" action="${pageContext.request.contextPath}/addExercise">
      <label>
        Tytuł
      </label>
      <br><br>
      <label>
        <input type="text" name="title">
      </label>
      <br><br>
      <label>
        Opis
      </label>
      <br><br>
      <label>
        <input type="text" name="description">
      </label>
      <br><br>
      <input type="submit">
    </form>
  </div>
</div>
</body>
</html>
