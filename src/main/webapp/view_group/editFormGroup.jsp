<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 14.05.2021
  Time: 20:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edycja grupy formularz</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1.0">
</head>
<body>
<div>
    <header>
        <h1>Edytuj grupę</h1>
    </header>
    <div>
        ${editGroup.getId()}
        <form method="post" action="/editFormGroup" >
            <label>
                Wpisz nową nazwę grupy
            </label>
            <br>
            <label>
                <input type="text" name="newName" >
            </label>
            <br>
            <input type="submit">
        </form>
    </div>
</div>
</body>
</html>
