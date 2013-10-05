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
    <li   ><a href="userinfo!edit.action">基本信息</a></li>
    <li  class="cur" ><a href="../userinfo!blog.action">博客信息</a></li>
    <li ><a href="userinfo!edit.action">修改头像</a></li>
    </ul>


    <p class="uc-c-nav">
    </p>
    </div>

    <div class="main-block">
    <div class="upload-warn">
    <h3 style="height:100px;line-height:100px;text-align:center;color:#369">
    <c:if test="${empty user.blog || '0' eq user.blog}">
    您还没有开通博客! &nbsp; <a style="color:#369;font-weight:700;" href="userinfo!blogInit.action">请点击开通博客</a>!
    </c:if>
    <c:if test="${not empty user.blog && user.blog > 0}">
    您已经开通博客! &nbsp; <a style="color:#369;font-weight:700;" href="blog!index.action?id=${user.blogId}">点击进入博客</a>!
    </c:if>
    </h3>
    </div>

    </div>
    </div>
    <!--中间栏结束-->
    </div>

    </div>
    <%--主体结束--%>

	<%@include file="../common/foot.jsp"%>

</body>
</html>