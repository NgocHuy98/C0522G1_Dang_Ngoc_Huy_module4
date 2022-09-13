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
<h2 class="text-center"> Medical Declaration list</h2>

<h4 style="color: darkgreen" class="text-center">${message}</h4>

<table class="table">
  <thead>
  <tr>
    <th>STT</th>
    <th>Họ tên</th>
    <th>Năm sinh</th>
    <th>Giới tính</th>
    <th>Quốc tịch</th>
    <th>Số CMND/Hộ chiếu</th>
    <th>Thông tin đi lại</th>
    <th>Số hiệu phương tiện</th>
    <th>Số ghế</th>
    <th>Ngày khởi hành</th>
    <th>Ngày Kết thúc</th>
    <th>Lịch sử đi lại</th>
    <th></th>
  </tr>
  </thead>
  <tbody>
  <c:forEach items="${declarations}" var="declaration">
    <tr>
      <td hidden>${declaration.id}</td>
      <td>${declaration.name}</td>
      <td>${declaration.dayOfBirth}</td>
      <td>${declaration.gender}</td>
      <td>${declaration.nationality}</td>
      <td>${declaration.idCard}</td>
      <td>${declaration.travelInformation}</td>
      <td>${declaration.vehicleNumber}</td>
      <td>${declaration.seatNumber}</td>
      <td>${declaration.startDate}</td>
      <td>${declaration.endDate}</td>
      <td>${declaration.travelHistory}</td>
      <td><a href="/update?id=${declaration.id}">Update</a></td>
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
