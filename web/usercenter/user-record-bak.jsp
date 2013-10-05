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


    <!--右边栏开始-->
    <div class="right-side">
    <div class="right-block">
    <div class="base-info">
    <div class="tx-div fl"><a href="#"><img src="../resource/img/testtest.jpg" width="56" height="56" alt=""></a></div>
    <div class="name-div fl">刘翔</div>
    <div class="name-div fl">VIP</div>
    <div class="name-div fl">普通会员</div>
    </div>
    <ul class="base-count box">
    <li><div>111</div><div>访问</div></li>
    <li><div>111</div><div>好友</div></li>
    <li><div>111</div><div>积分</div></li>
    </ul>
    <a href="#">修改头像</a><a class="change-pwd" href="">修改密码</a></div>

    <div class="user-xg-block">
    <div class="xg-title"><span class=" fl">最新实名认证会员</span><span class="fr" ><a href="#">我要认证</a></span></div>
    <ul class="xg-ul box">
    <li>
    <a href="#" class="xg-tx"><img src="../resource/img/testtest.jpg" width="50" height="50" alt=""></a>
    <a href="#" class="xg-name">刘翔</a>
    </li>
    <li>
    <a href="#" class="xg-tx"><img src="../resource/img/testtest.jpg" width="50" height="50" alt=""></a>
    <a href="#" class="xg-name">刘翔</a>
    </li>
    <li>
    <a href="#" class="xg-tx"><img src="../resource/img/testtest.jpg" width="50" height="50" alt=""></a>
    <a href="#" class="xg-name">刘翔</a>
    </li>
    <li>
    <a href="#" class="xg-tx"><img src="../resource/img/testtest.jpg" width="50" height="50" alt=""></a>
    <a href="#" class="xg-name">刘翔</a>
    </li>
    <li>
    <a href="#" class="xg-tx"><img src="../resource/img/testtest.jpg" width="50" height="50" alt=""></a>
    <a href="#" class="xg-name">刘翔</a>
    </li>
    </ul>
    </div>

    <div class="user-xg-block">
    <div class="xg-title"><span class=" fl">最新注册</span></div>
    <ul class="xg-ul box">
    <li>
    <a href="#" class="xg-tx"><img src="../resource/img/testtest.jpg" width="50" height="50" alt=""></a>
    <a href="#" class="xg-name">刘翔</a>
    </li>
    <li>
    <a href="#" class="xg-tx"><img src="../resource/img/testtest.jpg" width="50" height="50" alt=""></a>
    <a href="#" class="xg-name">刘翔</a>
    </li>
    <li>
    <a href="#" class="xg-tx"><img src="../resource/img/testtest.jpg" width="50" height="50" alt=""></a>
    <a href="#" class="xg-name">刘翔</a>
    </li>
    <li>
    <a href="#" class="xg-tx"><img src="../resource/img/testtest.jpg" width="50" height="50" alt=""></a>
    <a href="#" class="xg-name">刘翔</a>
    </li>
    <li>
    <a href="#" class="xg-tx"><img src="../resource/img/testtest.jpg" width="50" height="50" alt=""></a>
    <a href="#" class="xg-name">刘翔</a>
    </li>
    </ul>
    </div>

    </div>
    <!--右边栏结束-->
    <!--中间栏开始-->
    <div class="uc-main">
    <div class="main-block">
    <h3><a href="#">Laktea</a></h3>
    <div class="uc-input">
    <textarea class="" cols="50" rows="3"></textarea>
    <button>发布</button>
    </div>
    </div>

    <div class="main-block">
    <ul class="uc-nav box">
    <li class="cur"><a href="#">好友动态</a></li>
    <li><a href="#">我的动态</a></li>
    <li><a href="#">随便看看</a></li>
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
    </div>
    <!--中间栏结束-->


    </div>

    </div>
    <%--主体结束--%>

	<%@include file="../common/foot.jsp"%>

</body>
</html>