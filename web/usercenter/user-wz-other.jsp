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
    <li class="cur"><a href="user-wz-other.jsp">好友日志</a></li>
    <li><a href="user-wz.jsp">我的日志</a></li>
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
    <ul class="other-wz-ul">
    <li class="box">
    <div class="other-wz-tx fl"><a href="#"><img src="../resource/img/testtest.jpg" alt="" width="50" height="50"/> </a></div>
    <div class="other-wz-right box">
    <h2><a>关于最新房产数据的研究报告</a></h2>
    <div class="other-wz-zz"><a href="">刘翔</a> <span>2012-12-12 12:12:12</span></div>
    <div class="other-wz-content">
    香港最近发生了系列高级骗局，估计很快会传入内地啊！城市里乘公交车的亲人们警惕哦。 骗子最新手法：是在公交车上，一般三人一组，三个骗子会围坐在你的周围，借机把手机放在你手袋或衣袋中，之后就说不见手机了。骗子借同伙致电自己手机时，你袋里的手机就会响起，令你变成小偷，屈你 ...
    </div>
    <p class="box"><a href="#">评论(12)</a><a href="#">阅读(12)</a><a href="#">转发</a></p>
    </div>
    </li>
    <li class="box">
    <div class="other-wz-tx fl"><a href="#"><img src="../resource/img/testtest.jpg" alt="" width="50" height="50"/> </a></div>
    <div class="other-wz-right box">
    <h2><a>关于最新房产数据的研究报告</a></h2>
    <div class="other-wz-zz"><a href="">刘翔</a> <span>2012-12-12 12:12:12</span></div>
    <div class="other-wz-content">
    香港最近发生了系列高级骗局，估计很快会传入内地啊！城市里乘公交车的亲人们警惕哦。 骗子最新手法：是在公交车上，一般三人一组，三个骗子会围坐在你的周围，借机把手机放在你手袋或衣袋中，之后就说不见手机了。骗子借同伙致电自己手机时，你袋里的手机就会响起，令你变成小偷，屈你 ...
    </div>
    <p class="box"><a href="#">评论(12)</a><a href="#">阅读(12)</a><a href="#">转发</a></p>
    </div>
    </li>
    <li class="box">
    <div class="other-wz-tx fl"><a href="#"><img src="../resource/img/testtest.jpg" alt="" width="50" height="50"/> </a></div>
    <div class="other-wz-right box">
    <h2><a>关于最新房产数据的研究报告</a></h2>
    <div class="other-wz-zz"><a href="">刘翔</a> <span>2012-12-12 12:12:12</span></div>
    <div class="other-wz-content">
    香港最近发生了系列高级骗局，估计很快会传入内地啊！城市里乘公交车的亲人们警惕哦。 骗子最新手法：是在公交车上，一般三人一组，三个骗子会围坐在你的周围，借机把手机放在你手袋或衣袋中，之后就说不见手机了。骗子借同伙致电自己手机时，你袋里的手机就会响起，令你变成小偷，屈你 ...
    </div>
    <p class="box"><a href="#">评论(12)</a><a href="#">阅读(12)</a><a href="#">转发</a></p>
    </div>
    </li>
    <li class="box">
    <div class="other-wz-tx fl"><a href="#"><img src="../resource/img/testtest.jpg" alt="" width="50" height="50"/> </a></div>
    <div class="other-wz-right box">
    <h2><a>关于最新房产数据的研究报告</a></h2>
    <div class="other-wz-zz"><a href="">刘翔</a> <span>2012-12-12 12:12:12</span></div>
    <div class="other-wz-content">
    香港最近发生了系列高级骗局，估计很快会传入内地啊！城市里乘公交车的亲人们警惕哦。 骗子最新手法：是在公交车上，一般三人一组，三个骗子会围坐在你的周围，借机把手机放在你手袋或衣袋中，之后就说不见手机了。骗子借同伙致电自己手机时，你袋里的手机就会响起，令你变成小偷，屈你 ...
    </div>
    <p class="box"><a href="#">评论(12)</a><a href="#">阅读(12)</a><a href="#">转发</a></p>
    </div>
    </li>
    <li class="box">
    <div class="other-wz-tx fl"><a href="#"><img src="../resource/img/testtest.jpg" alt="" width="50" height="50"/> </a></div>
    <div class="other-wz-right box">
    <h2><a>关于最新房产数据的研究报告</a></h2>
    <div class="other-wz-zz"><a href="">刘翔</a> <span>2012-12-12 12:12:12</span></div>
    <div class="other-wz-content">
    香港最近发生了系列高级骗局，估计很快会传入内地啊！城市里乘公交车的亲人们警惕哦。 骗子最新手法：是在公交车上，一般三人一组，三个骗子会围坐在你的周围，借机把手机放在你手袋或衣袋中，之后就说不见手机了。骗子借同伙致电自己手机时，你袋里的手机就会响起，令你变成小偷，屈你 ...
    </div>
    <p class="box"><a href="#">评论(12)</a><a href="#">阅读(12)</a><a href="#">转发</a></p>
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