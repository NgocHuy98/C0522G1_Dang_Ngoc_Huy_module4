<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 9/12/2022
  Time: 1:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<form method="get" action="/calculate">
    <h1> Calculator </h1>
    <input type="text" value="${num1}" name="firstNumber">
    <input type="text" value="${num2}" name="secondNumber">
    <br>

    <button name="operator" value="addition">Addition(+)</button>
    <button name="operator" value="subtraction">Subtraction(-)</button>
    <button name="operator" value="multiplication">Multiplication(*)</button>
    <button name="operator" value="division">Division(/)</button>

</form>
<h2>Result: ${result}</h2>
</body>
</html>