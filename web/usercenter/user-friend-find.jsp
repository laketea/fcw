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
    <li ><a href="userfriend!list.action">我的好友</a></li>
    <li><a href="userfriend!visit.action">我的访客</a></li>
    <li><a href="userfriend!applylist.action">好友请求</a></li>
    <li class="cur"><a href="userfriend!find.action">查找好友</a></li>
    </ul>


    <p class="uc-c-nav">
    <form action="userfriend!find.action" method ="post">
    <input class="find-friend-input"  name="keywords" value="${keywords}" type="text" size="25"> <input type="submit" value ="查找好友" class="find-btn">
    </form>
    </p>
    </div>

    <div class="main-block">
    <ul class="friend-ui box">
     <c:if test="${empty page.list}">
    <li style='padding:10px 5px;'>
        暂无相关用户信息！
    </li>
    </c:if>
    
    <c:forEach  var="item" items="${page.list}">
    <li class="box"><a href="#"><img src="../resource/img/testtest.jpg" width="50" height="50" ></a>
    <a class="friend-name" href="#">${item.userName}</a>
    <span class="friend-sd" >4月25日</span><span class="friend-sd">|</span><span class="friend-sd"><a href="#" >加为好友</a></span>
    </li>
    </c:forEach>
    
    

    </ul>
    
    <c:if test="${not empty page.list}">
    <div class="info-page" style="">
    <pg:pager url="userfriend!find.action" items="${page.totalRecords}" maxPageItems="15" export="currentPageNumber=pageNumber">
    <pg:param name="keywords" value="${keywords}"/>
    <pg:first>
    <a href="${pageUrl}">首页</a>
    </pg:first>
    <pg:prev>
    <a href="${pageUrl }"><</a>
    </pg:prev>

    <pg:pages>
    <c:choose>
    <c:when test="${currentPageNumber eq pageNumber}">
    <a  > <font color="red">${pageNumber }</font></a>
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

    </div>
    </div>
    <!--中间栏结束-->


    </div>

    </div>
    <%--主体结束--%>

	<%@include file="../common/foot.jsp"%>

</body>
</html>