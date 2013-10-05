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
        <link type="text/css" rel="stylesheet" href="../resource/css/default.css" />

        <link type="text/css" rel="stylesheet" href="../resource/css/common.css" />
        <link type="text/css" rel="stylesheet" href="../resource/css/ui-default.css" />
        <link type="text/css" rel="stylesheet" href="../resource/css/fczy.css" />
        <link type="text/css" rel="stylesheet" href="../resource/css/normal-search.css" />
        <link type="text/css" rel="stylesheet" href="../resource/css/sidle.css" />
        <script src="../resource/js/jquery.js"></script>
        <script src="../resource/js/common.js"></script>
        <script src="../resource/js/jquery.Xslider.js"></script>
        </head>
        <script type="text/javascript">
        $(document).ready(function(){
        // 焦点图片淡隐淡现
        $("#slider5").Xslider({
        affect:'fade',
        ctag: 'div'
        });
        });
        </script>
        <body>
        <%@include file="../common/top.jsp" %>
        <c:set var="channelName" value="房产资源" scope="request" />
        <%@include file="../common/head.jsp" %>
        <div id="top-grad"></div>


        <div class="center960 box">
        <div class="zy-dh">
        <a href="../default!index.action">房产网</a> > <a href="resource!index.action">房产资源</a>
        </div>

        <div class="zy-nav fl">
        <c:if test="${resPage.list== null || fn:length(resPage.list) == 0}">
        <div class="zy-nav-item current">
        <h3><b></b></h3>
        <ul>
        <li><a>暂无结果</a></li>
        </ul>
        </div>
        </c:if>
        <c:forEach items="${channelLst}" var="channel" varStatus="status">
        <c:if test="${channel.searchCount >0}">
        <div class="zy-nav-item <c:if test="${0 eq status.index}">current</c:if>">
        <h3><b></b>${channel.name}(${channel.searchCount})</h3>
        <ul>
        <c:forEach var="child" items="${channel.childChannels}" varStatus="cstatus" >
        <c:if test="${child.searchCount >0}">
        <li><a href="#">${child.name}(${child.searchCount})</a></li>
        </c:if>
        </c:forEach>
        </ul>
        </div>
        </c:if>
        </c:forEach>
        </div>
        <div class="zy-content fr">
        <div class="zy-adv">

        <div class="slider" id="slider5">
        <div class="conbox">
        <c:forEach var="item" items="${slideLst}" >
        <div>
        <a href="${item.url}" target="_blank" title="jquery "><img width="740" height="120" border="0" alt="jquery "
        src="../${item.photo}" /></a>
        </div>
        </c:forEach>
        </div>
        <div class="switcher">
        <a href="#" class=""></a> <a href="#" class="cur"></a>
        </div>
        </div>


        </div>
        <div class="filter">
        <input type="hidden" id="keywords" value="${keywords}">
        地区：<select name="area" id="areacmp" style="width:100px;padding:1px">
        <option value="0">全部</option>
        <c:forEach var="item" items="${areaLst}" varStatus="areasts" >
        <option value="${areasts.index+1}" ${areasts.index+1 eq areacmp?'selected':'' } >${item}</option>
        </c:forEach>
        </select>&nbsp; &nbsp; &nbsp; &nbsp;<input type="checkbox" id="regcmp" name="isReg" ${1 eq regcmp?'checked':'' }
        >认证公司 &nbsp; &nbsp; &nbsp; &nbsp; <input id="vipcmp" type="checkbox" value="1"
        name="vip" ${1 eq vipcmp?'checked':'' } >VIP
        &nbsp; &nbsp; &nbsp; &nbsp;关键字:${keywords}
        </div>
        <div id="search-result" class=" box">
        <ul class="box">
        <c:if test="${resPage.list== null || fn:length(resPage.list) == 0}">
        <li> 暂时没有相关条件的资源!</li>
        </c:if>
        <c:forEach var="item" items="${resPage.list}" varStatus ="status" >
        <li>
        <div class="company-phone">${item.phone}</div>
        <div class="fl company-img"></div>
        <p class="company-name fl"><span><a href="resource!show.action?id=${item.id}">${item.name}</a></span>
        <c:if test="${item.vip eq 1}" >
        <img src="../resource/img/vip.png" style="margin-bottom:-3px;margin-left: 5px;">
        </c:if>
        </p>
        <p class="fl">业务范围: ${item.industry}</p>
        <p class="fl">摘要: ${item.description}</p>
        </li>
        </c:forEach>

        </ul>
        </div>


        <div class="info-page" style="padding-left:18px;">
        <pg:pager url="resource!search.action" items="${resPage.totalRecords}" maxPageItems="10"
        export="currentPageNumber=pageNumber">
        <pg:param name="keywords" value="${keywords}"/>
        <pg:param name="regcmp" value="${regcmp}"/>
        <pg:param name="areacmp" value="${areacmp}"/>
        <pg:param name="vipcmp" value="${vipcmp}"/>
        <pg:first>
        <a href="${pageUrl}">首页</a>
        </pg:first>
        <pg:prev>
        <a href="${pageUrl }">上一页</a>
        </pg:prev>
        <pg:pages>
        <c:choose>
        <c:when test="${currentPageNumber eq pageNumber}">
        <a > <font color="red">${pageNumber }</font></a>
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

        <%@include file="../common/foot.jsp" %>

        </body>
        </html>