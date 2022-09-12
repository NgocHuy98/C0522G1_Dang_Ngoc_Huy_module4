<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 9/12/2022
  Time: 11:03 AM
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
  <title>Email Validation</title>
</head>
<body>

<h1>Email Validate</h1>
<h3 style="color:red">${message}</h3>

<form action="validate" method="post">
  <input type="text" name="email"><br>
  <input type="submit" value="Validate">
</form>

</body>
</html>