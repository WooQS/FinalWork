<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>短消息平台</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/static/css/sms.css"/>
</head>
<body>
<div id="main">
    <div class="mainbox" >
        <div class="title readMessage png"></div>
        <div class="menu">
            <span>当前用户：${user.username}</span>
            <span><a href="${pageContext.request.contextPath}/new">发送信息</a></span>
            <span><a href="${pageContext.request.contextPath}/main">返回</a></span>
            <span><a href="${pageContext.request.contextPath}/index.jsp">退出</a></span>
        </div>

        <div class="content">

            <div class="message">
                <div class="tmenu">
                    <ul class="clearfix">

                        <li>题目：${message.title}</li>
                        <li>来自：${message.username}</li>
                        <li>时间：${message.create_time}</li>

                    </ul>
                </div>
                <div class="view">
                    <p>
                        ${message.content}
                    </p>
                </div>
            </div>

        </div>

    </div>
</div>
</body>
</html>
