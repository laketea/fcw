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
    <div class="main-nav"><a href="#">全部</a>
    <c:forEach var="item" items="${cataList}" >
    | <a href="blogarticle!index.action?id=${id}&cataId=${item.id}">${item.catalogName}</a>
    </c:forEach>
    </div>
    <ul class="main-ul article-ul">




    <c:if test="${empty page.list}">
    <li style="height:30px;line-height:30px">
    暂时还没有相关的日志!
    </li>
    </c:if>

    <c:forEach var="item" items="${page.list}" >
    <li>
    <div class="article-type">
    <a href="blogarticle!index.action?id=${id}&cataId=${item.catalogId}">${item.catalogName}</a>
    </div>
    <h2><a href="blogarticle!show.action?id=${item.id}">${item.title}</a></h2>
    <h6>${item.phTime}</h6>
    <div class="record-des">
    ${item.title}
    </div>
    <div class="artice-btn ">
    <a href="#">评论</a>
    <a href="#">转发</a>
    <a href="#">收藏</a>
    <a href="#">阅读</a>
    </div>
    </li>
    </c:forEach>

    <c:if test="${not empty page.list}">
    <div class="info-page" style="">
    <pg:pager url="blogarticle!index!list.action" items="${page.totalRecords}" maxPageItems="15" export="currentPageNumber=pageNumber">
    <pg:param name="id" value="${id}"/>
    <pg:param name="cataId" value="${cataId}"/>
    <pg:first>
    <a href="${pageUrl}"><<</a>
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
    <a href="${pageUrl }">>></a>
    </pg:last>
    </pg:pager>
    </div>
    </c:if>

    </ul>

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