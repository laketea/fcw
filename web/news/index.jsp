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
        <link rel="stylesheet" type="text/css" href="../resource/css/demo.css" />
        <link rel="stylesheet" type="text/css" href="../resource/css/elastislide.css" />
        <script type="text/javascript" src="../resource/js/jquery.js"></script>
        <script type="text/javascript" src="../resource/js/jquery.easing.1.3.js"></script>
        <script type="text/javascript" src="../resource/js/jquery.elastislide.js"></script>
		<link type="text/css" rel="stylesheet" href="../resource/css/sidle.css" />
        <link type="text/css" rel="stylesheet" href="../resource/css/common.css" />
        <link type="text/css" rel="stylesheet"
        href="../resource/css/ui-default.css" />
        <link type="text/css" rel="stylesheet"
        href="../resource/css/default.css" />
        <link type="text/css" rel="stylesheet" href="../resource/css/news.css" />
        <script src="../resource/js/common.js"></script>
         <script src="../resource/js/jquery.Xslider.js"></script>
        </head>
        <script type="text/javascript">
        $(document).ready(function(){
        // 焦点图片淡隐淡现
        $("#slider4").Xslider({
        affect:'fade',
        ctag: 'div'
        });
        });
        </script>
        <body>

        <%@include file="../common/top.jsp" %>
        <c:set var="channelName" value="房产资讯" scope="request" />
        <%@include file="../common/head.jsp" %>
        <div id="top-grad"></div>

        <div id="news" class="wrap center960 box ">
        <c:if test="${not empty topAdv }" >
        <div class="news-row adv">
		<a href="${topAdv.url}" target="_blank"><img src="../${topAdv.photo}" width="100%" height="75" border="0"></a>
        </div>
		</c:if>





        <div class="news-row box ">
        <div class="news-col-1 fl">
        <div class="flash">
        <div class="flash-content">
           <div id="slider4" class="slider">
        <div class="conbox">
        <c:forEach var="item" items="${slideLst}" >
        <div>
        <a href="${item.url}" target="_blank" title="jquery "><img width="350" height="200" border="0" alt="jquery "
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
        </div>
        <ul class="news-rw">
        <c:forEach items="${topRwLst}" var="item">
        <li><a href="../newschannel!show.action?id=${item.url}">${item.title}</a></li>
        </c:forEach>
        </ul>
        </div>
        <div class="news-col-2 fl">
        <h2><a href="../newschannel!show.action?id=${dctopNews.id}">${dctopNews.title}</a></h2>
        <p >
        <c:forEach var="item" items="${dcTop2Lst}" varStatus="dctop">
        <a href="../newschannel!show.action?id=${item.id}">[&nbsp;${item.title}&nbsp;]</a>
        <c:if test="${dctop.index eq 1}">
        <br/>
        </c:if>
        </c:forEach>
        </p>
        <div class="line-dotted mt10 mb5"></div>
        <ul class="news-center-1 newslist f14">
        <c:forEach var="item" items="${dcLastLst}" begin="0" end="4">
        <li><a href="../newschannel!show.action?id=${item.id}">${item.title}</a></li>
        </c:forEach>
        </ul>
        <div class="line-dotted mt10 mb5"></div>
        <ul class="news-center-1 newslist f14">
        <c:forEach var="item" items="${dcLastLst}" begin="5" end="8">
        <li><a href="../newschannel!show.action?id=${item.id}">${item.title}</a></li>
        </c:forEach>
        </ul>
        </div>
        <div class="news-col-3 fl">
        <div class="t"><h3><a href="#">热点排行</a></h3><em><a href="#">更多&gt;&gt;</a></em></div>
        <ul class="r-newslist">
        <c:forEach items="${hotLst}" var="item" >
        <li><a href="../newschannel!show.action?id=${item.id}">${item.title}</a></li>
        </c:forEach>
        </ul>
        </div>
        </div>



        <div class="news-row box">
        <div class="news-col-1 fl">
        <div class="t"><h3><a href="../newschannel!channel.action?id=6">交流互动</a></h3><em><a href="../newschannel!channel.action?id=6">更多&gt;&gt;</a></em></div>
        <div class="pt15">
        <div class="box">
        <div class="fl uimg">
        <a href="#"><img src="${jltopNews.url}"></a>
        </div>
        <div class="fr newscon">
        <h5 class="col_5 f14 fb mb5">
        <a href="#">${jltopNews.title}</a></h5>
        <p class="lh20"><span class="col_3">${jltopNews.title}</span><a href="#" class="col_2">[详细]</a></p>
        </div></div>
        <ul class="newslist news-list-2">
        <c:forEach items="${jlLastLst}" var= "item" >
        <c:if test="${'1' eq item.fromUrl}" >
        <li><a href="${item.url}">${item.title}</a></li>
        </c:if>
        <c:if test="${'0' eq item.fromUrl}" >
        <li><a href="../newschannel!show.action?id=${item.id}">${item.title}</a></li>
        </c:if>
        </c:forEach>
        </ul>

        </div>
        </div>
        <div class="news-col-2 fl">
        <div class="t"><h3><a href="../newschannel!channel.action?id=4">业界快递</a></h3><em><a href="../newschannel!channel.action?id=4">更多&gt;&gt;</a></em></div>
        <div class="pt15">
        <div class="box">
        <div class="fl uimg">
        <a href="#"><img src="${yjtopNews.url}"></a>
        </div>
        <div class="fr newscon">
        <h5 class="col_5 f14 fb mb5">
        <a href="../newschannel!show.action?id=${yjtopNews.id}">${yjtopNews.title}</a></h5>
        <p class="lh20"><span class="col_3">${yjtopNews.title}</span><a href="#" class="col_2">[详细]</a></p>
        </div></div>
        <ul class="newslist news-list-2">
        <c:forEach items="${yjLastLst}" var= "item" >
        <c:if test="${'1' eq item.fromUrl}" >
        <li><a href="${item.url}">${item.title}</a></li>
        </c:if>
        <c:if test="${'0' eq item.fromUrl}" >
        <li><a href="../newschannel!show.action?id=${item.id}">${item.title}</a></li>
        </c:if>
        </c:forEach>
        </ul>

        </div>

        </div>

        <div class="news-col-3 fl">
        <div class="t"><h3><a href="../newschannel!channel.action?id=8">活动播报</a></h3><em><a href="../newschannel!channel.action?id=8">更多&gt;&gt;</a></em></div>
        <ul class="r-newslist">
        <c:forEach items="${hdbbLst}" var="item" >
        <c:if test="${'1' eq item.fromUrl}" >
        <li><a href="${item.url}">${item.title}</a></li>
        </c:if>
        <c:if test="${'0' eq item.fromUrl}" >
        <li><a href="../newschannel!show.action?id=${item.id}">${item.title}</a></li>
        </c:if>
        </c:forEach>
        </ul>
        </div>
        </div>

        <div class="news-row">
        <div class="t"><h3><a href="">图文新闻</a></h3><em><a href="">更多&gt;&gt;</a></em></div>

        <div class="scroll-photo">
        <div class="scroll-photo-1">
        <ul>
        <c:forEach items="${photoNewsLst}" var="item">
        <li>
        <a  href="../newschannel!show.action?id=${item.id}" class="img-scroll" target="_blank" ><img src="../${item.photo}" width="100" height="90px"></a>
        <a href="../newschannel!show.action?id=${item.id}"  class="scroll-img-title" target="_blank" >${item.simpleTitle}</a>
        </li>
        </c:forEach>
        <li>
        <a class="img-scroll" href="#"><img src=".#" width="100" height="90px"></a>
        <a class="scroll-img-title">测试测试测试</a>
        </li>
        <li>
        <a class="img-scroll" href="#"><img src=".#" width="100" height="90px"></a>
        <a class="scroll-img-title">测试测试测试</a>
        </li>
        <li>
        <a class="img-scroll" href="#"><img src=".#" width="100" height="90px"></a>
        <a class="scroll-img-title">测试测试测试</a>
        </li>
        <li>
        <a class="img-scroll" href="#"><img src=".#" width="100" height="90px"></a>
        <a class="scroll-img-title">测试测试测试</a>
        </li>
        <li>
        <a class="img-scroll" href="#"><img src=".#" width="100" height="90px"></a>
        <a class="scroll-img-title">测试测试测试</a>
        </li>
        <li>
        <a class="img-scroll" href="#"><img src=".#" width="100" height="90px"></a>
        <a class="scroll-img-title">测试测试测试</a>
        </li>
        <li>
        <a class="img-scroll" href="#"><img src=".#" width="100" height="90px"></a>
        <a class="scroll-img-title">测试测试测试</a>
        </li>
        <li>
        <a class="img-scroll" href="#"><img src=".#" width="100" height="90px"></a>
        <a class="scroll-img-title">测试测试测试</a>
        </li>

        </ul>
        </div>
        </div>

        </div>

        <div class="news-row box">
        <div class="news-col-1 fl">
        <div class="t"><h3><a href="../newschannel!channel.action?id=7">生活闲侃</a></h3><em><a href="../newschannel!channel.action?id=6">更多&gt;&gt;</a></em></div>
        <div class="">
        <ul class="pt10 newslist news-list-2">
        <c:forEach items="${shxkNewsLst}" var= "item" >
        <c:if test="${'1' eq item.fromUrl}" >
        <li><a href="${item.url}">${item.title}</a></li>
        </c:if>
        <c:if test="${'0' eq item.fromUrl}" >
        <li><a href="../newschannel!show.action?id=${item.id}">${item.title}</a></li>
        </c:if>
        </c:forEach>
        </ul>

        </div>
        </div>
        <div class="news-col-2 fl">
        <div class="t"><h3><a href="#">悬赏问答</a></h3><em><a href="#">更多&gt;&gt;</a></em></div>
        <div class="">
        <ul class="newslist pt10 news-list-2">

        <li><a href="#">测试问答测试问答</a></li>

        </ul>

        </div>
        </div>

        <div class="news-col-3 fl">
        <div class="t"><h3><a href="#">博客推荐</a></h3><em><a href="#">更多&gt;&gt;</a></em></div>
        <ul class="r-newslist">
        <li><a href="#">测试博客测试博客</a></li>
        <li><a href="#">测试博客测试博客</a></li>
        <li><a href="#">测试博客测试博客</a></li>
        <li><a href="#">测试博客测试博客</a></li>
        <li><a href="#">测试博客测试博客</a></li>
        </ul>
        </div>
        </div>



        <div class="news-row"></div>
        </div>
        <%@include file="../common/foot.jsp" %>


        </body>
        <script>
        $('.scroll-photo').elastislide({
        imageW : 110,
        minItems : 5
        });
        </script>
        </html>