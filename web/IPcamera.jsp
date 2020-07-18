<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 2020/7/12
  Time: 上午 04:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="//apps.bdimg.com/libs/jqueryui/1.10.4/css/jquery-ui.min.css">
    <script src="//apps.bdimg.com/libs/jquery/1.10.2/jquery.min.js"></script>
    <script src="//apps.bdimg.com/libs/jqueryui/1.10.4/jquery-ui.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.6.0/Chart.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.13.0/moment.min.js"></script>
    <script type="text/javascript" src="https://flashphoner.com/downloads/builds/flashphoner_client/wcs_api-2.0/current/flashphoner.js"></script>
    <script type="text/javascript" src="player-min.js"></script>
</head>
<body>
<form action="IPC" method="post">
<label for="rtsp_start">Camera_on</label>
<input name="rtsp" id="rtsp_start" type="submit"/>

<label for="rtsp_stop">Camera_off</label>
<input name="rtsp" id="rtsp_stop" type="submit"/>
</form>
</body>

</html>
