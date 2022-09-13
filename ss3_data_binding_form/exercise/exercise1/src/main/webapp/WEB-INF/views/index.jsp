<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 9/13/2022
  Time: 11:35 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<h1 class="text-center">Mailbox list</h1>

<h4 style="color: darkgreen" class="text-center">${message}</h4>

<table class="table">
    <thead>
    <tr>
        <th>ID</th>
        <th>Language</th>
        <th>Page size</th>
        <th>Spams filter</th>
        <th>Signature</th>
        <th>Update</th>
    </tr>

    </thead>
    <tbody>
    <c:forEach  var="mail" items="${mailboxList}">
        <tr>
            <td>${mail.id}</td>
            <td>${mail.language}</td>
            <td>${mail.pageSize}</td>
            <td>${mail.spamsFilter}</td>
            <td>${mail.signature}</td>
            <td><a href="/update?id=${mail.id}">Update</a></td>
        </tr>
    </c:forEach>
    </tbody>

</table>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
</body>
</html>
