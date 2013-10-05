    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
        <%@ include file="../common/include.jsp" %>
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
        

        <link type="text/css" rel="stylesheet" href="../resource/css/common.css" />
        <link type="text/css" rel="stylesheet" href="../resource/css/default.css" />
        <link type="text/css" rel="stylesheet" href="../resource/css/ui-default.css" />
        <link type="text/css" rel="stylesheet" href="../resource/css/fczy.css" />
        <script src="../resource/js/jquery.js"></script>
        <script src="../resource/js/common.js"></script>
        </head>
        <body>
        <%@include file="../common/top.jsp" %>
        <c:set var="channelName" value="房产资源" scope="request" />
        <%@include file="../common/head.jsp" %>
        <div id="top-grad"></div>


        <div class="center960 box">
        <div id="zy-banner">
        <div class="text">测试啊测试啊标题标题</div>
        <ul class="zy-top-column">
        <c:forEach items="${channelLst}" var="item">
        <li><a href="resource!channel.action?channelId=${item.id}">${item.name}</a></li>
        </c:forEach>
        </ul>
        </div>

        <div class="zy-box box" >
        <div class="zy-fl fl">
        <c:forEach var="channel" items="${channelLst}"  begin="0" end="0" varStatus="status">
        <div class="zy-block">
        <div class="zy-block-title">
        <h2><a href="resource!channel.action?channelId=${channel.id}">${channel.name}</a></h2>
        </div>
        <div class="zy-block-content">
        <c:forEach var="child" items="${channel.childChannels}" varStatus="cstatus" >
        <dl <c:if test="0 eq cstatus.index" >class="fore"</c:if> ><dt>${child.name}</dt><dd>
        <c:forEach var="resource" items="${child.resources}" >
        <em><a href="resource!show.action?id=${resource.id}">${resource.name}</a></em>
        </c:forEach>
        </dd>
        </dl>
        </c:forEach>
        </div>
        </div>
        </c:forEach>
        </div>
        <div class="zy-fr fr">
        <c:forEach items="${channelLst}" var="channel" begin="1" end="3" varStatus="status">
        <div class="zy-block">
        <div class="zy-block-title">
        <h2><a href="resource!channel.action?channelId=${channel.id}">${channel.name}</a></h2>
        </div>
        <div class="zy-block-content">
        <c:forEach var="child" items="${channel.childChannels}" varStatus="cstatus" >
        <dl <c:if test="0 eq cstatus.index" >class="fore"</c:if> ><dt>${child.name}</dt><dd>
        <c:forEach var="resource" items="${child.resources}" >
        <em><a href="#"

        >${resource.name}</a></em>
        </c:forEach>
        </dd>
        </dl>
        </c:forEach>
        </div>
        </div>
        </c:forEach>
        </div>



        </div>


        <%@include file="../common/foot.jsp" %>

        </body>
        </html>