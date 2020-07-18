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
    <title>Title</title>
    <link rel="stylesheet" href="//apps.bdimg.com/libs/jqueryui/1.10.4/css/jquery-ui.min.css">
    <script src="//apps.bdimg.com/libs/jquery/1.10.2/jquery.min.js"></script>
    <script src="//apps.bdimg.com/libs/jqueryui/1.10.4/jquery-ui.min.js"></script>
</head>
<body>

<h1>The onclick Event</h1>

<p>The onclick event is used to trigger a function when an element is clicked on.</p>

<p>Click the button to trigger a function that will output "Hello World" in a p element with id="demo".</p>

<button onclick="myFunction()">Click me</button>
<p>日期1：<input type="text" class="datepicker" name="date1"></p>
<p>日期2：<input type="text" class="datepicker" name="date2"></p>
<p id="demo"></p>

<script>
    function myFunction() {
        var date=new Date();
        alert(date)
        document.getElementById("demo").innerHTML = "Hello World";
    }

    $(function() {

        $( ".datepicker" ).datepicker({ maxDate: new Date(),dateFormat: 'yy-mm-dd'
        });
    });
</script>

</body>
</html>
