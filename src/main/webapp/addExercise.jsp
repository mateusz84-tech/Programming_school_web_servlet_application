<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 10.05.2021
  Time: 20:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dodawanie ćwiczenia</title>
</head>
<body>
<h2>Dodaj ćwiczenie</h2>
<form action="${pageContext.request.contextPath}/exerciseAdd" method="post">
    <label>
        Tytuł:
        <input type="text" name="title">
    </label>
    <label>
        Opis:
        <input type="text" name="description"/>
    </label>
    <input type="submit">

</form>
</body>
</html>
