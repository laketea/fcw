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
         <script charset="utf-8" src="../resource/editor/kindeditor.js"></script>
<script charset="utf-8" src="../resource/editor/lang/zh_CN.js"></script>
         <script type="text/javascript" src="../resource/js/common.js"></script>
        <link type="text/css" rel="stylesheet" href="../resource/css/common.css" />
        <link type="text/css" rel="stylesheet"
        href="../resource/css/ui-default.css" />
        <link type="text/css" rel="stylesheet"
        href="../resource/css/default.css" />
        <link type="text/css" rel="stylesheet" href="../resource/css/newscolumn.css" />
        </head>
      
<script>
	
			var editor;
			KindEditor.ready(function(K) {
				editor = K.create('#txtContent', {
					width:'520px',
					minWidth:'520px',
					height:'160px',
					minHeight:'160px',
					items : [
						'fontname', 'fontsize', '|', 'forecolor', 'hilitecolor', 'bold', 'italic', 'underline',
						'removeformat', '|', 'justifyleft', 'justifycenter', 'justifyright', 'insertorderedlist',
						'insertunorderedlist', '|', 'emoticons']
				});
			});
			function syncTextArea(){
		editor.sync();
		return true;
	}
		</script>
        <body>

        <%@include file="../common/top.jsp" %>
        <c:set var="channelName" value="房产资源" scope="request" />
        <%@include file="../common/head.jsp" %>
        <div id="top-grad"></div>

        <div id="news" class="wrap center960 box ">
        <div class="news-row adv">

        </div>

        <div class="title" style="height:35px;" >

        <div class="titleheaderwrap" >
        <div class="titlecurrent" style="float:left;padding-left:0px;font-size:12px">
        <a class="link_01" target="_blank" href="../default!index.action">房资网</a> &gt;
        <a class="link_01" target="_blank" href="../fcnews!index.action">房产资讯</a> &gt;<a class="link_01" target="_blank" href="../newschannel!channel.action?id=${channel.id}"> ${channel.name}</a>
        </div>
		<form action="newschannel!search.action" method="post">
        <div class="titleheader22">
        <input type="text" value="" name="keywords" class="but_11">
        <input type="submit" onmouseover="style.cursor='hand'" value="" class="but_22">
        
        </div>
        </form>
       </div>
        </div>

        <div class="news-column-content">
        <div class="contentleft2">
        <div class="contentleft01">
        </div>
        <div class="contentleft02">
        <div class="xsfsxq">
        <h1>${news.title}</h1>
        </div>
        <div class="xsfsxq2">${news.pbTime}
        <span class="fontblue mlr5"><a target="_blank" href="${news.siteUrl}">${news.siteName}</a></span>
        <span class="fontblue mlr155"><span style="display:inline;width:100px;" id="commentnum"></span></span>
        <span class="fontblue mlr5"><a href="#)">收藏</a></span>
        <span class="fontblue mlr5"><a href="#">打印</a></span>
       </div>

        <div class="jjxq fontjj"><strong>[ 摘 要 ]</strong> ${news.description}</div>
        <div class="ad005">
        <div style="position:relative; visibility:visible; width:590px;height:50px;"></div>
        </div>
        <div class="newxq_B01_05">
            <div class="xsfsxqzw">
        <p> ${news.content}</p>
        </div>
        </div>


        </div>

        <div class="news-recomment">
        <div class="recomment-title">新闻评论</div>
        <ul class="comment-ul">
        <c:if test="${empty page.list}" >
        	<li style="height:50px;line-height:50px;text-algin:center">暂无评论</li>
        </c:if>
         <c:forEach  items="${page.list}" var="item" varStatus="status"  > 
        <li>
        <div>
        <a href="#">${item.userName }</a>:<span>${item.content}</span>
        </div>
        <div class="comment-time">发布与 ${item.pbTime}</div>
        </li>
       </c:forEach>
        </ul>
        <div class="comment-page">

        <div class="cmt-page" style="padding-left:18px;">
        <pg:pager url="newschannel!show.action" items="${page.totalRecords}" maxPageItems="10" export="currentPageNumber=pageNumber">
        <pg:param name="id" value="${id}"/>
        <pg:first>

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

        </pg:last>
        </pg:pager>
        </div>

        </div>
        <div class="talk">
            <h2>我要说两句</h2>
        <div class="box">
        <div class="fl comment-hd">testsfdsf</div>
        <div class="fl comment-txt">
        <c:if test="${empty login}" >
        <div id="divNotLogin" class="NotLogin">
        您好，请登录后进行评论。点击 <a class="blue" id="commentLogin" href="../user/user!login.action">登录</a> 或 <a id="commentReg" class="blue"  href="../user/reg.jsp"> 注册新账号</a></div>
        </c:if>
         <c:if test="${not empty login}" >
        <textarea style="width:320px;height:100px;" id="txtContent"  name="content"></textarea>
        <input type="hidden" id="sourceId" value="${id}">
        <input type="hidden" id="typeId" value="1">
        </c:if>
        
        </div>
        </div>
        <div class="box"><input type="submit"  id="commentSubmit" value="" onClick="return syncTextArea();" class="btn_fabu"></div>
        
        </div>
        </div>
        </div>
        <div class="contentright">
        <div class="column-news">
        <div class="newscolumn">
        <div class="column"><a target="_blank" href="#">24小时排行榜</a></div>
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

        <div class="column-news">
        <div class="newscolumn">
        <div class="column"><a target="_blank" href="#">下载排行</a></div>
        </div>
        <div class="jszxnewslist0301">
        <ul>
        <c:forEach items="${hotInforList}" var="item" >
        <li><span>${item.downCount}</span><a target="_blank" href="#">${item.name}</a></li>
        </c:forEach>
        </ul>
        </div>
        </div>



        </div>


        </div>

        </div>


        </div>
        <%@include file="../common/foot.jsp" %>


        </body>
        </html>