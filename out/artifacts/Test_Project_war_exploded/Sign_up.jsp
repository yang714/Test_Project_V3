<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 2020/6/3
  Time: 上午 01:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Sign UP</title>
    <%--  <script src="js/check_login_char_number.js"/>--%>


    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">

    <!-- Optional theme -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap-theme.min.css" integrity="sha384-6pzBo3FDv/PJ8r2KRkGHifhEocL+1X2rVCTTkUfGk7/0pbek5mMa1upzvWbrUbOZ" crossorigin="anonymous">

    <!-- Latest compiled and minified JavaScript -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js" integrity="sha384-aJ21OjlMXNL5UyIl/XNwTMqvzeRMZH2w8c5cRVpzpU8Y5bApTppSuUkhZXN0VxHd" crossorigin="anonymous"></script>
</head>
<body>
<div class="container">
    <div id="loginbox" style="margin-top:50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
        <div class="panel panel-info" >
            <div class="panel-heading" style="height: 60px;padding:0 ;" >
                <div class="panel-title" style="font-size: 35px">
<%--<h1>hello ${um.id}</h1>--%>

<%
    HttpSession sessionsa = request.getSession(false);
//    out.print(sessionsa.getAttribute("login_um_id_number"));
    if(sessionsa.getAttribute("login_um_id_number")!=null){
%>
hello BOSS
<%
}
else{
%>
hello USER
<%
}
%>
                   Sign up
                </div>
            </div>
<form action="Signup" method="post">
    <div style="margin-bottom: 25px" class="input-group input-group-lg">
        <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
<%--    <label for="suus_id">sign_input_usID</label>--%>
    <input id="suus_id" name="suus_id"  class="form-control" placeholder="Username">
    </div>
    <div style="margin-bottom: 25px" class="input-group input-group-lg">
        <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
<%--    <label for="suus_pw">sign_input_usPW</label>--%>
<%--    <input id="suus_pw" name="suus_pw" pattern="(?=.*\d)(?=.*[a-zA-Z]).{4,}" type="password">--%>
    <input id="suus_pw" name="suus_pw" pattern="(?=.*\d)(?=.*[a-zA-Z]).{4,}" type="password"  class="form-control " placeholder="PassWord">
    </div>
    <div style="border-top: 1px solid#888; padding-top:15px; color: red ">
        必須包含4個或更多字符，至少包含一個數字和英文
    </div>
    <br>
    <%

//        out.print(sessionsa.getAttribute("login_um_id_number"));
//    if(sessionsa.getAttribute("login_um_id_number")!=null){
        if(sessionsa.getAttribute("login_um_id_number")!=null){
            if((int)sessionsa.getAttribute("login_um_id_number")==0){
    %>
    <%--    <input type="submit" value="jojojo" name="jojojo" />--%>
    <div style="margin-bottom: 25px" class="input-group input-group-lg ">
    <select name="select_UorM"  class="form-control" >
        <option value="0">Boss</option>
        <option value="1"  SELECTED>User</option>
    </select>
        </div>
    <%
            }
           }
        else{%>
    <select name="select_UorM" style='display:none' class="selectpicker">

        <option value="1"  SELECTED>user</option>

    </select>
    <%
        }
    %>
    <br>
    <h2 style="color: red">
    <%
        if(request.getAttribute("message")!= null){
            out.print(request.getAttribute("message"));
        }

    %>
        </h2>



    <input type="submit" value="Sign_SU" name="Sign_up" class="btn btn-success" />

</form>
<form action="index.jsp" method="post">
    <input type="submit" value="back" class="btn btn-danger">
</form>

</div>
        </div>

    </div>

</body>
</html>
