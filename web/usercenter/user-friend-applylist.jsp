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
    <li class="cur"><a href="userfriend!applylist.action">好友请求</a></li>
    <li><a href="userfriend!find.action">查找好友</a></li>
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
    <ul class="apply-ui box">
    
    <c:if test="${empty page.list}">
    <li style='padding:10px 5px;'>
        暂无相关记录！
    </li>
    </c:if>
    
    <c:forEach  var="item" items="${page.list}">
    <li class="box">
    <a href="#" class="apply-tx"><img src="../resource/img/testtest.jpg" width="70" height="70" ></a>
    <a class="apply-name" href="#">${item.fromName}</a>
    <div class="apply-time">${item.sendTime}</div>
    <div class="apply-btn"><span><a href="#" class="color369">批准申请</a></span><span>|</span><span><a href="#">忽略</a></span></div>
    </li>
	</c:forEach>
    
	<c:if test="${not empty page.list}">
    <div class="info-page" style="">
    <pg:pager url="userfriend!applylist.action" items="${page.totalRecords}" maxPageItems="15" export="currentPageNumber=pageNumber">
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