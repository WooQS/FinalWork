<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>短消息平台</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/static/css/sms.css"/>
</head>

<body>
<div id="regTitle" class="png"></div>
<div id="regForm" class="userForm png">
    <span id="msg"></span>
    <form action="${pageContext.request.contextPath}/register" onsubmit="return check()" method="get">
        <dl>
            <div id="error"></div>
            <dt>用 户 名：</dt>
            <dd>
                <input type="text" name="username" id="username"/>
            </dd>
            <dt>密 码：</dt>
            <dd>
                <input type="password" name="password" id="password"/>
            </dd>
            <dt>确认密码：</dt>
            <dd>
                <input type="password" name="affirm" id="affirm"/>
            </dd>
            <dt>邮 箱：</dt>
            <dd>
                <input type="text" name="email" id="email"/>
            </dd>
        </dl>
        <div class="buttons">
            <input class="btn-reg png" type="submit" name="register" value=" " id="submit"/>
            <input class="btn-reset png" type="reset" name="reset" value=" "/>
        </div>
        <div class="goback">
            <a href="${pageContext.request.contextPath}/index.jsp" class="png">返回登录页</a>
        </div>
    </form>
</div>
<script type="text/javascript">
    function check() {
        var username = document.getElementById("username");
        var password = document.getElementById("password");
        var affirm = document.getElementById("affirm");
        var email = document.getElementById("email");
        if (username.value == "") {
            alert("用户名不能为空！");
            return false;
        } else if (password.value == "") {
            alert("密码不能为空！");
            return false;
        } else if (password.value != affirm.value) {
            alert("两次密码不同！");
            return false;
        } else if (email.value == "") {
            alert("邮箱不能为空！");
            return false;
        }
        return true;
    }
</script>
</body>
</html>
