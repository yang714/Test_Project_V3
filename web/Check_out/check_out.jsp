<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 2020/6/22
  Time: 下午 03:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Check Out</title>
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
<title>Check out </title>
<script>
    // $(window).on('load', function () {
    //     $("#table_click").click(function () {
    //         $('#hh1').append("<input type='hidden' name='you_choose' value="+$("#select_table option:selected").text()+"></input>")
    //         // document.getElementById("hh1").innerHTML = $("#select_table option:selected").text();
    //     })
    // })
    function toggle(source) {
        checkboxes = document.getElementsByName('Check_out_box');
        for(var i=0, n=checkboxes.length;i<n;i++) {
            // if(checkboxes[i].checked==false){
                checkboxes[i].checked = source.checked;

            // checkboxes[i].checked = source.checked;



            var jojo= checkboxes[i].value.split(",");
            var jojomax_number=jojo[1]
            var j=i+1
            if( checkboxes[i].checked && document.getElementById("a"+j)==null){
                $('#'+j).append(
                    "<input style='width: 80px'  id=a"+j+" type='number'  name='test' min='1' max="+jojomax_number+" ''  value="+jojomax_number +" )>"
                )
            }
            else if(checkboxes[i].checked && document.getElementById("a"+j)!=null){
                123;
            }
            else{
                $('#a'+j).remove()
            }

        }
    }
    $(window).on('load', function () {
        $(".container :checkbox").click(function () {

            var testVar = "." + this.value;
            var jojo=this.value.split(",");
            var jojomax_number=jojo[1]
            var idd='a'+jojo[2];

            if (this.checked) {

                // alert(jojo)
                $('#'+jojo[2]).append(
                "<input style='width: 80px' value=1 id=a"+jojo[2]+" type='number'  name='test'  min='1' max="+jojomax_number+" )>"
            )
                // alert(jojo[0]+ ","+ jojo[1]+","+ jojo[2])
                // $('#'+jojo[2]).show();
                // $(testVar).show();
            }
            else {
                // $('#'+jojo[2]);
                $('#a'+jojo[2]).remove();
                // alert("remove"+jojo[0]+ ","+ jojo[1]+","+ jojo[2])
            }
        });
    })
</script>



<%--<h1>Check out id ${sessionScope.user_id}</h1>--%>
<%--<h1>Check out MASTER OR USER ${sessionScope.login_um_id_number}</h1>--%>
<form action="Checkoutdb" method="post">

    <div class="container">
        <div  style="margin-top:50px;" class="mainbox col-md-99 col-md-offset-3 col-sm-8 col-sm-offset-2">
            <div class="panel panel-info" >
                <%--            <div class="table-responsive-lg">--%>
                <div class="panel-heading table-responsive-lg" style="height: 60px;padding:0 ;" >
                    <div class="panel-title" style="font-size: 35px">Check Out</div>
                </div>
                    <h1>Check out name ${sessionScope.login_um_id}</h1>
                    <div style="margin-bottom: 25px" class="input-group input-group-lg">
    <select name="jojo" id="select_table" class="selectpicker form-control">

        <c:forEach var="j" items="${sessionScope.table_name_id}">
            <c:choose>
<%--                <c:when test="${requestScope.table_id==j.table_ID}">--%>
                <c:when test="${sessionScope.table_id==j.table_ID}">
                    <option value=${j.table_ID} SELECTED >${j.tablenamenumber} </option>
                </c:when>
                <c:otherwise>
                    <option value=${j.table_ID}>${j.tablenamenumber} </option>
                </c:otherwise>
            </c:choose>

<%--            <option value="${j.table_ID}">${j.tablenamenumber}</option>--%>
        </c:forEach>
    </select>
                    </div>


    <input type="submit" value="Table Order" id="table_click" name="jojo" class="btn btn-primary btn-lg">


<c:choose>
    <c:when test="${requestScope.order_table_free!=null}">
        <h1 >${requestScope.order_table_free}</h1>

    </c:when>

</c:choose>

        </div>
    </div>

    <c:choose>
    <c:when test="${sessionScope.check_outorder!=null &&requestScope.order_table_free==null}">
       <div class="container">
     <table frame="border" rules="all" class="table table-hover" style="font-size: 30px">

         <tr class="bg-primary midd">
             <th scope="col">Check</th>
             <th scope="col">Name</th>
             <th scope="col">Order number</th>
             <th scope="col">input check</th>
<%--             <th scope="col">????</th>--%>
         </tr>

        <c:forEach var="i" items="${sessionScope.check_outorder}"  varStatus="idxStatus">
         <tr class="midd">

             <td style="vertical-align: middle;"> <input style=" width: 25px;height: 25px" name="Check_out_box" type="checkbox" id="+${i.order_ID}+"  value=${i.order_ID},${i.order_number},${idxStatus.count} ></td>
             <td style="vertical-align: middle"> <label for=${i.order_ID}>${i.memuname}</label>
             <td style="vertical-align: middle">${i.order_number}</td>
             <td style="vertical-align: middle"><div id="${idxStatus.count}"></div></div>

<%--                 <label for=${i.order_ID}>${i.memuname}  /  ${i.order_number}</label>--%>
<%--&lt;%&ndash;            <div id="${idxStatus.count}"></div>&ndash;%&gt;--%>
<%--&lt;%&ndash;            <input type='number'  name='test'  min='1' max=${i.order_number} id=${idxStatus.count}>&ndash;%&gt;--%>
<%--            <div id="${idxStatus.count}">${idxStatus.count}</div>--%>

         </tr>
        </c:forEach>
       </div>
</table>
    <input  class="btn btn-success btn-lg" type="submit" value="Check_out" id="Check_out" name="Check_out">
    <br>
    <input style="width: 30px;height: 30px" type="checkbox" onClick="toggle(this)" id="ALL" />
    <label for="ALL" style="font-size: 30px">ALL</label>
<%--        <button type="submit" value="Check_out" id="Check_out" name="Check_out">CC</button>--%>
    </c:when>
</c:choose>

</form>


<form action="User_page.jsp" method="post">
<%--    <input type="submit" value="Main page">--%>
    <div class="col-md-12 control">
        <button type="submit" class="btn btn-warning btn-lg">
            <span class="glyphicon glyphicon-home"></span></button>
    </div>
</form>

</div>

</body>
</html>
