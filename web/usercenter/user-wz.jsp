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
    <li ><a href="user-wz-other.jsp">好友日志</a></li>
    <li class="cur"><a href="user-wz.jsp">我的日志</a></li>
    <li><a href="user-wz-other.jsp">随便看看</a></li>
    <li class="a-btn"><a href="user-wz-new.jsp">发布日志</a></li>
    </ul>


    <p class="uc-c-nav">
    <a href="#" class="cur">全部好友</a>
    <span class="pipe">|</span>
    <a href="#">其他</a>
    <span class="pipe">|</span>
    <a href="#">通过本站认识</a>
    <span class="pipe">|</span>
    <a href="#">通过活动认识</a>
    <span class="pipe">|</span>
    <a href="#">通过朋友认识</a>
    <span class="pipe">|</span>
    <a href="#">亲人</a>
    <span class="pipe">|</span>
    <a href="#">同事</a>
    <span class="pipe">|</span>
    <a href="#">同学</a>

    </p>
    </div>

    <div class="main-block">
    <ul class="my-wz-ul">
    <li>
    <div><a class="wz-title" href="">关于最新测试数据的研究与报告</a></div>
    <div class="wz-btn-link box"><span class="fl">[ 研究报告 ] / 2012-12-21 12:12:12</span>
    <span class="fr"><a href="#">编辑</a> | <a href="#">删除</a>| <a href="#">置顶</a></span>
    </div>
    </li>
    <li>
    <a class="wz-title" href="">关于最新测试数据的研究与报告</a>
    <div class="wz-btn-link box"><span class="fl">[ 研究报告 ] / 2012-12-21 12:12:12</span>
    <span class="fr"><a href="#">编辑</a> | <a href="#">删除</a>| <a href="#">置顶</a></span>
    </div>
    </li>
    <li>
    <a class="wz-title" href="">关于最新测试数据的研究与报告</a>
    <div class="wz-btn-link box"><span class="fl">[ 研究报告 ] / 2012-12-21 12:12:12</span>
    <span class="fr"><a href="#">编辑</a> | <a href="#">删除</a>| <a href="#">置顶</a></span>
    </div>
    </li>
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