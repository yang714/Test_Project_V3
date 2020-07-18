<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 2020/7/3
  Time: 上午 01:09
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
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-select@1.13.14/dist/css/bootstrap-select.min.css">

    <!-- Latest compiled and minified JavaScript -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap-select@1.13.14/dist/js/bootstrap-select.min.js"></script>

    <!-- (Optional) Latest compiled and minified JavaScript translation files -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap-select@1.13.14/dist/js/i18n/defaults-*.min.js"></script>

</head>
<body>
<div class="container">

    <div id="loginbox" style="margin-top:50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
        <div class="panel panel-info" >
            <div class="panel-heading" style="height: 60px;padding:0 ;" >
                <div class="panel-title" style="font-size: 35px">Discount manage</div>
            </div>
            <div class="col-md-99 control">
<form action="Discount" method="post">
<%--    <label for="Dname"> Discount name:</label>--%>
    <div style="margin-bottom: 25px" class="input-group input-group-lg">
        <span class="input-group-addon"><i class="glyphicon glyphicon-tags"></i></span>
    <input type="text" id="Dname" name="Dname"  class="form-control" placeholder="Discount name">
    </div>
    <br>
    <div style="margin-bottom: 25px" class="input-group input-group-lg">
        <span class="input-group-addon"><i class="glyphicon glyphicon-yen"></i></span>
<%--    <label for="Dpercent">Discount percent</label>--%>
    <input type="number" id="Dpercent" value="1.0" step="0.05" min="0.05" max="1" name="Dpercent"
           class="form-control">
    </div>
        <br>


    <input type="submit" value="ADD Discount" name="add_Discount" class="btn btn-success btn-lg">

</form>

<form action="Discountdel" method="post">
    <div style="margin-bottom: 25px" class="input-group input-group-lg">
<input value="Show_total_Discount" name="Show_delete" type="submit" class="btn btn-info btn-lg">

<c:if test="${Show_delete!=null}">

    <select name="select_delete"  class="selectpicker">
        <c:forEach var="j" items="${Show_delete}">
            <option value="${j.disID}">${j.disname} / ${j.dispercent}</option>
        </c:forEach>
    </select>
<input type="submit" value="DelDiscount" name="DelDiscount" class="btn btn-danger btn-lg">
    </div>
        </c:if>
</form >


</div>
<%--            <form action="User_page.jsp" method="post">--%>
<%--                <input type="submit" value="Main page"  class="btn btn-warning btn-lg">--%>
<%--            </form>--%>
            <form action="User_page.jsp" method="post">
                <%--    <input type="submit" value="Main page"  class="btn btn-warning btn-lg glyphicon glyphicon-home">--%>
<%--                <div class="col-md-12 control">--%>
                    <button type="submit" class="btn btn-warning btn-lg">
                        <span class="glyphicon glyphicon-home"></span></button>
<%--                </div>--%>
            </form>
        </div>
    </div>
</div>
</body>
</html>
