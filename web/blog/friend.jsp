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
    <div class="main-title friend-title">
    日志
    </div>
    <div class="friend-container">
    <div class="friend-count">当前共有 ${page.totalRecords} 个好友</div>
    <ul class="friend-ui box">
    <c:if test="${empty page.list}">
    <li>
    您目前还没有好友！
    </li>
    </c:if>
    <c:forEach var="item" items="${page.list}" >
    <li class="box"><a href="#"><img src="../resource/img/testtest.jpg" width="50" height="50" ></a>
    <a class="friend-name" href="#">${item.toName}</a>
    <span class="friend-des" >普通会员&nbsp;&nbsp;&nbsp;&nbsp;积分：1305</span>
    </li>
    </c:forEach>
    </ul>

    <c:if test="${not empty page.list}">
    <div class="info-page" style="">
    <pg:pager url="friend!list.action" items="${page.totalRecords}" maxPageItems="15" export="currentPageNumber=pageNumber">
    <pg:param name="id" value="${id}"/>
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