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
    <script type="text/javascript" src="../resource/js/jquery.js"></script>
    <script type="text/javascript" src="../resource/js/blog.js"></script>
    <script charset="utf-8" src="../resource/editor/kindeditor.js"></script>
    <script charset="utf-8" src="../resource/editor/lang/zh_CN.js"></script>
</head>
    <script>

    var editor;
    KindEditor.ready(function(K) {
    editor = K.create('#recordTXT', {
    width:'580px',
    minWidth:'580px',
    height:'150px',
    minHeight:'150px',
    items : [
    'emoticons']
    });
    });
    function syncTextArea(){
    editor.sync();
    return true;
    }
    </script>


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
    <div class="record-title">
    记录
    </div>
    <div class="record-publish">
    <textarea rows="4" cols="60" id="recordTXT" ></textarea>
    <input id="blogId" type="hidden" value="${id}">
    <button id="recordSubmit" onClick="return syncTextArea();">发布</button>
    </div>
    <ul class="record-ul">

    <c:if test="${empty page.list}">
    <li>
    暂无相关记录!
    </li>
    </c:if>

    <c:forEach var="item" items="${page.list}" >
    <li>
    <div class="record-content">
    ${item.content}
    </div>
    <div class="box">
    <div class="replay-btn fl"><a href="#">回复</a> |<a href="#">删除</a></div>
    <div class="pb-time fr">${item.pbTime}</div>
    </div>
    </li>
    </c:forEach>

    <c:if test="${not empty page.list}">
    <div class="info-page" style="">
    <pg:pager url="blogrecord!index.action" items="${page.totalRecords}" maxPageItems="15" export="currentPageNumber=pageNumber">
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