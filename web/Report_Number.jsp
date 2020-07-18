<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 2020/7/8
  Time: 下午 06:02
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Report sell number</title>
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
<div class="container">
    <div id="loginbox" style="margin-top:50px;" class="mainbox col-md-99 col-md-offset-3 col-sm-8 col-sm-offset-2">
        <div class="panel panel-info" >
            <div class="panel-heading" style="height: 60px;padding:0 ;" >
                <div class="panel-title" style="font-size: 35px">Report</div>
            </div>
<form action="RPN" method="post">
    <div style="margin-bottom: 25px" class="input-group input-group-lg">
        <div>
    <input type="submit" name="Meal" value="Meal" class="btn btn-primary btn-lg "style="margin-right: 50px">
    <input type="submit" name="Memu" value="Memu" class="btn btn-primary btn-lg">
        </div>
    </div>
</form>
<form action="RPCBD" method="post">

    <c:choose>
<%--    <c:when test="${sessionScope.CHtype!=null}">--%>

    <c:when test="${sessionScope.CHtype=='Meal'}">
        <div style="margin-bottom: 24px" class="input-group input-group-lg">
        <div class="form-check">
<%--                    <div>food_type</div>--%>

      <c:forEach var="i" items="${food_type}"  varStatus="idxStatus">
    <div class="form-check ">
<%--        <label style="font-size: 2em" >--%>
          <input name="Check_out_box" type="checkbox" id="f+${i.meal_ID}+"  value=${i.meal_ID} >
<%--    <label style="font-size: 2em" >--%>
<%--            <span class="cr"><i class="cr-icon fa fa-check" style="font-size: 25px"> ${i.food_type} </i></span>--%>

            <label for='f${i.meal_ID}' style="font-size: 25px">${i.food_type} </label>
<%--                        <span class="label-text">${i.food_type}</span>--%>
<%--        </label>--%>
    </div>
      </c:forEach>
<%--        <h1>-----------------------------</h1>--%>
    </div>
    </div>
        <input type="submit" name="chooseMM" VALUE="Meal_SUB" class="btn btn-success btn-lg">
    </c:when>
    <c:when test="${sessionScope.CHtype=='Memu'}">
        <div style="margin-bottom: 24px" class="input-group input-group-lg">
<%--    <div>memu</div>--%>
    <div class="form-check">
    <c:forEach var="j" items="${show_memu}"  varStatus="idxStatus">
        <div class="form-check">
        <input name="Check_out_box" type="checkbox" id="m+${j.memu_ID}+"  value=${j.memu_ID} >
        <label for='m${j.memu_ID}' style="font-size: 25px">${j.memu_name} </label>
<%--            <span class="cr"><i class="cr-icon fa fa-check" style="font-size: 25px">${j.memu_name} </i></span>--%>
        </div>
    </c:forEach>
    </div>
<%--        <h1>---------------------</h1>--%>
        </div>
        <input type="submit" name="chooseMM" VALUE="Memu_SUB" class="btn btn-success btn-lg">
    </c:when>



</c:choose>
<%--    <h1>${sessionScope.CHtype}</h1>--%>
<c:choose>

        <c:when test="${sessionScope.CHtype!=null}">
    <div style="margin-bottom: 25px" class="input-group input-group-lg">
            <select name="getYear" class="selectpicker">
        <c:forEach var="i" items="${sessionScope.getYear}"  varStatus="idxStatus">
            <option value="${i}">${i}</option>
        </c:forEach>
<%--        <option>----</option>--%>
    </select>
    <select name="getMonth" class="selectpicker">
        <option value="1">1</option>
        <option value="2">2</option>
        <option value="3">3</option>
        <option value="4">4</option>
        <option value="5">5</option>
        <option value="6">6</option>
        <option value="7">7</option>
        <option value="8">8</option>
        <option value="9">9</option>
        <option value="10">10</option>
        <option value="11">11</option>
        <option value="12">12</option>
        <option value="13">all</option>

    </select>
    </div>
            </div>
        </c:when>
<%--    <h1>${sessionScope.chooseMM}  !!</h1>--%>

</c:choose>
</form>




<c:choose>
    <c:when test="${sessionScope.chooseMM!=null}">
<%--        <h1>${sessionScope.year} / ${sessionScope.Mon} </h1>--%>
<%--        <c:forEach var="j" items="${requestScope.getRAC}">--%>
<%--        <h1>${j.value}</h1>--%>
<%--        </c:forEach>--%>
<%--        <h1>${requestScope.getRAC}</h1>--%>
<%--        <h1>${sessionScope.chooseMM}</h1>--%>
<%--        <h1>${requestScope.getRAC.get("data")}</h1>--%>

    </c:when>
</c:choose>
<%--<form action="RNbackM" method="post">--%>
<%--    <input type="submit" value="Main page">--%>
<%--</form>--%>
    <form action="RNbackM" method="post">
        <%--    <input type="submit" value="Main page"  class="btn btn-warning btn-lg glyphicon glyphicon-home">--%>
        <div class="col-md-12 control">
            <button type="submit" class="btn btn-warning btn-lg">
                <span class="glyphicon glyphicon-home"></span></button>
        </div>

    </form>
</div>
    </div>
</div>
<canvas id="example"  style="width:50%;"></canvas>
<script>
    var c=0;
    var label_D=['test','test123']
    var incom=[]
    var labelso=[]
<%--    <c:forEach var="j" items="${sessionScope.ReportN_data}"  varStatus="idxStatus" >--%>
<%--    &lt;%&ndash;label_D.push("${j.DD}" )&ndash;%&gt;--%>
<%--    labelso.push("${j.meal_name}")--%>
<%--    label_D.push("${j.meal_name}" )--%>
<%--    incom.push(${j.meal_name})--%>
<%--    </c:forEach>--%>
<%--    var labels=${sessionScope.ReportN_data.get()}--%>
<%--    // var labelso= ['Income'];--%>
<%--    var datas=${requestScope.getRAC.get("data")}--%>
<%--    var borderColors=${requestScope.getRAC.get("borderColor")}--%>
<%--    var labelss=${requestScope.getRAC.get("label")}--%>
<%--    <c:forEach var="j" items="${requestScope.getRAC}">--%>
<%--    --%>
<%--    </c:forEach>--%>
    var ctx = document.getElementById( "example" ),example = new Chart(ctx, {
        type: "bar",  // 圖表類型
        data:
        ${requestScope.getRAC}
<%--            {--%>
<%--            labels: ["Africa", "Asia", "Europe", "Latin America", "North America"],--%>
<%--            datasets: [--%>
<%--&lt;%&ndash;                ${requestScope.getRAC}&ndash;%&gt;--%>
<%--                {--%>
<%--                    label: ["Population (millions)"],--%>
<%--                    backgroundColor: ["#3e95cd", "#8e5ea2","#3cba9f","#e8c3b9","#c45850"],--%>
<%--                    data: [2478,5267,734,784,433]--%>
<%--                }--%>
<%--            ]--%>
<%--        }--%>
        ,
        options: {
            legend: { display: false },
            title: {
                display: true,
                text: '${sessionScope.year} / ${sessionScope.Mon}'
            },
            scales: {
                yAxes: [{
                    ticks: {
                        beginAtZero:true
                        // stepSize:1
                    }
                }]
            }

        }
    })
    function myFunction() {
        alert(label_D)
        document.getElementById("demo").innerHTML = label_D;
    }
</script>

<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
</body>
</html>
