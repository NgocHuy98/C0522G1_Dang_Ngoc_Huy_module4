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
<h1 style="text-align: center">Tờ khai y tế </h1>
<h3 style="text-align: center">ĐÂY LÀ TÀI LIỆU QUAN TRỌNG, THÔNG TIN CỦA ANH/CHỊ SẼ GIÚP CƠ QUAN Y TẾ
    LIÊN LẠC KHI CẦN THIẾT ĐỂ PHÒNG CHỐNG DỊCH BỆNH TRUYỀN NHIỄM</h3>
<h4 style="color: red;text-align: center">Khuyến cáo : khai báo thông tin sai là vi phạm pháp luật</h4>
<form:form modelAttribute="declaration" method="post" action="/save">
    <table class="table">
        <tr>
            <td><form:hidden path="id"/></td>
        </tr>

        <tr>
            <td>Họ tên (ghi chữ in hoa)(*)</td>
        </tr>
        <tr>
            <td><form:input path="name"/></td>
        </tr>

        <tr>
            <td>Năm sinh (*)</td>
            <td>Giới tính (*)</td>
            <td>Quốc tịch (*)</td>
        </tr>
        <tr>
            <td><form:input path="dayOfBirth"/></td>
            <td><form:select path="gender" items="${genderList}"/></td>
            <td><form:select path="nationality" items="${nationList}"/></td>
        </tr>

        <tr>
            <td>Số hộ chiếu/ số CMND hoặc giấy tờ khác (*)</td>
        </tr>
        <tr>
            <td><form:input path="idCard"/></td>
        </tr>

        <tr>
            <td> Thông tin đi lại</td>
        </tr>
        <tr>
            <td><form:radiobuttons path="travelInformation" items="${travelList}"/></td>
        </tr>

        <tr>
            <td>Số hiệu phương tiên (*)</td>
            <td>Số ghế (*)</td>
        </tr>
        <tr>
            <td><form:input path="vehicleNumber"/></td>
            <td><form:input path="seatNumber"/></td>
        </tr>

        <tr>
            <td>Ngày khởi hành (*)</td>
            <td>Ngày kết thúc (*)</td>
        </tr>
        <tr>
            <td><form:input path="startDate"/></td>
            <td><form:input path="endDate"/></td>
        </tr>

        <tr>
            <td>Trong vòng 14 ngày qua, Anh/Chị có đến tỉnh/thành phố nào? (*)</td>
        </tr>
        <tr>
            <td><form:textarea path="travelHistory"/></td>
        </tr>

        <tr>
            <td><form:button>Cập nhật</form:button> </td>
        </tr>
    </table>
</form:form></body>
</html>
