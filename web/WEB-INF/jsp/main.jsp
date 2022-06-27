<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="pragma" content="no-cache" />
<meta http-equiv="cache-control" content="no-cache" />
<title>短消信平台</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/static/css/sms.css" />
</head>
<body>
	<div id="main">
		<div class="mainbox">
			<div class="title myMessage png"></div>
			<div class="menu">
				<span>当前用户 ${user.username}</span> <span><a
					href="${pageContext.request.contextPath}/new">发短消息</a></span> <span><a
					href="${pageContext.request.contextPath}/outLogin">退出</a></span>
			</div>
			<div id="error"></div>
			<div class="content messageList">
				<ul id="content">
					<c:forEach var="message" items="${messageList}">
						<li><em>${message.create_time}</em> <em><a
								href="${pageContext.request.contextPath}/toReplay?id=${message.id}">回信</a></em>
							<em><a
								href="${pageContext.request.contextPath}/delete?id=${message.id}">删除</a></em>
							<p>
								<strong> <a
									href="${pageContext.request.contextPath}/read?id=${message.id}">${message.title}</a>
								</strong>
							</p></li>
					</c:forEach>
				</ul>
			</div>
			<div style="text-align: right">
				<%--if else的写法--%>
				<c:choose>
					<c:when test="${pageInfo.page==1}">
						<a href="##">上一页</a>
					</c:when>
					<c:otherwise>
						<a
							href="${pageContext.request.contextPath}/main?page=${pageInfo.page-1}&limit=${pageInfo.limit}">上一页</a>
					</c:otherwise>
				</c:choose>

				<c:choose>
					<c:when test="${pageInfo.page==pageInfo.totalPage}">
						<a href="##">下一页</a>
					</c:when>
					<c:otherwise>
						<a
							href="${pageContext.request.contextPath}/main?page=${pageInfo.page+1}&limit=${pageInfo.limit}">下一页</a>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</div>
</body>
</html>
