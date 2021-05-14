<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 14.05.2021
  Time: 14:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1.0">
    <title>Dodawanie nowych grup</title>
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
        h1{
            text-align: center;
            color: coral;
            font-family: "DejaVu Sans", sans-serif;
        }
        header p{
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
<div id="wrapper">
    <header>
        <h1>Grupy</h1>
        <br>
        <p>Wypełni formularz</p>
    </header>
    <br>
    <div>
        <form action="/addGroup" method="post">
            <label>
                Wpisz nazwę grupy
            </label>
            <br>
            <label>
                <input type="text" name="groupName">
            </label>
            <br>
            <input type="submit">
        </form>
    </div>
</div>
</body>
</html>
