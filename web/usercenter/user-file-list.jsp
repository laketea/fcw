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
    <li 
    ${'0' eq exam?'class="cur" ':'' }
    ><a href="userfile!list.action?exam=0">我的资料</a></li>
    <li ><a href="userfile!download.action">我的下载</a></li>
    <li  ${'-1' eq exam?'class="cur" ':'' }><a href="userfile!list.action?exam=-1">审核管理</a></li>
    <li  ><a href="userfile!upload.action">上传资料</a></li>

    </ul>


    <p class="uc-c-nav">
    </p>
    </div>

    <div class="main-block">
    <table class="data-list data">
    <tbody>
    <tr>
    <th align="left">资料名称</th>
    <th width="15%">下载次数</th>
    <th width="8%">分类</th>
    <th width="8%">状态</th>
    <th width="25%">发布时间</th>
    </tr>
    <c:if test="${empty page.list}">
    <tr>
        <td colspan="5" align="center" style="height:35px;line-height:30px;">没有相关资料</td>
    </tr>
    </c:if>

    <c:forEach var="file" items="${page.list}" >
    <tr>
    <td align="left"><a href="information!show.action?id=${file.id}">${file.name}</a></td>
    <td align="center">${file.downCount}</td>
    <td align="center">${file.channelName}</td>
    <td align="center">${'0' eq file.examine ? '未审核':'审核通过'}</td>
    <td align="center">${file.upTime}</td>
    </tr>
    </c:forEach>

    </tbody>
    </table>

    <c:if test="${not empty page.list}">
    <div class="info-page" style="">
    <pg:pager url="userfile!list.action" items="${page.totalRecords}" maxPageItems="15" export="currentPageNumber=pageNumber">
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