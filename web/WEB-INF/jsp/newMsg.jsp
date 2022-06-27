<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta http-equiv="pragma" content="no-cache"/>
    <meta http-equiv="cache-control" content="no-cache"/>
    <title>短消信平台</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/static/css/sms.css"/>
</head>


<body>
<form action="${pageContext.request.contextPath}/reply" method="get" onsubmit="return check()">
    <div id="main">
        <div class="mainbox">
            <div class="menu">
                <span>当前用户：${user.username}</span>
                <span><a href="${pageContext.request.contextPath}/main">返回</a></span>
                <span><a href="${pageContext.request.contextPath}/index.jsp">退出</a></span>
            </div>
            <div class="content">
                <div class="message">
                    <div class="tmenu">
                        <ul class="clearfix">
                            <li>
                                发送给：
                                
                                <select  name="first"  >
                                 <c:forEach var="message" items="${username}"  >
                                   	<option  contenteditable="false">
                                    ${message}
                                  </option>
                                   </c:forEach>
                                </select>
                                  
                            </li>
                            <li>
                                标题：<input type="text" name="title" id="title"/>
                            </li>
                        </ul>
                    </div>
                    <div class="view">
                        <textarea name="content" id="content">${message.content }</textarea>
                        <div class="send">
                            <input type="submit" name="submit" value=" "/>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</form>

<script type="text/javascript">
    function check() {
        var title = document.getElementById("title");
        var content = document.getElementById("content");
        if (title.value == "") {
            alert("标题不能为空！");
            return false;
        } else if (content.value == "") {
            alert("内容不能为空！");
            return false;
        }
        return true;
    }
</script>
</body>
</html>
