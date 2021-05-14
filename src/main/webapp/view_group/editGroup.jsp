<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 14.05.2021
  Time: 18:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edycja grupy</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1.0">
</head>
<body>
<div>
    <header>
        <h1>Edycja grup</h1>
    </header>
    <div>
        <table>
            <th>Lp.</th>
            <th>Identyfikator</th>
            <th>Nazwa grupy</th>
            <th>Edytuj</th>
            <c:forEach items="${group}" var="group" varStatus="stat">
                <tr>
                    <td>${stat.count}</td>
                    <td>${group.getId()}</td>
                    <td>${group.getName()}</td>
                    <td><a href="/editFormGroup?id=${group.getId()}">Link</a> </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>
