<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 2020/6/28
  Time: 下午 01:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Discount</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">

    <!-- Optional theme -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap-theme.min.css" integrity="sha384-6pzBo3FDv/PJ8r2KRkGHifhEocL+1X2rVCTTkUfGk7/0pbek5mMa1upzvWbrUbOZ" crossorigin="anonymous">

    <!-- Latest compiled and minified JavaScript -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js" integrity="sha384-aJ21OjlMXNL5UyIl/XNwTMqvzeRMZH2w8c5cRVpzpU8Y5bApTppSuUkhZXN0VxHd" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<form action="Confirm_pagev2" method="post">
    <div class="container">

        <div id="loginbox" style="margin-top:50px;" class="mainbox col-md-99 col-md-offset-3 col-sm-8 col-sm-offset-2">
            <div class="panel panel-info" >
                <div class="panel-heading" style="height: 60px;padding:0 ;" >
                    <div class="panel-title" style="font-size: 35px">Origin price</div>
                </div>
                <table frame="border" rules="all" class="table table-hover" style="font-size: 30px">
                    <tr class="bg-primary midd">
                        <th  scope="col">Name</th>
                        <th  scope="col">Check number</th>
                        <th  scope="col">Price</th>
                    </tr>
<c:set value="0" var="sum" />

<c:forEach var="i" items="${sessionScope.check_outorder}">
                    <tr>
    <td  style="vertical-align: middle">${i.memuname}</td>
    <td  style="vertical-align: middle"> ${i.checknumber}</td>
    <td  style="vertical-align: middle">${i.price}</td>
                    </tr>
<%--    <h1>${i.memuname}/ ${i.checknumber}  / ${i.price}</h1>--%>
    <c:set value="${sum + i.price}" var="sum" />
</c:forEach>

<h1> Total ${sum}</h1>
                </table>
            </div>
        </div>
    </div>

    <div class="container">

        <div style="margin-top:50px;" class="mainbox col-md-99 col-md-offset-3 col-sm-8 col-sm-offset-2">
            <div class="panel panel-info" >
                <div class="panel-heading" style="height: 60px;padding:0 ;" >
                    <div class="panel-title" style="font-size: 35px">Discount Select</div>
                </div>
    <select name="select_Discount" id="mySelect" onchange="this.form.submit()">
        <option>---</option>
        <c:forEach var="j" items="${sessionScope.show_dis}">
<option value="${j.dispercent}">${j.disname} / ${j.dispercent}</option>
        </c:forEach>
<%--        <option >choose</option>--%>
<%--        <option value=0.2>20</option>--%>
<%--        <option value=0.3>30</option>--%>
<%--        <option value=0.5>50</option>--%>
<%--        <option value=1>origin</option>--%>
    </select>
            </div>
        </div>
    </div>


<%--<input name="Confirm" value="Confirm" type="submit" id ="Conf">--%>
</form>

<div class="container">

    <div  style="margin-top:50px;" class="mainbox col-md-99 col-md-offset-3 col-sm-8 col-sm-offset-2">
        <div class="panel panel-info" >
            <div class="panel-heading" style="height: 60px;padding:0 ;" >
                <div class="panel-title" style="font-size: 35px">After ${requestScope.SD} Doscount</div>
            </div>
<%--<h1 >---${requestScope.SD}</h1>--%>
<c:set value="0" var="sum" />
            <table frame="border" rules="all" class="table table-hover" style="font-size: 30px">
                <tr class="bg-primary midd">
                    <th  scope="col">Name</th>
                    <th  scope="col">Check number</th>
                    <th  scope="col">Price</th>
                </tr>
<c:forEach var="i" items="${sessionScope.After_Discount}">
                <tr>
                    <td  style="vertical-align: middle">${i.memuname}</td>
                    <td  style="vertical-align: middle"> ${i.checknumber}</td>
                    <td  style="vertical-align: middle">${i.dprice}</td>
                </tr>
<%--    <h1>${i.memuname}/ ${i.checknumber}  / ${i.price}</h1>--%>
<%--    <h1>${i.memuname}/ ${i.checknumber}  / ${i.dprice}</h1>--%>
    <c:set value="${sum + i.dprice}" var="sum" />
</c:forEach>
<h1>After Discount Total ${sum}</h1>
            </table>


<form action="AFDiscount" method="post">
<c:if test="${sessionScope.After_Discount!=null}">
        <input name="Check_out" value="Check_out" type="submit" class="btn btn-success btn-lg">

</c:if>


</form>
<form action="check_outback" method="post">
<%--    <input type="submit" value="back page">--%>

    <div class="col-md-12 control">
        <button type="submit" class="btn btn-warning btn-lg">
            <span class="glyphicon glyphicon-home"></span></button>
    </div>
</form>
        </div>
    </div>
</div>
</body>
</html>
