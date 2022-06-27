<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>短消息平台</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/static/css/sms.css"/>
</head>
<body>
<div id="loginTitle" class="png"></div>
<div id="loginForm" class="userForm png">
    <form method="get" name="loginform" action="${pageContext.request.contextPath}/login" onsubmit="return check()">
        <dl>
            <div id="error"></div>
            <dt>用户名：</dt>
            <dd><input type="text" name="username"/></dd>
            <dt>密　码：</dt>
            <dd><input type="password" name="password"/></dd>
        </dl>
        <div class="buttons">
            <input class="btn-login png" type="submit" name="submit" value="" />

            <input class="btn-reg png" type="button" name="register" value=""/>
        </div>
    </form>
</div>

<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
    $(function () {
        $(".btn-reg").bind("click", function () {
          location.href = "${pageContext.request.contextPath}/toRegister";
        });

    });

    $(function () {
        $(".btn-login").bind("click", function () {
            location.href = "/toTitle";
        });
    });

    function check() {
        var username = document.getElementById("username");
        var password = document.getElementById("password");
        var error = document.getElementById("error");
        if (username.value == "") {
            error.innerHTML = "<font color=\"red\">用户名不能为空！</font>";
            username.focus();
            return false;
        } else if (password.value == "") {
            error.innerHTML = "<font color=\"red\">密码不能为空！</font>";
            password.focus();
            return false;
        }
        return true;
    }
</script>
</body>
</html>

