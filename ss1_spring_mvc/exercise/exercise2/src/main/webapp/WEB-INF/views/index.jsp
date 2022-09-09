<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 9/9/2022
  Time: 4:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<html>
<head>
  <title>Title</title>
</head>
<body>
<form  action="/translate" method="get">
  <h1>Huy's Translation</h1>
  <input type="text" name="english">
  <input type="submit" id="translate" value="translate"><br>
  <span>Result: ${translate}</span>
</form>

</body>
</html>
