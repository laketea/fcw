<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/include.jsp"%>
<%
	String path = request.getRequestURI();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>房产网-房产资源</title>
<link type="text/css" rel="stylesheet" href="../resource/css/default.css" />

<link type="text/css" rel="stylesheet" href="../resource/css/common.css" />
<link type="text/css" rel="stylesheet" href="../resource/css/ui-default.css" />
<link type="text/css" rel="stylesheet" href="../resource/css/company.css" />
<link type="text/css" rel="stylesheet" href="../resource/css/usercenter.css" />
<script type="text/javascript" src="../resource/js/jquery.js"></script>
<script type="text/javascript" src="../resource/js/blog.js"></script>
<script charset="utf-8" src="../resource/editor/kindeditor.js"></script>
<script charset="utf-8" src="../resource/editor/lang/zh_CN.js"></script>
</head>
<body>
	<%@include file="../common/top.jsp"%>
	<c:set var="channelName" value="房产资源" scope="request" />
	<%@include file="../common/head.jsp"%>
	<div id="top-grad"></div>

	<%--主体开始--%>


	<div id="user-center" class="wrap center960 box ">
		<div class="cur-nav">
			当前位置：<a href="resource!index.action">房资网</a> ><a href="#">用户中心</a>
		</div>
		<div class="user-center-container box">
			<!--左边导航开始-->
			<%@include file="../common/user-center-left.jsp"%>
			<!--左边导航结束-->



			<!--中间栏开始-->
			<div class="uc-main uc-main-style">
				

				<div class="main-block">
					<ul class="uc-nav box">
						<li ${'0' eq flag?'class="cur"':'' }><a href="userart!others.action?flag=0">好友日志</a></li>
						<li><a href="userart!my.action">我的日志</a></li>
						<li ${'1' eq flag?'class="cur"':''}><a href="userart!others.action?flag=1">随便看看</a></li>
						<li class="a-btn"><a href="userart!publish.action">发布日志</a></li>
					</ul>


					<p class="uc-c-nav"></p>
				</div>
				<div class="main-block">
					<ul class="other-wz-ul">
						<c:if test="${empty page.list}">
							<li style='padding: 10px 5px;'>暂无相关文章！</li>
						</c:if>
						<c:forEach var="item" items="${page.list}">
							<li class="box">
								<div class="other-wz-tx fl">
									<a href="#"><img src="../resource/img/testtest.jpg" alt="" width="50" height="50" /> </a>
								</div>
								<div class="other-wz-right box">
									<h2>
										<a href="blogarticle!show.action?id=${item.id}">${item.title}</a>
									</h2>
									<div class="other-wz-zz">
										<a href="">${item.blogName}</a> <span>${item.phTime}</span>
									</div>
									<div class="other-wz-content">${item.s_content}</div>
									<p class="box">
										<a href="#">评论(12)</a><a href="#">阅读(${item.view_count})</a><a href="#">转发</a>
									</p>
								</div>
							</li>

						</c:forEach>

						<c:if test="${not empty page.list}">
							<div class="info-page" style="">
								<pg:pager url="userart!others.action" items="${page.totalRecords}" maxPageItems="15" export="currentPageNumber=pageNumber">
									<pg:param name="flag" value="${flag}" />
									<pg:first>
										<a href="${pageUrl}">首页</a>
									</pg:first>
									<pg:prev>
										<a href="${pageUrl }"><</a>
									</pg:prev>

									<pg:pages>
										<c:choose>
											<c:when test="${currentPageNumber eq pageNumber}">
												<a> <font color="red">${pageNumber }</font></a>
											</c:when>
											<c:otherwise>
												<a href="${pageUrl }">${pageNumber }</a>
											</c:otherwise>
										</c:choose>
									</pg:pages>
									<pg:next>
										<a href="${pageUrl }">></a>
									</pg:next>
									<pg:last>
										<a href="${pageUrl }">尾页</a>
									</pg:last>
								</pg:pager>
							</div>
						</c:if>

					</ul>
				</div>
			</div>
			<!--中间栏结束-->


		</div>

	</div>
	<%--主体结束--%>

	<%@include file="../common/foot.jsp"%>

</body>
</html>