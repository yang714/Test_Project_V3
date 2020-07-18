<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 2020/6/1
  Time: 下午 07:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>

    <title>Sign In</title>
      <%--  <script src="js/check_login_char_number.js"/>--%>


      <!-- Latest compiled and minified CSS -->
      <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">

      <!-- Optional theme -->
      <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap-theme.min.css" integrity="sha384-6pzBo3FDv/PJ8r2KRkGHifhEocL+1X2rVCTTkUfGk7/0pbek5mMa1upzvWbrUbOZ" crossorigin="anonymous">

      <!-- Latest compiled and minified JavaScript -->
      <script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js" integrity="sha384-aJ21OjlMXNL5UyIl/XNwTMqvzeRMZH2w8c5cRVpzpU8Y5bApTppSuUkhZXN0VxHd" crossorigin="anonymous"></script>
  </head>
  <body>
<%--<style>--%>
<%--    @import url("CSS/signin.css");--%>
<%--</style>--%>

<div class="container">

    <div id="loginbox" style="margin-top:50px;" class="mainbox col-md-99 col-md-offset-3 col-sm-8 col-sm-offset-2">
        <div class="panel panel-info" >
            <div class="panel-heading" style="height: 60px;padding:0 ;" >
            <div class="panel-title" style="font-size: 35px">Sign In</div>
            </div>
<form action="index" method="post" >
    <div style="margin-bottom: 25px" class="input-group input-group-lg">
        <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
    <input id="us_id" name="us_id" onblur="checknull(this)"  class="form-control" placeholder="Username">
    </div>
        <br>
<%--    <label for="us_pw">input_usPW</label>--%>
<%--    <input id="us_pw" name="us_pw" pattern="(?=.*\d)(?=.*[a-zA-Z]).{4,}" type="password">--%>
    <form action="index" method="post" >
        <div style="margin-bottom: 25px" class="input-group input-group-lg">
            <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
    <input id="us_pw" name="us_pw" pattern="(?=.*\d)(?=.*[a-zA-Z]).{4,}"  class="form-control " placeholder="PassWord">
        </div>
        <div style="border-top: 1px solid#888; padding-top:15px; ">
            必須包含4個或更多字符，至少包含一個數字和英文
        </div>
    <br>
    <input type="submit" value="Login" name="summit" class="btn btn-success">
    <br>
    <h2 style="color: red">

      <%
  if(request.getAttribute("message")!= null){
    out.print(request.getAttribute("message"));
  }

%>

    </h2>




<%--    <h1>out_test...httpSESSION--%>
<%--      <%--%>
<%--      HttpSession sessionsa = request.getSession(false);--%>
<%--      out.print(sessionsa.getAttribute("login_um_id"));--%>
<%--    %>--%>
<%--    </h1>--%>

<%--       <input type="submit" value="Sign_up" name="Sign_up" />--%>
  </form>
    <div class="col-md-12 control">
<form action="sign_up" method="post">
  <input type="submit" value="Sign_up" name="Sign_up"  class="btn btn-primary btn-lg"/>
</form>
    </div>
        </div>
        </div>
</div>

  </body>


</html>
