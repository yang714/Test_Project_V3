<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 2020/7/4
  Time: 上午 03:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="//apps.bdimg.com/libs/jqueryui/1.10.4/css/jquery-ui.min.css">
    <script src="//apps.bdimg.com/libs/jquery/1.10.2/jquery.min.js"></script>
    <script src="//apps.bdimg.com/libs/jqueryui/1.10.4/jquery-ui.min.js"></script>
    <script src="./libs/jquery/1.10.1/jquery.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <link rel="stylesheet" href="jqueryui/style.css">
    <script  type="text/javascript">
        function myFunction() {
            var date=new Date();
            alert(date)
            // document.getElementById("demo").innerHTML = "Hello World";
        }
        $(function() {

            $( ".datepicker" ).datepicker({ maxDate: new Date(),dateFormat: 'yy-mm-dd'
            });
        });
    </script>
</head>
<body>

<%--<form action="RR" method="post">--%>


<%--<p>日期1：<input type="text" class="datepicker" name="date1"></p>--%>
<%--<p>日期2：<input type="text" class="datepicker" name="date2"></p>--%>
<%--<input type="submit" value="report" name="report">--%>
<%--&lt;%&ndash;    <input  value="jojo" type="submit" name="check" onclick="myFunction" >&ndash;%&gt;--%>

<%--</form>--%>
<button onclick="myFunction"> 123</button>
</body>
</html>
