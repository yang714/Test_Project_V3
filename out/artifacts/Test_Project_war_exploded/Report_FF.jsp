<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 2020/7/5
  Time: 上午 03:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 2020/7/4
  Time: 下午 05:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Report Income</title>
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

    <link rel="stylesheet" href="//apps.bdimg.com/libs/jqueryui/1.10.4/css/jquery-ui.min.css">
    <script src="//apps.bdimg.com/libs/jquery/1.10.2/jquery.min.js"></script>
    <script src="//apps.bdimg.com/libs/jqueryui/1.10.4/jquery-ui.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.6.0/Chart.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.13.0/moment.min.js"></script>

</head>
<body>

<%--<h1>The onclick Event</h1>--%>

<%--<h1>sessionScope hello : ${sessionScope.login_um_id}</h1>--%>
<div class="container">
<div id="loginbox" style="margin-top:50px;" class="mainbox col-md-99 col-md-offset-3 col-sm-8 col-sm-offset-2">
    <div class="panel panel-info" >
        <div class="panel-heading" style="height: 60px;padding:0 ;" >
            <div class="panel-title" style="font-size: 35px">Report</div>
        </div>
<form action="DOT" method="post">
    <div style="margin-bottom: 25px" class="input-group input-group-lg">
        <div>
    <input type="submit" value="Date" name="date"  class="btn btn-primary btn-lg "style="margin-right: 50px">
            <input type="submit" value="ALL Month Year" name="total" class="btn btn-primary btn-lg">
        </div>



    </div>


<%--    <h1>${requestScope.switch_day}  1</h1>--%>
</form>

<c:choose>

    <c:when test="${sessionScope.type=='date'}">
        <form action="RR" method="post">


            <div style="margin-bottom: 25px" class="input-group input-group-lg">
                <span class="input-group-addon">起始日期：</span>
            <input type="text" class="datepicker form-control" name="date1" value="${sessionScope.d1}">
            </div>
            <div style="margin-bottom: 25px" class="input-group input-group-lg">
                <span class="input-group-addon">結束日期：</span>
            <input type="text" class="datepicker form-control" name="date2" value="${sessionScope.d2}">
            </div>
                    <%--            <p>起始日期：<input type="text" class="datepicker form-control" name="date1" value="${sessionScope.d1}"></p>--%>
<%--            <p>結束日期：<input type="text" class="datepicker form-control" name="date2" value="${sessionScope.d2}"></p>--%>
        <input type="submit" value="Report" name="Report" class="btn btn-success btn-lg ">


        </form>
    </c:when>


    <c:when test="${sessionScope.type=='total'}">
        <form action="RRR" method="post">
            <div style="margin-bottom: 25px" class="input-group input-group-lg">
        <select name="select_YM"  class="selectpicker">
            <option value="M"> Month</option>
            <option value="Y">Year</option>
        </select>
            </div>
                <input type="submit" value="Report" name="Report" class="btn btn-success btn-lg ">

        </form>
    </c:when>

</c:choose>


<form action="RepCbox" method="post">
        <c:choose>
        <c:when test="${requestScope.check!=null}">
<%--            <div>food_type</div>--%>
<%--            <c:forEach var="i" items="${food_type}"  varStatus="idxStatus">--%>
<%--                <input name="Check_out_box_type" type="checkbox" id="f+${i.meal_ID}+"  value=${i.meal_ID} >--%>
<%--                <label for='f${i.meal_ID}'>${i.food_type} </label>--%>
<%--            </c:forEach>--%>
<%--            <h1>-----------------------------</h1>--%>
<%--            <div>memu</div>--%>
<%--            <c:forEach var="j" items="${show_memu}"  varStatus="idxStatus">--%>
<%--                <input name="Check_out_box_memu" type="checkbox" id="m+${j.memu_ID}+"  value=${j.memu_ID} >--%>
<%--                <label for='m${j.memu_ID}'>${j.memu_name} </label>--%>
<%--            </c:forEach>--%>
<%--            <br>--%>
<%--            <h1>---------------------</h1>--%>
<%--            <input type="submit" value="ReportC" name="ReportC">--%>
   </div>
</div>
</div>
            <canvas id="example"  style="width:50%;"></canvas>
        </c:when>

        </c:choose>
    <br>

    </form>
<%--<canvas id="example" width="400" height="200"></canvas>--%>

<%--<div>--%>
<%--    <c:choose>--%>
<%--        <c:when test="${requestScope.type!=null}">--%>
<%--            <form action="REP" method="post">--%>
<%--                <select name="food_type" onchange="this.form.submit()">--%>
<%--                    <c:forEach var="j" items="${requestScope.food_type}">--%>
<%--                        <option value="${j.meal_ID}">${j.food_type}</option>--%>
<%--                    </c:forEach>--%>
<%--                </select>--%>

<%--            </form>--%>
<%--        </c:when>--%>
<%--    </c:choose>--%>
</div>


<%--<input type="submit" onclick="myFunction()">--%>
<%--<p id="demo"></p>--%>
<script>
    var c=0;
    var label_D=[]
    var incom=[]
    <c:forEach var="j" items="${sessionScope.Rep_eachday}"  varStatus="idxStatus" >
    <%--label_D.push("${j.DD}" )--%>
    label_D.push("${j.DATE}" )
    incom.push(${j.income})
    </c:forEach>

    var labelso= ['Income'];
    var ctx = document.getElementById( "example" ),example = new Chart(ctx, {
        type: "line", // 圖表類型
        data: {
            labels:label_D,
            datasets: [{
                label:labelso[0],
                data: incom,
                fill: false,
                backgroundColor: "rgba(0,148,255,0.6)",
                borderColor: "rgba(0,148,255,0.6)"

            }
                // ,{
                //     label:labelso[1],
                //     data: [7,8,10],fill: false,
                //     backgroundColor:  "#FF0004",
                //     borderColor:  "#FF0004"
                //
                // }
                ]
        }
    })
    function myFunction() {
        alert(label_D)
        document.getElementById("demo").innerHTML = label_D;
    }
</script>

<script>
    $(function() {
        $( ".datepicker" ).datepicker({ maxDate: new Date(),dateFormat: 'yy-mm-dd'
        });
    });
</script>
<%--<form action="RbackM" method="post">--%>
<%--    <input type="submit" value="Main page">--%>
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
