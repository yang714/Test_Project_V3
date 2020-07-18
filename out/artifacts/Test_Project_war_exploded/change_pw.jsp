<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 2020/6/5
  Time: 下午 02:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Change PassWord</title>
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
<form action="U_action_changepw" method="post">
<%--    <h1>hello ${um.id}</h1>--%>
<%--    <h1>testing....${um.pw}</h1>--%>
    <div class="container">

        <div id="loginbox" style="margin-top:50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
            <div class="panel panel-info" >
                <div class="panel-heading" style="height: 60px;padding:0 ;" >
                    <div class="panel-title" style="font-size: 35px">Change PassWord</div>
                </div>
                <div class="col-md-99 control">
<%--<label for="us_pw" >old_pw</label>--%>
<%--<input id="us_pw" name="us_pw" pattern="(?=.*\d)(?=.*[a-zA-Z]).{4,}" type="password">--%>
    <div style="margin-bottom: 25px" class="input-group input-group-lg">
                <div style="margin-bottom: 25px" class="input-group input-group-lg">
                    <span class="input-group-addon"><i class="glyphicon glyphicon-off"></i></span>
                <input id="us_pw" name="us_pw" pattern="(?=.*\d)(?=.*[a-zA-Z]).{4,}"  class="form-control">
                </div>
<%--<label for="new_us_pw" >new_pw</label>--%>
                <div style="margin-bottom: 25px" class="input-group input-group-lg">
                    <span class="input-group-addon"><i class="glyphicon glyphicon-pencil"></i></span>
<input id="new_us_pw" name="new_us_pw" pattern="(?=.*\d)(?=.*[a-zA-Z]).{4,}"  class="form-control">
                </div>
<%--<input id="new_us_pw" name="new_us_pw" pattern="(?=.*\d)(?=.*[a-zA-Z]).{4,}" type="password">--%>
<input type="submit" value="check"  class="btn btn-success">
</form>
<h1 style="color: red">${requestScope.messagepw}</h1>
</div>

<form action="User_page.jsp" method="post">
<%--    <input type="submit" value="Main page"  class="btn btn-warning btn-lg glyphicon glyphicon-home">--%>
    <button type="submit" class="btn btn-warning btn-lg">
        <span class="glyphicon glyphicon-home"></span></button>
</form>

</div>
</div>
</div>
</div>
</div>
</body>
</html>
