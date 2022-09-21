<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 8/31/2022
  Time: 11:45 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
    <link rel="stylesheet" href="datatables/css/dataTables.bootstrap4.min.css"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.2/css/all.min.css">
    <title>Home</title>
    <style>
        table {
            border: solid 3px;
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
<div class="p-3">
    <h2 class="text-center fw-bold">FACILITY LIST</h2>

    <c:if test="${mess!=null}">
        <:c:if test="${check}">
            <div class="justify-content-center d-flex">
                <div class="alert alert-success alert-dismissible fade show w-50">
                    <strong>${mess}</strong>
                    <button type="button" class="btn-close" data-bs-dismiss="alert"></button>
                </div>
            </div>
        </:c:if>

        <:c:if test="${!check}">
            <div class="justify-content-center d-flex">
                <div class="alert alert-danger alert-dismissible fade show w-50">
                    <strong>${mess}</strong>
                    <button type="button" class="btn-close" data-bs-dismiss="alert"></button>
                </div>
            </div>
        </:c:if>
    </c:if>

<%--    <a href="/customer?action=create">--%>
<%--        <button class="btn btn-success btn-sm my-2">--%>
<%--            <span class="fa-solid fa-person-circle-plus text-light h5 my-auto me-1"></span> Add new Customer--%>
<%--        </button>--%>
<%--    </a>--%>
    <nav class="navbar navbar-expand-lg pb-0 mb-0">
        <div class="container-fluid">
            <a href="/facility?action=create">
                <button class="btn btn-success btn-outline-secondary btn-sm">
                    <span class="fa-solid fa-person-circle-plus text-light h5 my-auto me-1"></span>
                    <span class="text-light"> Add new facility</span>
                </button>
            </a>

            <form class="d-flex my-2" role="search" action="/facility">
                <input class="form-control me-2" type="text" placeholder="Input search Name" aria-label="Search"
                       name="nameSearch">
                <select class="form-control me-2" name="facilityTypeSearch">
                    <option value="">Facility type</option>
                    <c:forEach var="facilityType" items="${facilityTypeList}">
                        <option value="${facilityType.name}">${facilityType.name}</option>
                    </c:forEach>
                </select>

                <button class="btn btn-outline-success" type="submit" name="action" value="search">
                    <i class="fa-solid fa-magnifying-glass"></i></button>
            </form>
        </div>
    </nav>

    <table class="table table-striped table-bordered " id="facilityTable">
        <thead>
        <tr class=" bg-info">
            <th>Number</th>
            <th>Name</th>
            <th>Area</th>
            <th>Cost</th>
            <th>Max people</th>
            <th>Rent type</th>
            <th>Facility type</th>
            <th>Standard room</th>
            <th>Description</th>
            <th>Pool area</th>
            <th>Floors</th>
            <th>Facility free</th>
            <th>Update</th>
            <th>Delete</th>

        </tr>
        </thead>
        <tbody>

        <c:forEach varStatus="status" var="facility" items="${facilityList}">
            <tr>
                <td class="text-center">${status.count}</td>
                <td>${facility.name}</td>
                <td class="text-center">${facility.area}</td>
                <td class="text-center">${facility.cost}</td>
                <td class="text-center">${facility.maxPeople}</td>
                <td class="text-center">
                    <c:forEach var="rentType" items="${rentTypeList}">
                            <c:if test="${rentType.id == facility.rentTypeId}">
                                ${rentType.name}
                            </c:if>
                            </c:forEach></td>
                <td class="text-center">
                <c:forEach var="facilityType" items="${facilityTypeList}">
                    <c:if test="${facilityType.id == facility.facilityTypeId}">
                        ${facilityType.name}
                    </c:if>
                </c:forEach>
                      </td>

                <td class="text-center">${facility.standardRoom}</td>
                <td class="text-center">${facility.descriptionOtherConvenience}</td>
                <td>${facility.poolArea}</td>
                <td>${facility.numberOfFloors}</td>
                <td>${facility.facilityFree}</td>
                <td class="text-center"><a href="/facility?action=edit&id=${facility.id}">
                    <span class="fa-solid fa-user-pen text-primary h4 m-auto"></span>
                </a></td>
                <td class="text-center">
                    <a href="/facility?action=delete=&id=${facility.id}" data-bs-toggle="modal"
                       data-bs-target="#exampleModal"
                       onclick="deleteFacility('${facility.getId()}','${facility.getName()}')">
                        <span class="fa-solid fa-person-circle-minus text-danger h4 m-auto"></span>
                    </a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <form action="/facility" method="get">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">You Want To Delete?</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <input type="text" hidden name="idDelete" id="idDelete">
                        <input type="text" hidden name="action" value="delete">
                        <strong>Facility: </strong>
                        <span id="nameDelete"></span>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                        <button type="submit" class="btn btn-primary">Delete</button>
                    </div>
                </div>
            </form>
        </div>
    </div>

    <a href="/"><i class="fa-solid fa-house-chimney h5 mx-1"></i> Back to HOME</a>
</div>

<script>
    function deleteFacility(id, name) {
        document.getElementById("idDelete").value = id;
        document.getElementById("nameDelete").innerText = name;

    }
</script>
<script src="jquery/jquery-3.5.1.min.js"></script>
<script src="datatables/js/jquery.dataTables.min.js"></script>
<script src="datatables/js/dataTables.bootstrap4.min.js"></script>
<script>
    $(document).ready(function () {
        $('#facilityTable').dataTable({
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 5
        });
    });
</script>
</body>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa"
        crossorigin="anonymous">

</script>

</html>
