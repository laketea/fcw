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
<link type="text/css" rel="stylesheet" href="../resource/css/normal-search.css" />
</head>
<body>
	<%@include file="../common/top.jsp"%>
	<c:set var="channelName" value="房产资源" scope="request" />
	<%@include file="../common/head.jsp"%>
	<div id="top-grad"></div>


	<div id="normal-search" class="wrap center960 box ">
    <div class="sidebar fl w224 box">
        <div class="title"></div>
        <div class="side-content box">
            <ul>
            <c:forEach var="topChannel" items="${channelLst}" >
                <li>
                    <h4 class="li-title"><a href="../resource!index.action?channelId=${topChannel.id}">${topChannel.name}</a></h4>
                    <div>
                    	<c:forEach var="childChannel" items="${topChannel.childChannels}" >
                        <a href="../resource!channel.action?channelId=${childChannel.id}">${childChannel.name}</a>
                       	</c:forEach>
                    </div>
                </li>
             </c:forEach>
            </ul>
        </div>
    </div>
    <div class="content fr w720">
        <div id="search-title"><h2>${channel.name}</h2></div>
        <div  id="search-result" class=" box">
            <ul class="box">
            <c:forEach var="item" items="${resPage.list}" >
                <li>
                    <div  class="fl company-img"></div>
                    <p class="company-name fl"><span>${item.name}</span><img src="img/vip.png" style="margin-bottom:-3px;margin-left: 5px;"></p>
                    <p class="fl">业务范围: ${item.industry}</p>
                    <p class="fl">地址: ${item.address}</p>
                </li>
            </c:forEach>
               
            </ul>
        </div>
    </div>
</div>




	<%@include file="../common/foot.jsp"%>

</body>
</html>