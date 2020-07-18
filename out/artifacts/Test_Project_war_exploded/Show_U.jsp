<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 2020/6/11
  Time: 下午 12:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Show User</title>
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
<%--<%--%>
<%--for(int j=0;j<(int)request.getAttribute("leng_show_model");j++){--%>
<%-- --%>
<%--}%>--%>
<%--<c:forEach var="i" begin="1" end="5">--%>

<%--    <h1><c:out value="${i.id}" /></h1>--%>
<%--</c:forEach>--%>

<form action="show_user_D" method="post">
    <div class="table-responsive-lg">

<table frame="border" rules="all" class="table table-hover" style="font-size: 30px">
<%--    <h1> ${i.id_number}  ${i.id} ${i.date} ${i.UM_number}</h1> <p>--%>
    <tr class="bg-primary midd">
     <th scope="col">ID_number</th>
    <th scope="col">ID</th>
    <th scope="col">Date</th>
    <th scope="col">UM_number</th>
        <th scope="col">delete</th>
    </tr>
    <c:forEach var="i" items="${show_model}">
    <tr >
        <td style="vertical-align: middle">${i.id_number}</td>
        <td style="vertical-align: middle">${i.id}</td>
        <td style="vertical-align: middle">${i.date}</td>
        <td style="vertical-align: middle">${i.UM_number}</td>
        <td style="vertical-align: middle">
      <button value="${i.id_number}" name="user_infor" class="btn btn-danger btn-lg" style="font-size: 30px">
       <span class="glyphicon glyphicon-remove"></span></button>
        </td>
<%--        <td><input value="${i.id}" name="test" type="submit"></td>--%>
    </tr>

    </c:forEach>
<%--<h1>  ${i.id} ${i.id_number} ${i.date} ${i.um_number}</h1> <p>--%>

    </table>
    </div>
<%--<h1> HI jojo ${show_model[0].UM_number}</h1>--%>

</form>

<%--<form action="User_page.jsp" method="post">--%>
<%--    <div class="col-md-12 control">--%>
<%--    <input type="submit" value="Main page" class="btn btn-warning btn-lg">--%>
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
