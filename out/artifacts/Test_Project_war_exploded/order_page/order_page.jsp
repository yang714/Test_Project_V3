<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 2020/6/17
  Time: 上午 01:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Order</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">

    <!-- Optional theme -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap-theme.min.css" integrity="sha384-6pzBo3FDv/PJ8r2KRkGHifhEocL+1X2rVCTTkUfGk7/0pbek5mMa1upzvWbrUbOZ" crossorigin="anonymous">

    <!-- Latest compiled and minified JavaScript -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js" integrity="sha384-aJ21OjlMXNL5UyIl/XNwTMqvzeRMZH2w8c5cRVpzpU8Y5bApTppSuUkhZXN0VxHd" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <style>
        @import url("CSS/order.css");
    </style>
</head>
<body>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script>
    $(window).on('load', function (){
        var i=0;
        $("#ADDD_meal").click(function () {
            document.getElementById("demo").innerHTML = "kpk777p";
            var idn=$("#select_meal").val();


            $('#order_table').append("<tr id="+i+" ><td>"+
                "<input type='hidden' readonly='readonly'  name='meal_ID' value="+ $("#select_meal").val()+">"+
                "<input readonly='readonly'  name='meal_name' value="+ $("#select_meal option:selected").text() +">"+
                "</td><td>" +
                "<input   name='meal_number' value="+ $("#meal_number").val() +">"

                +"</td><td><button class='btn btn-danger btn-lg' type='submit'  id='m_delete' ONCLICK='DeleteFunction(this)' value="+i+"><span class='glyphicon glyphicon-remove'></span></button></td><td>"+i+"</td></tr>"
                // +"</td><td><input type='button'  id='m_delete' ONCLICK='DeleteFunction(this)' value="+i+"></td><td>"+i+"</td></tr>"
                )

            // $('#order_table').append("<tr id=i><td>"+
            //     $("#select_meal option:selected").text()+"</td><td>" +
            //     $("#meal_number").val()+"</td><td><input type='button'  id='m_delete' ONCLICK='DeleteFunction()' value='Delete'></td></tr>")
            i=i+1;

        })
    })

    // $('#order_table').on("click", "#m_delete", function() {
    //     $('#'+i).remove();
    // });
    function DeleteFunction(r) {

        // $('#order_table').on("click", "#m_delete", function() {
        //     $('#'+r.value).remove();
        // });
        // document.getElementById('order_table')
        // alert($("#"+r+" tr").val());
        // alert(r.value);
        // $(r.value).remove();
        // var i=r
        // document.getElementById('order_table').deleteRow(r.value);
        document.getElementById(r.value).remove();
        // $(i).remove();
        // $('#'+r.value).remove()
        // $(this).closest('tr').remove()
    }
    // function myFunction() {
    //     document.getElementById("demo").innerHTML = "Hello World";
    // }

</script>
<div class="widget-content">
<p id="demo"></p>

    <form action="Order" method="post">
        <div class="container">
    <div  style="margin-top:50px;" class="mainbox col-md-99 col-md-offset-3 col-sm-8 col-sm-offset-2">
        <div class="panel panel-info" >
<%--            <div class="table-responsive-lg">--%>
            <div class="panel-heading table-responsive-lg" style="height: 60px;padding:0 ;" >
                <div class="panel-title" style="font-size: 35px">Order</div>
            </div>
<%--    <h1>select Table ${sessionScope.user_id}</h1>--%>
    <div style="margin-bottom: 25px" class="input-group input-group-lg">
    <select name="select_table_name" onchange="this.form.submit()" class="selectpicker form-control">
        <option>-</option>
<%--        <c:if test=""--%>
            <c:forEach var="j" items="${sessionScope.sql_table_name}">
                <option>${j.table_name}</option>
            </c:forEach>
    </select>
    </div>
<%--    <input type="submit" value="check_table" name="check_table_name">--%>
    <h1>Area Section ${sessionScope.select_table_name} </h1>
    <c:if test="${sessionScope.sql_table_name!=null}">
        <h1>Section Is ${sessionScope.select_table_name} : ${sessionScope.select_table_number}</h1>
   <div style="margin-bottom: 25px" class="input-group input-group-lg">
        <select name="select_table_number" onchange="this.form.submit()" class="selectpicker form-control" >
            <option>-</option>
            <c:forEach var="i" items="${sessionScope.sql_table_number}">
            <option>${i.table_number}</option>
        </c:forEach>
        </select>
   </div>
<%--        <input type="submit" value="check_table_number" name="check_table_number">--%>




</form>
    <form action="OutOrder" method="post">
            <%--    <input type="submit" value="out" name="out" >--%>
        <div class="col-md-12 control">
            <button type="submit" class="btn btn-warning btn-lg">
                <span class="glyphicon glyphicon-home"></span></button>
        </div>
    </form>
</div>
</div>
</div>
    </c:if>

<%--    <c:if test="${sessionScope.select_table_number!='-'}">--%>

<%--            <form >--%>
                <form action="Test_meal" method="post">
                    <c:if test="${sessionScope.select_table_name!=null}">
<%--                    <h1>order</h1>--%>
                    <table id="order_table" name="order_table" class="table table-striped table-bordered table table-hover" style="font-size: 30px">
                    </table>
                    <br>

                        <div class="table-responsive-lg">
                <table class="table table-striped table-bordered table table-hover" style="font-size: 30px">

                <tr>
                    <th scope="col" style="font-size: 30px">meal</th>
                    <th scope="col">number</th>
                        <%--            <th>change</th>--%>
                    <th scope="col">option</th>
                </tr>
                <tr >
                    <td style="font-size: 30px">
                        <select name="meal_order" id="select_meal" class="selectpicker" >
                        <c:forEach var="i" items="${sessionScope.shoew_memu}">
                            <option value=${i.memu_ID}>${i.memu_name}</option>
                        </c:forEach>
                    </select>
                    </td>


                <td style="vertical-align: middle">
                    <input type="number" name="meal_number" min="1" id="meal_number" value="1">
                </td>

                <td style="vertical-align: middle">
<%--                    <input type="reset" id="ADDD_meal" name="ADD_meal" value="add_meal">--%>
<%--                    <input type="reset" name="clear" value="預設值">--%>
                    <button type="reset"  id="ADDD_meal" value="add_meal" name="ADD_meal" class="btn btn-success btn-lg">
                        <span class="glyphicon glyphicon-plus"></span></button></td>

                </tr>
            </table>
<%--                            <input type="submit" value="send" name="send" >--%>
                            <div class="col-md-12 control">
                                <button type="submit" class="btn btn-danger btn-lg">
                                    <span class="glyphicon glyphicon-send"></span></button>
                            </div>
</c:if>
<%--                    <input type="submit" value="out" name="out" >--%>

                </form>

</div>
<%--</form>--%>
<%--<form action="User_page.jsp" method="post">--%>
<%--    <input type="submit" value="Main page">--%>
<%--</form>--%>
</div>

</body>
</html>
