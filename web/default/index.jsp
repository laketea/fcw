    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
        <%@ include file="../common/include.jsp" %>
            <%
	String path = request.getRequestURI();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
	System.out.println("basePath:"+basePath);
%>

        <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
        <html>
        <head>
        <base href="<%=basePath%>">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>房产网-房产网</title>
        <link type="text/css" rel="stylesheet" href="../resource/css/default.css" />
        <link type="text/css" rel="stylesheet" href="../resource/css/common.css" />
        <link type="text/css" rel="stylesheet" href="../resource/css/ui-default.css" />
        <link type="text/css" rel="stylesheet" href="../resource/css/sidle.css" />
        <script src="../resource/js/jquery.js"></script>
        <script src="../resource/js/common.js"></script>
        <script src="../resource/js/jquery.Xslider.js"></script>
        </head>
        <script type="text/javascript">
        $(document).ready(function(){
        // 焦点图片淡隐淡现
        $("#slider3").Xslider({
        affect:'fade',
        ctag: 'div'
        });
        });
        </script>
        <body>

        <%@include file="../common/top.jsp" %>
        <c:set var="channelName" value="房产资源" scope="request" />
        <%@include file="../common/head.jsp" %>


        <div id="intr-wrap">
        <div id="intr" class="center960">
        <div class="intr-menu">
        <ul>
        <c:forEach var="item" items = "${topCache.resourceChannelLst}" varStatus="ftm" >
        <li class="item ">
        <h3>
        <b>></b>
        <s></s>
        <a href="../resource!channel.action?channelId=${item.id}">${item.name}</a>
        </h3>
        <div class="con box">
        <c:forEach var="child" items="${item.childChannels}" >
        <c:if test="${1 eq child.dhstatus}">
        <a href="../resource!channel.action?channelId=${item.id}&topChlId=${child.id}">${child.name}</a>
        </c:if>
        </c:forEach>
        <c:if test="${ftm.first}" >
        <a href="../resource!channel.action?channelId=${item.id}">更多</a>
        </c:if>
        </div>
        <div class="item-hd f${item.sn}">
            <div class="s-item">
		 <c:forEach var="dfchild" items="${item.dfChildChannels}" varStatus="itm" >
        <dl class="fore${itm.count}">
        <dt>
        <a href="../resource!channel.action?channelId=${item.id}&topChlId=${dfchild.id}">${dfchild.name}</a>
        </dt>
        <dd>
        <c:forEach var="resource" items="${dfchild.dfresource}"  >
        <em><a title="${resource.name}" href="../resource!show.action?id=${resource.id}">${resource.simpleName}</a></em>
         </c:forEach>
        <em><a title="更多" href="../resource!channel.action?channelId=${item.id}&topChlId=${dfchild.id}">更多</a></em>
        </dd>
        </dl>
		</c:forEach>
		
		<c:if test="${ftm.first}" >
		 <dl class="fore0">
        <dt>
        <a href="../resource!channel.action?channelId=${item.id}">更多</a>
        </dt>
        <dd>
        </dd>
        </dl>
        </c:if>
		 
        



        </div>
            <div class="r-con">
            	<div class="force ftitle"><a href="${item.dfTitleUrl}">${item.dfTitle}</a></div>
                <div class="force fline"><a href="${item.dfFirstLineUrl}">${item.dfFirstLine}</a></div>
                <div class="force sline"><a href="${item.dfSecondLineUrl}">${item.dfSecondLine}</a></div>
                <div class="force dfphoto"><a href="${item.dfPhotoUrl}"><img border="0" width="180" height="220" src="../${item.dfPhoto}"></a></div>
            </div>
        </div>
        </li>
        </c:forEach>
        </ul>
        </div>
        <div id="intr-right">
        <div id="intr-photo">
        <div id="slider3" class="slider">
        <div class="conbox">
        <c:forEach var="item" items="${slideLst}" >
        <div>
        <a href="${item.url}" target="_blank" title="jquery "><img width="750" height="332" alt="jquery "
        src="../${item.photo}" /></a>
        </div>
       </c:forEach>
        </div>
        <div class="switcher">
        <c:forEach var="item" items="${slideLst}" varStatus ="sdStatus" >
        <a href="" <c:if test="${0 eq sdStatus.index}">class="cur"</c:if>    >${sdStatus.index+1}</a>
        </c:forEach>
       
        </div>
        </div>
        </div>
        <!-- <div id="intr-main">
        <ul>
        <li><a href="#">资源在线</a></li>
        <li><a href="#">合作双赢</a></li>
        <li><a href="#">最新资讯</a></li>
        <li><a href="#">交流互动</a></li>
        </ul>
        </div> -->
        </div>
        </div>
        </div>


        <div id="main" class="center960">
        <div id="last-news" class="fl w691 mt10">
        <div class="title"><a href="../newschannel!channel.action?id=1">房产新闻</a></div>
        <div class="list dbr box">
        <div class="halfl-news">
        <div  class="tt">
        <c:forEach var="item" items="${frTopNewsLst}" begin="0" step="1" end="0" varStatus="status">
        <a href="../newschannel!show.action?id=${item.id}"><em>${item.simpleTitle}</em></a>
        </c:forEach>
        </div>
        <div  class="tts">
        <c:forEach var="item" items="${frTop2NewsLst}" begin="0" step="1" end="1" varStatus="status">
        [<a href="../newschannel!show.action?id=${item.id}">${item.simpleTitle}</a>]&nbsp;
        </c:forEach>
        </div>
        <ul>
        <c:forEach var="item" items="${frDftNewsLst}" begin="0" step="2" end="15" varStatus="status">
        
        <li <c:if test="${fn:length(item) <1 }"> class="nobg" </c:if> >
        <c:forEach var="child" items="${item}" >
        <a  <c:if test="${status.count eq 1 || status.count eq 5 }"> class="red"</c:if>  href="../newschannel!show.action?id=${child.id}">${child.simpleTitle}</a>
        </c:forEach>
        </li>
        
        </c:forEach>
        </ul>
        </div>
        <div class="halfl-news">
        <div  class="tt">
        <c:forEach var="item" items="${frTopNewsLst}" begin="1" step="1" end="1" varStatus="status">
        <a href="../newschannel!show.action?id=${item.id}"><em>${item.simpleTitle}</em></a>
        </c:forEach>
        </div>
        <div  class="tts">
        <c:forEach var="item" items="${frTop2NewsLst}" begin="2" step="1" end="3" varStatus="status">
        [<a href="../newschannel!show.action?id=${item.id}">${item.simpleTitle}</a>]&nbsp;
        </c:forEach>
        </div>
        <ul>
        <c:forEach var="item" items="${frDftNewsLst}" begin="1" step="2" end="15" varStatus="status">
        
         <li <c:if test="${fn:length(item) <1 }"> class="nobg" </c:if> >
        <c:forEach var="child" items="${item}" >
        <a href="../newschannel!show.action?id=${child.id}" <c:if test="${status.count eq 1 || status.count eq 5 }"> class="red"</c:if> >${child.simpleTitle}</a>
        </c:forEach>
        </li>
        </c:forEach>
        </ul>
        </div>

        </div>
        </div>
        <div id="notices" class="fr w300 mt10 ">
        <div class="title"><a href="#">网站公告</a></div>
        <div class="list dbr"></div>
        </div>
        <div id="last-news2" class="fl w650 mt10 ">
        <div class="title"><a href="../newschannel!channel.action?id=4">业界快递</a></div>
        <div class="list dbr">
        <div style="padding-left:10px;padding-right:10px;">
        <div class="top-news">
            <div id="top-img" class="fl"><img src="../${sdTopNews.photo}" width="100" height="80" border="0"/></div>
            <div class="top-title fl"><a href="../newschannel!show.action?id=${sdTopNews.id}">${sdTopNews.simpleTitle}</a></div>
            <div class="top-des fl">${sdTopNews.description}</div>
        </div>

        <div class="top-news2 box">
            <div class="fl">
            <c:forEach var="item" items="${sdDftNewsLst}" >
            <div class="top2-title"><a href="../newschannel!show.action?id=${item.id}">${item.simpleTitle}</a></div>
            <div class="top2-des">${item.description}</div>
            </c:forEach>
        <ul class="ht-newslst">
        <c:forEach var="item" items="${sdHotNewsLst}" >
        <li ><em>${item.pbTime}</em><a href="../newschannel!show.action?id=${item.id}">${item.simpleTitle}</a></li>
       </c:forEach>
        </ul>
        </div>
            <div class="fr">
                <div class="pnews-temp">
        <c:forEach var="item" items="${sdTop2NewsLst}" >
                    <div class="fr-news-photo"><img src="../${item.photo}" border="0" width="130" height="120"/></div>
                    <div class="fr-news-title"><a href="../newschannel!show.action?id=${item.id}">${item.simpleTitle}</a></div>
        </c:forEach>
                </div>
            </div>
        </div>
        </div>



        </div>
        </div>
        <div id="adv-1" class="fr w300 mt10 ">
        <div class="title"><a href="#">网站公告</a></div>
        <div class="list dbr"></div>
        </div>
		
         <div class="center960 box">
		<c:if test="${not empty topAdv}">
        <img style="margin: 10px 0px 0px 0px;" width="960" height="90" src="../${topAdv.photo}">
		</c:if>
		</div>

        <div id="blog" class="wrap center960 mt10 ">
        <div class="title"></div>
        <div class="content dbr box">
        <div class="fl left-1"></div>
        <div class="fl left-2"></div>
        <div class="fl left-3"></div>
        <div class="fl left-4"></div>
        </div>
        </div>

        <div id="business" class="wrap center960 mt10">
        <div class="title"><a href="../business!index.action">商务合作</a></div>
        <div class="content dbr box">
        <div class="fl left-1">
            <div class="bt-item">
                <a class="fl" href="#" ><img src="../resource/img/wyzb.png" ></a>
                <a class="fr" href="#" ><img src="../resource/img/wytb.png" ></a>
            </div>
            <div class="zb-adv" style="background:#e7e7e7">
            <c:if test="${not empty topAdv2}">
        <a href="${topAdv2.url}"><img style="margin: 0px 0px 0px 0px;" width="215" height="170" src="../${topAdv2.photo}"></a>
		</c:if>
				
            </div>
            <div class="zb-imgtitle" >
                测试标题数据
            </div>
        </div>
        <div class="fl left-2">

        </div>
        <div class="fl left-3">
        <div class="md-top">
        <span class="mdtitle"><a href="../business!show.action?id=${topTender.id}">${topTender.name}</a></span>
        <span>${topTender.tenderType}</span>
        <span>${topTender.company}</span>
        </div>
        <ul class="md-dft" >
        <c:forEach items="${lateTenderList}" var="item">
        <li><a href="../business!show.action?id=${item.id}">${item.name}</a><em>[&nbsp;<span>${item.tenderType}</span>&nbsp;]</em></li>
        </c:forEach>
        </ul>
        </div>
        <div class="fl left-4">
        <div class="hot-md-title">
        热门招标
        </div>
        <ul class="hot-md-list">
        <c:forEach items="${hotTenderList}" var="item">
        <li><a href="../business!show.action?id=${item.id}">${item.name}</a></li>
        </c:forEach>
        </ul>
        </div>
        </div>
        </div>

        <div id="download" class="wrap center960 mt10">
        <div class="title"><a href="../information!index.action">资料下载</a></div>
        <div class="content dbr box">
        <div class="fl left-1">
        <div class="xs-title">资料悬赏</div>
        <ul class="xs-lst">
        <c:forEach var="item" items="${rewardLst}" >
        <li class="box">
        <span class="xs-title">${item.title}</span>
        <span class="xs-cold">悬赏：<font color="red">${item.gold}</font></span>
        <span class="xs-type">分类：策划</span>
        </li>
        </c:forEach>
        </ul>
        </div>
        <div class="fl left-2"></div>

        <div class="fl left-3">
        <div class="md-top">
        <span class="mdtitle"><a href="../information!show.action?id=${infor.id}">${infor.name}</a></span>
        <span>${infor.area}</span>
        <span>${infor.year}</span>
        </div>
        <ul class="md-dft" >
        <c:forEach items="${dfInforList}" var="item">
        <li><a href="../information!show.action?id=${item.id}">${item.name}</a><em>[&nbsp;<span>${item.area}</span>&nbsp;]</em></li>
        </c:forEach>
        </ul>
        </div>
        <div class="fl left-4">
        <div class="hot-md-title">
        下载排行
        </div>
        <ul class="hot-md-list">
        <c:forEach items="${hotInforList}" var="item">
        <li><a href="../information!show.action?id=${item.id}">${item.name}</a></li>
        </c:forEach>
        </ul>
        </div>

        </div>
        </div>

        </div>


        <%@include file="../common/foot.jsp" %>


        </body>
        </html>