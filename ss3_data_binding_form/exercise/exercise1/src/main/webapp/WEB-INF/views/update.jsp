<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 9/13/2022
  Time: 1:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Setting</h1>
<form:form action="/save" method="post" modelAttribute="mailbox">
<table>

    <tr>
        <td><form:hidden path="id"/></td>
    </tr>

    <tr>
        <td>Languages</td>
        <td>
            <form:select path="language" items="${languageList}" />
        </td>
    </tr>

    <tr>
        <td>Page size</td>
     <td>
         <form:select path="pageSize" items="${pageSizeList}"/>
     </td>
    </tr>

    <tr>
        <td>Spams filter</td>
        <td>
            <form:checkbox path="spamsFilter"/>Enable spams filter
        </td>
    </tr>

    <tr>
        <td>Signature</td>
        <td>
            <form:textarea path="signature"/>
        </td>
    </tr>

    <tr>
        <td>
           <form:button>Update</form:button>
        </td>

        <td>
            <button type="reset">Cancel</button>
        </td>
    </tr>
</table>

</form:form>
</body>
</html>
