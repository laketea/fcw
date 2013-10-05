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
</head>
<body>
	<%@include file="../common/top.jsp"%>
	<c:set var="channelName" value="房产资源" scope="request" />
	<%@include file="../common/head.jsp"%>
	<div id="top-grad"></div>


<div id="company" class="wrap center960 box ">
    <div class="cur-nav">
        当前位置：<a href="resource!index.action">房产资源</a> > <a href="resource!channel.action?channelId=${topChannel.id}">${topChannel.name}</a> > <a href="resource!channel.action?channelId=${topChannel.id}&topChlId=${channel.id}">${channel.name}</a>
    </div>

    <div class="elite">
        <h4><span>业务精英推荐</span></h4>
        <ul id="elite-lst">
        <c:if test="${empty userList}">
        	 <li style="text-align:center;" >
               		 暂无相关业务精英！
            </li>
        </c:if>
        <c:forEach items="${userList}" var="userInfo" >
            <li >
                <div class="user-img fl"></div>
                <span class="user-name fl">${userInfo.users.nick}</span>
                <span class="user-phone fl">${userInfo.users.phone}</span>
            </li>
         </c:forEach>  
        </ul>
    </div>
    <div id="company-info" class="box">
        <div class="company-img fl"><img src="../${resource.photo}" width="229" height="229" style="margin:3px"></div>
        <div class="company-name fl">${resource.name}<img src="img/vip.png" style="margin-bottom:-3px;margin-left: 10px;">
        <c:if test="${not empty resource.blogId}">
        <a href="/?id=${resource.blogId}">已开通认证博客</a>
        </c:if>
        </div>
		
        <div class="company-detail fl">所属地区: ${resource.cnarea}</div>
        <div class="company-detail fl">所属板块: ${resource.industry}</div>
        <div class="company-detail fl">主营范围: ${resource.industry}</div>
        <div class="company-detail fl">公司电话: ${resource.phone}</div>
        <div class="company-detail fl">公司传真: ${resource.tax}</div>
        <div class="company-detail fl">电子邮箱:${resource.email}</div>
        <div class="company-detail fl">公司地址: ${resource.address}</div>

        <div class="company-intr-title fl">公司概括</div>
        <div class="company-des fl">
            <p>
                ${resource.about}</p>
        </div>
       

    </div>
</div>




	<%@include file="../common/foot.jsp"%>

</body>
</html>