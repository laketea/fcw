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
    吕迪的个人空间
    </strong>
    </h2>
    <div class="nav">
    <%@include file="../common/blog-nav.jsp"%>
    </div>
    </div>
    <div class="main-container box">

    <div class="main-side fl">
    <div class="main-title">
    日志
    </div>
    
    <div class="art-title">
    	<div class="h2">${art.title}</div>
    	<div class="h5">已有  ${art.view_count} 次阅读   ${art.phTime} | 分类:${art.catalogName} </div>
    	<div class="z-line"></div>
    </div>
    <div class="art-content" >
    ${art.content}
    </div>

    </div>
    <div class="right-side fl">
    <div class="user-right-tx">
    <a href="#"><img width="45" height="37" src="../resource/img/testtest.jpg"></a>
    </div>
    <div class="user-right-name">${blog.userName}</div>
    <ul class="tx-btn-list box">
    <li><a class="btn1" href="#">加为好友</a></li>
    <li><a class="btn2" href="#">给我留言</a></li>
    <li><a class="btn3" href="#">打个招呼</a></li>
    <li><a class="btn4" href="#">发送私信</a></li>
    </ul>
    </div>

    </div>

    </div>

    </body>
</html>