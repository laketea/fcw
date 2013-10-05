    <%@ page language="java" contentType="text/html; charset=UTF-8"
             pageEncoding="UTF-8" %>
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
        <title>房产网-房产资讯</title>
        <link type="text/css" rel="stylesheet"
        href="../resource/css/default.css" />
        <script type="text/javascript" src="../resource/js/jquery.js"></script>
        <link type="text/css" rel="stylesheet" href="../resource/css/common.css" />
        <link type="text/css" rel="stylesheet"
        href="../resource/css/ui-default.css" />
        <link type="text/css" rel="stylesheet"
        href="../resource/css/default.css" />
        <link type="text/css" rel="stylesheet" href="../resource/css/newscolumn.css" />
        </head>
        <body>

        <%@include file="../common/top.jsp" %>
        <c:set var="channelName" value="房产资源" scope="request" />
        <%@include file="../common/head.jsp" %>
        <div id="top-grad"></div>

        <div id="news" class="wrap center960 box ">
        <div class="news-row adv">

        </div>

        <div class="title">
        <div class="titlecurrent"><a class="link_01" target="_blank" href="../default!index.action">房资网</a> &gt;
        <a class="link_01" target="_blank" href="../fcnews!index.action">房产资讯</a> &gt; ${channel.name}
        </div>
        <div class="titleheaderwrap">
        <form action="newschannel!search.action" method="post">
        <div class="titleheader22">资讯搜索
        
        <input type="text"  value="" name="keywords" class="but_11">
        <input type="submit" onmouseover="style.cursor='hand'" value="" class="but_22">
        
        </div>
        </form>
        ${channel.name} </div>
        </div>

        <div class="news-column-content">
            <div class="contentleft">
            <ul>
                <c:forEach items="${page.list}" var="item" varStatus="status" >
                <li class="textlisttitless">
                    <div class="fonttime">${item.pbTime}</div>
                    <div class="textlist"><a class="link_01" target="_blank" href="../newschannel!show.action?id=${item.id}">${item.title}</a></div>
                </li>
                <c:if test="${4 eq status.index || 9 eq status.index || 14 eq status.index || 19 eq status.index || status.last }" >
                <li><div id="fenge" class="textline"></div></li>
        </c:if>
            </c:forEach>

            </ul>

        <div class="pageturning">
        
        
        
        <div class="info-page" style="padding-left:18px;">
        <pg:pager url="newschannel!channel.action" items="${page.totalRecords}" maxPageItems="15" export="currentPageNumber=pageNumber">
        <pg:param name="id" value="${id}"/>
        <pg:first>
        <a href="${pageUrl}">首页</a>
        </pg:first>
        <pg:prev>
        <a href="${pageUrl }">上一页</a>
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
        <a href="${pageUrl }">下一页</a>
        </pg:next>
        <pg:last>
        <a href="${pageUrl }">尾页</a>
        </pg:last>
        </pg:pager>
        </div>
        

        </div>
            </div>
            <div class="contentright">
        <div class="column-news">
        <div class="newscolumn">
        <div  class="column"><a target="_blank" href="#">24小时排行榜</a></div>
        </div>
        <div class="jszxnewslist0301">
        <ul>
        <c:forEach items="${lastTopNews}" var="item" >
        <li><span>${item.visitCount}</span><a target="_blank" href="../newschannel!show.action?id=${item.id}">${item.title}</a></li>
        </c:forEach>
        </ul>
        </div>
        </div>
        <div class="column-news box">
        <div class="newscolumn box">
        <div class="bkmore"><a target="_blank" href="/#">更多&gt;&gt;</a></div>
        <div class="rdzt"><a target="_blank" href="/#">推荐博客</a></div>
        </div>
        <div class="rdztimgwrap">
        <div class="rdztimgbox0128">
        <div class="rdztimg0128"><a target="_blank" href=""><img width="120" height="90" alt="#" src="#"></a> </div>
        <div class="rdztimgfont0128"><a title="" target="_blank" href="#">人气博客</a></div>
        </div>
        </div>
        </div>

        </div>


        </div>

        </div>




         </div>
        <%@include file="../common/foot.jsp" %>


        </body>
        </html>