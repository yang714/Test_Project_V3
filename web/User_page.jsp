<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 2020/6/5
  Time: 下午 01:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Home Page</title>
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
<%--<h1>hello ${um.id}</h1>--%>


<%--/////////////////////////////--%>
<%--<h1>sessionScope: ${sessionScope.login_um_id}</h1>--%>
<div class="container">

    <div  style="margin-top:50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
        <div class="panel panel-info" >
            <div class="panel-heading" style="height: 60px;padding:0 ;" >
                <div class="panel-title" style="font-size: 35px">Home Page</div>
            </div>
            <div class="col-md-99 control">
<c:choose>
    <c:when test="${sessionScope.login_um_id_number==0}">
        <h1>hello ${sessionScope.login_um_id}</h1>

        <form action="U_dispatchV1" method="post">
            <input type="submit" value="Sing user" name="SIGN_USER" class="btn btn-primary btn-lg">
        </form>

        <form action="Show_U" method="post">
            <input type="submit" value="Show user" name="Show_user" class="btn btn-primary btn-lg">
        </form>

        <form action="Show_Change_memu" method="post">
            <input type="submit" value="Memu Manage" name="Show_Change_memu" class="btn btn-primary btn-lg">
        </form>


        <form action="Discount_Manage.jsp" method="post">
            <input type="submit" value="Discount Manage" class="btn btn-primary btn-lg">
        </form>

        <%--<form action="Report_FF.jsp" method="post">--%>
        <%--    <input type="submit" value="reportFF" >--%>
        <%--</form>--%>
        <form action="Report_FF.jsp" method="post">
            <input type="submit" value="Report Income" class="btn btn-primary btn-lg" >
        </form>

        <form action="Report_Number.jsp" method="post">
            <input type="submit" value="Report Sell" class="btn btn-primary btn-lg">
        </form>
        <form action="IPC" method="post">
            <input type="submit" value="IPCamera"  class="btn btn-primary btn-lg">
        </form>
    </c:when>
    <c:otherwise>
        <h1>hello employ</h1>
    </c:otherwise>


</c:choose>
<form action="U_dispatchv2" method="post">
    <input type="submit" value="Change pw" name="change_pw" class="btn btn-primary btn-lg">
<%--    <input type="submit" value="order" name="order">--%>
</form>
<form action="Order" method="post">
<%--    <input type="submit" value="change_pw" name="change_pw">--%>
    <input type="submit" value="Order" name="order" class="btn btn-primary btn-lg">
</form>

<form action="U_dispatchv3" method="post">
    <input type="submit" value="Checkout" name="checkout" class="btn btn-primary btn-lg">
</form>



<%--/////////////////////////////--%>
<%--    <%--%>
<%--        HttpSession sessionsa = request.getSession(false);--%>
<%--        out.print(sessionsa.getAttribute("login_um_id_number"));--%>
<%--        if((int)sessionsa.getAttribute("login_um_id_number")==0){--%>
<%--%>--%>
<%--<h1>hello BOSS</h1>--%>
<%--    <%--%>
<%--    }--%>
<%--else{%>--%>
<%--<h1>hello USER</h1>--%>
<%--    <%}%>--%>
<%--<form action="U_dispatchv2" method="post">--%>
<%--    <input type="submit" value="change_pw" name="change_pw">--%>
<%--    <input type="submit" value="order" name="order">--%>
<%--&lt;%&ndash;    <input type="submit" value="out">&ndash;%&gt;--%>
<%--&lt;%&ndash;    <input type="submit" value="out">&ndash;%&gt;--%>
<%--&lt;%&ndash;    <input type="submit" value="out">&ndash;%&gt;--%>

<%--    <%--%>

<%--        out.print(sessionsa.getAttribute("login_um_id_number"));--%>
<%--        if((int)sessionsa.getAttribute("login_um_id_number")==0){--%>
<%--    %>--%>
<%--    <br>--%>
<%--    <input type="submit" value="SIGN_USER" name="SIGN_USER">--%>
<%--</form>--%>

<%--    <form action="Show_U" method="post">--%>
<%--    <input type="submit" value="Show_user" name="Show_user">--%>
<%--    </form>--%>

<%--<form action="Show_Change_memu" method="post">--%>
<%--    <input type="submit" value="Show_Change_memu" name="Show_Change_memu">--%>
<%--</form>--%>

<%--        <%--%>
<%--    }%>--%>
<form action="index_SOut" method="post">
    <input type="submit" value="SIGN_OUT" class="btn btn-primary btn-lg">
</form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
