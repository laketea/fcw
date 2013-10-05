<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<title>房产网-房产资讯</title>
<link type="text/css" rel="stylesheet"
	href="../resource/css/default.css" />

<link type="text/css" rel="stylesheet" href="../resource/css/common.css" />
<link type="text/css" rel="stylesheet"
	href="../resource/css/ui-default.css" />
<link type="text/css" rel="stylesheet"
	href="../resource/css/default.css" />
<link type="text/css" rel="stylesheet" href="../resource/css/news.css" />
</head>
<body>

	<%@include file="../common/top.jsp"%>
	<c:set var="channelName" value="房产资讯" scope="request" />
	<%@include file="../common/head.jsp"%>
	<div id="top-grad"></div>

	<div id="news" class="wrap center960 box ">
		<div id="news-main" class="fl">
			<c:forEach var="item" items="${channelLst}" varStatus="s">
				<div class="news-sub fl">
					<div class="title">
						<span class="fl">${item.name}</span> <span class="fr"><a
							href="#"><img src="../resource/img/tm.png" border="0">
						</a> </span>
					</div>
					<div class="content">
						<ul class="news-ul">
							<c:forEach var="citem" items="${item.newsLst}" varStatus="s">
								<li><a href="">${citem.title}</a><span>${citem.pbTime}</span>
								</li>
							</c:forEach>
						</ul>
					</div>
				</div>
			</c:forEach>



		</div>
		<div id="news-sidebar" class="fr">

			<div class="pmbok">

				<h3>
					最近更新<a title="更多" target="_blank" href="/yhcyzg/ksst/"><img
						align="absmiddle" alt="更多" src="../resource/img/more.png"> </a>
				</h3>
				<ul>

					<c:forEach var="litem" items="${newsLst}" varStatus="s">
						<li><a title="" target="_blank" href="#">${litem.title}</a>
						</li>
					</c:forEach>
				</ul>
				<div class="underline"></div>
			</div>


		</div>
	</div>
	<%@include file="../common/foot.jsp"%>




</body>
</html>