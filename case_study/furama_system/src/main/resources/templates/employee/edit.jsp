<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 8/31/2022
  Time: 5:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.2/css/all.min.css">
    <title>Update Customer</title>
    <style>
        body {
            background-color: #B5C8FF;
        }
        a {
            text-decoration: none;
        }
        a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
<div class="mx-5 px-5 pt-3">
    <h2 class="text-center fw-bold">Update Employee</h2>

    <p class="text-center mt-3"><a href="/"><i class="fa-solid fa-house-chimney h5 mx-1"></i> Back to HOME</a></p>

    <p class="text-center">
        <a href="/employee"><i class="fa-solid fa-backward"></i> Back to Employee list</a>
    </p>

    <c:if test="${mess!=null}">
        <c:if test="${check}">
            <div class="justify-content-center d-flex">
                <div class="alert alert-success alert-dismissible fade show w-50">
                    <strong>Congratulations!</strong> ${mess}
                    <button type="button" class="btn-close" data-bs-dismiss="alert"></button>
                </div>
            </div>
        </c:if>

        <c:if test="${!check}">
            <div class="justify-content-center d-flex">
                <div class="alert alert-danger alert-dismissible fade show w-50">
                    <strong>Sorry!</strong> ${mess}
                    <button type="button" class="btn-close" data-bs-dismiss="alert"></button>
                </div>
            </div>
        </c:if>
    </c:if>


    <div class="d-flex justify-content-center">

        <form class="w-50 border border-2 border-success p-3 bg-warning rounded" method="post">
            <div class="form-group" hidden>
                <label class="h6">Employee:</label>
                <div class="input-group">
                    <input type="text" class="form-control" name="id" value="${employee.id}" readonly>
                    <span class="input-group-text"> <i class="fa-solid fa-person-circle-question"></i></span>
                </div>
            </div>

            <div class="form-group">
                <label for="name" class="h6">Name:</label>
                <div class="input-group">
                    <input type="text" id="name" class="form-control" name="name" value="${employee.nameEmployee}">
                    <span class="input-group-text"> <i class="fa-solid fa-person-circle-question"></i></span>
                </div>
            </div>

            <div class="mt-3 form-group">
                <label for="dateOfBirth" class="h6">Date of Birth:</label>
                <input type="date" id="dateOfBirth" class="form-control" name="dateOfBirth"
                       value="${employee.dateOfBirth}">
            </div>

<%--            <div class="mt-3 form-group">--%>
<%--                <label class="h6">Gender:</label>--%>
<%--                <div class="d-flex">--%>
<%--                    <label class="d-block me-4">--%>
<%--                        <input type="radio" value="true" name="gender" checked> Male--%>
<%--                        <i class="fa-solid fa-mars"></i>--%>
<%--                    </label>--%>
<%--                    <label class="d-block">--%>
<%--                        <input type="radio" value="false" name="gender"> Female--%>
<%--                        <i class="fa-solid fa-venus"></i>--%>
<%--                    </label>--%>
<%--                </div>--%>

<%--            </div>--%>

            <div class="mt-3 form-group">
                <label for="cardId" class="h6">Id card:</label>
                <div class="input-group">
                    <input type="text" id="cardId" class="form-control" name="cardId"
                           value="${employee.idCard}">
                    <span class="input-group-text"><i class="fa-solid fa-id-card"></i></span>
                </div>
            </div>
            <div class="mt-3 form-group">
            <label for="salary" class="h6">Salary:</label>
            <div class="input-group">
                <input type="text" id="salary" class="form-control" name="salary"
                       value="${employee.salary}">
                <span class="input-group-text"><i class="fa-solid fa-id-card"></i></span>
            </div>
        </div>

            <div class="mt-3 form-group">
                <label for="phoneNumber" class="h6">Phone number:</label>
                <div class="input-group">
                    <input type="text" id="phoneNumber" class="form-control" name="phoneNumber" value="${employee.phoneNumber}">
                    <span class="input-group-text"><i class="fa-solid fa-square-phone"></i></span>
                </div>
            </div>

            <div class="mt-3 form-group">
                <label for="email" class="h6">Email:</label>
                <div class="input-group">
                    <input type="text" id="email" class="form-control" name="email" value="${employee.email}">
                    <span class="input-group-text"><i class="fa-solid fa-envelope-circle-check"></i></span>
                </div>
            </div>

            <div class="mt-3 form-group">
                <label for="address" class="h6">Address:</label>
                <div class="input-group">
                    <input type="text" id="address" class="form-control" name="address"
                           value="${employee.address}">
                    <span class="input-group-text"><i class="fa-solid fa-map-location-dot"></i></span>
                </div>
            </div>


            <div class="mt-3 form-group">
                <label class="h6" for="position">Position:</label>
                <div class="input-group">
                    <select id="position" class="form-control" name="position">
                        <c:forEach var="position" items="${positionList}">
                            <option value="${position.positionId}">${position.name}</option>
                        </c:forEach>
                    </select>
                    <span class="input-group-text"><i class="fa-solid fa-ranking-star"></i></span>
                </div>
            </div>

            <div class="mt-3 form-group">
                <label class="h6" for="educationDegree">Education:</label>
                <div class="input-group">
                    <select id="educationDegree" class="form-control" name="educationDegree">
                        <c:forEach var="education" items="${educationDegreeList}">
                            <option value="${education.id}">${education.name}</option>
                        </c:forEach>
                    </select>
                    <span class="input-group-text"><i class="fa-solid fa-ranking-star"></i></span>
                </div>
            </div>

            <div class="mt-3 form-group">
                <label class="h6" for="division">Division:</label>
                <div class="input-group">
                    <select id="division" class="form-control" name="division">
                        <c:forEach var="division" items="${divisionList}">
                            <option value="${division.id}">${division.name}</option>
                        </c:forEach>
                    </select>
                    <span class="input-group-text"><i class="fa-solid fa-ranking-star"></i></span>
                </div>
            </div>


            <div class="mt-3 text-center">
                <button class="btn btn-info btn-sm border border-2 border-success">
                    -- Save <i class="fa-solid fa-floppy-disk"></i> --
                </button>
            </div>
        </form>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa"
        crossorigin="anonymous"></script>
</body>
</html>