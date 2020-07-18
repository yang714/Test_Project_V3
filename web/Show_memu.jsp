<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 2020/6/12
  Time: 下午 10:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Management Memu</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">

    <!-- Optional theme -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap-theme.min.css" integrity="sha384-6pzBo3FDv/PJ8r2KRkGHifhEocL+1X2rVCTTkUfGk7/0pbek5mMa1upzvWbrUbOZ" crossorigin="anonymous">

    <!-- Latest compiled and minified JavaScript -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js" integrity="sha384-aJ21OjlMXNL5UyIl/XNwTMqvzeRMZH2w8c5cRVpzpU8Y5bApTppSuUkhZXN0VxHd" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <style>
        @import url("CSS/show_U.css");
    </style>
</head>
<body>

<form action="CHANGE" method="post">
    <div class="table-responsive-lg">

        <table frame="border" rules="all" class="table table-hover" style="font-size: 30px">
        <%--    <h1> ${i.id_number}  ${i.id} ${i.date} ${i.UM_number}</h1> <p>--%>
        <tr class="bg-primary midd">
<%--            <th>MEMU_ID</th>--%>
            <th scope="col">MEMU_name</th>
            <th scope="col">MEMU_price</th>
            <th scope="col">TYPE</th>
            <th scope="col">Option</th>
        </tr>
        <c:forEach var="i" items="${show_memu_model}">
            <tr>
                <input value="${i.memu_ID}" type="hidden" name="memu_ID"/>
                <td style="vertical-align: middle"><input name="memu_name" value=${i.memu_name}></td>
                <td style="vertical-align: middle"><input name="memu_price" value=${i.memu_price}></td>
<%--                <td>${i.food_type}</td>--%>
   <td >
       <select name="Test_select" class="selectpicker">
            <c:forEach var="j" items="${Food_kind}">
                <c:choose>
    <c:when test="${i.meal_ID==j.meal_ID}">
        <option value=${j.meal_ID} SELECTED >${j.food_type} </option>
    </c:when>
                    <c:otherwise>
            <option value=${j.meal_ID}>${j.food_type} </option>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
    </select>

   </td>

    <td> <button type="submit" value="${i.memu_ID}" name="memu_delete" class="btn btn-danger btn-lg">
        <span class="glyphicon glyphicon-remove"></span></button></td>
                    <%--        <td><input value="${i.id}" name="test" type="submit"></td>--%>

            </tr>

        </c:forEach>
        <%--<h1>  ${i.id} ${i.id_number} ${i.date} ${i.um_number}</h1> <p>--%>


            <td ><input type="text"  name="memu_nameADD"></td>
            <td><input type="number" name="memu_priceADD"></td>

            <td >
                <select name="selectADD" class="selectpicker">
<c:forEach var="j" items="${Food_kind}">
    <option value=${j.meal_ID}>${j.food_type} </option>
</c:forEach>
            </select>
            </td>
            <td> <button type="submit" value="ADD" name="memu_add" class="btn btn-success btn-lg">
                <span class="glyphicon glyphicon-plus"></span></button></td>
    </table>


        <div class="input-group mb-3">
            <div style="margin-bottom: 25px" class="input-group input-group-lg">
    <input type="submit" value="Memu change" name="memu_check" class="btn btn-success btn-lg">
            </div>

<%--    <label for="add_T">input_type:</label>--%>

            <div style="margin-bottom: 25px" class="input-group input-group-lg">
    <div style="margin-bottom: 25px" class="input-group input-group-lg">
        <span class="input-group-addon"><i class="glyphicon glyphicon-glass"></i></span>
        <input id="add_T" type="text" placeholder="Type name" name="type_name" class="form-control">
    </div>
            <input type="submit" value="ADD type" name="add_type" class="btn btn-info btn-lg">
        </div>

</form>
<%--<form action="User_page.jsp" method="post">--%>
<%--    <div class="col-md-12 control">--%>
<%--    <input type="submit" value="Main page"  class="btn btn-warning btn-lg">--%>
<%--    </div>--%>
<%--</form>--%>

<form action="User_page.jsp" method="post">
    <%--    <input type="submit" value="Main page"  class="btn btn-warning btn-lg glyphicon glyphicon-home">--%>
        <div class="col-md-12 control">
    <button type="submit" class="btn btn-warning btn-lg">
        <span class="glyphicon glyphicon-home"></span></button>
        </div>
</form>
</body>
</html>
