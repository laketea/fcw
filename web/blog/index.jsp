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
<title>房产网-博客</title>
    <link type="text/css" rel="stylesheet" href="../resource/css/common.css" />
    <link type="text/css" rel="stylesheet" href="../resource/css/blog.css" />
</head>


    <body class="blog_bg">
    <div id="toptb">
    <div class="top-container"><a href="#" class="link_dft">房资网首页</a></div>
    </div>
    <div style="width: 960px;margin: 0 auto;">
    <div class="head">
    <h2>
    <strong >
    ${blogInfo.userName}的个人空间
    </strong>
    </h2>
    <div class="nav">
    <%@include file="../common/blog-nav.jsp"%>
    </div>
    </div>
    <div class="main-container box">
    <div class="left-side fl">
    <!--头像-->
    <div class="blog-box">
    <div class="title"><span><a href="#">头像</a></span></div>
    <div class="content">
    <a href="#" class="tx"><img src="../resource/img/testtest.jpg"></a>
    <a href="#" class="blog-name">${blogInfo.userName}</a>
    <ul class="tx-btn-list box">
    <li><a href="#" class="btn1">加为好友</a></li>
    <li><a href="#" class="btn2">给我留言</a></li>
    <li><a href="#" class="btn3">打个招呼</a></li>
    <li><a href="#" class="btn4">发送私信</a></li>
    </ul>
    </div>
    </div>

    <!--统计信息-->
    <div class="blog-box">
    <div class="title"><span>统计信息</span></div>
    <div class="content">
    <div class="view-count-ctn">已有<span class="color-c"> 51 </span>人来访</div>
    <ul class="view-list box">
    
    <li>好友：<a href="#" >123</a></li>
    <li>日志：<a href="#" >102</a></li>
    
    </ul>
    </div>
    </div>

    <!--记录-->
    <div class="blog-box">
    <div class="title"><span><a href="#">记录</a></span></div>
    <div class="content">
    <ul class="jl-list box">
    <c:if test="${empty recordLstt}">
    <li>
    暂无记录信息!
    </li>
    </c:if>
    <c:forEach var="record" items="${recordLst}" >
    <li>${record.content}</li>
    </c:forEach>
    </ul>
    </div>
    </div>
    </div>
    <div class="middle-side fl">

    <!--个人资料-->
    <div class="blog-box">
    <div class="title"><span><a href="#">个人资料</a></span></div>
    <div class="content">
    <ul class="info-list box">
    <li>公司 ：南京一号软件公司</li>
    <li>职位 ：软件工程师</li>
    </ul>
    </div>
    </div>

    <!--动态-->
    <div class="blog-box">
    <div class="title"><span><a href="#">动态</a></span></div>
    <div class="content">
    <ul class="dt-list box">
    <li>测试数据</li>
    <li>测试数据</li>
    </ul>
    </div>
    </div>

    <!--分享-->
    <div class="blog-box">
    <div class="title"><span><a href="#">分享</a></span></div>
    <div class="content">
    <div class="ept">
    暂时没有数据
    </div>
    <!--<ul class="dt-list box">-->
    <!--<li>测试数据</li>-->
    <!--<li>测试数据</li>-->
    <!--</ul>-->
    </div>
    </div>

    <!--日志-->
    <div class="blog-box">
    <div class="title"><span><a href="#">日志</a></span></div>
    <div class="content">
    <c:if test="${empty artLst}">
    <div class="ept">
    暂时没有日志
    </div>
    </c:if>
    <ul class="dt-list box">
    <c:forEach var="art" items="${artLst}" >
    <li>${art.title}</li>
    </c:forEach>

    </ul>
    </div>
    </div>

    <!--留言板-->
    <div class="blog-box">
    <div class="title"><span><a href="#">留言板</a></span></div>
    <div class="content">
     <!--
    <div class="ly-area">
    <c:if test="${empty login}">
    <div class="ept-textarea">
    您需要登录后才可以留言 <a href="#">登录</a> | <a href="#">留言</a>
    </div>
    </c:if>
    <c:if test="${not empty login}">
    <div class="ly-textarea">
    <textarea rows="4" cols="51"></textarea>
    </div>
    </c:if>
    <button>留言</button>
    </div>
    -->

    <div class="ly-list">
    <c:if test="${empty guestLst}">
    <div class="ly-list-ept">现在还没有留言</div>
    </c:if>
    <ul class="dt-list box">
    <c:forEach var="item" items="${guestLst}" >
    <li>${item.content}</li>
    </c:forEach>
    </ul>
    </div>
    <!--<ul class="dt-list box">-->
    <!--<li>测试数据</li>-->
    <!--<li>测试数据</li>-->
    <!--</ul>-->
    </div>
    </div>


    </div>
    <div class="right-side fl">
    <!--好友-->
    <div class="blog-box">
    <div class="title"><span><a href="#">好友</a></span></div>
    <div class="content">
    <div class="ept">
    暂时没有好友
    </div>
    <ul class="hy-list box">
    <li><a class="hy-tx" href="#"><img src="../resource/img/avatar.php.jpg"></a>
    <a class="hy-name" href="#">测试</a>
    </li>


    </ul>
    </div>
    </div>


    <!--最近访客-->
    <div class="blog-box">
    <div class="title"><span><a href="#">好友</a></span></div>
    <div class="content">
    <div class="ept">
    暂时没有访客
    </div>
    <ul class="hy-list fk-list box">
    <li><a class="hy-tx" href="#"><img src="../resource/img/avatar.php.jpg"></a>
    <a class="hy-name" href="#">测试</a>
    <a class="hy-time" href="#">测试</a>
    </li>
    <li><a class="hy-tx" href="#"><img src="../resource/img/avatar.php.jpg"></a>
    <a class="hy-name" href="#">测试</a>
    </li>
    <li><a class="hy-tx" href="#"><img src="../resource/img/avatar.php.jpg"></a>
    <a class="hy-name" href="#">测试</a>
    </li>
    <li><a class="hy-tx" href="#"><img src="../resource/img/avatar.php.jpg"></a>
    <a class="hy-name" href="#">测试</a>
    </li>

    </ul>
    </div>
    </div>


    </div>

    </div>

    </div>


    </body>
</html>