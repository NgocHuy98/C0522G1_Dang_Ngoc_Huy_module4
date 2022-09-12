<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 9/12/2022
  Time: 11:29 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<h1>Sandwich Condiments</h1>
<form action="/save">
    <input type="checkbox" name="condiment" value="lettuce">lettuce
    <input type="checkbox" name="condiment" value="tomato">tomato
    <input type="checkbox" name="condiment" value="mustard">mustard
    <input type="checkbox" name="condiment" value="Sprouts">Sprouts
    <p>
        <button type="submit">Save</button>
    </p>
</form>

<h2>Result: </h2>
<c:forEach var="choose" items="${condiment}">
    <h2> ${choose}</h2>
</c:forEach>

</body>
</html>
