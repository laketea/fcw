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
        <title>房产网-登录</title>
        <link type="text/css" rel="stylesheet"
        href="../resource/css/default.css" />

        <link type="text/css" rel="stylesheet" href="../resource/css/common.css" />
        <link type="text/css" rel="stylesheet"
        href="../resource/css/ui-default.css" />
        <link type="text/css" rel="stylesheet"
        href="../resource/css/download.css" />
        <script src="../resource/js/jquery.js"></script>
        <script src="../resource/js/common.js"></script>
        </head>
        <body>
        <%@include file="../common/top.jsp" %>
        <c:set var="channelName" value="资料中心" scope="request" />
        <%@include file="../common/head.jsp" %>
        <div id="top-grad"></div>

        <!-- 中间开始 -->


        <div id="all" class="center960">
        <div class="h10"></div>
        <div class="width960">
        <div class="index_banner">
        <dl>
        <dd>
        当前已有<span class="index_banner_c1">2</span>份资料
        </dd>
        <dd>
        已有<span class="index_banner_c2">2</span>人获得收益并提现
        </dd>
        <dt>
        <a href="#"><img
        width="163" height="37" src="../resource/img/banner_btn.jpg">
        </a>
        </dt>
        </dl>
        </div>
        </div>

        <div class="h10"></div>
        <div class="width960">
        <div class="info-top-nav">当前位置:&nbsp;&nbsp;<a href="information!index.action">资料中心</a>
         >&nbsp;搜索中心
        </div>
        <!-- 热门推荐 -->
         
        <div class="left">
        <div class="info-search box">
        <input type="hidden" id="keywords" value="${keywords}">
       	<span> 分类:&nbsp;&nbsp;<select id="info-chl"  name="cid" >
				<option value="-1">&nbsp;&nbsp;所有分类&nbsp;&nbsp;</option>
						<c:forEach var="item" items="${channelLst}" >
							<option value="${item.id}" ${item.id eq cid ? 'selected' : ''}>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${item.name}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</option>
							<c:forEach var="child" items="${item.childChannels}" >
								<option value="${child.id}" ${child.id eq cid ? 'selected' : ''} >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${child.name}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</option>
							</c:forEach>
						</c:forEach>
			</select>
		</span>
		<span>	
		<input id="info-vip" type="checkbox" value="1" name="vip" ${1 eq vip?'checked':'' } >&nbsp;&nbsp;VIP资料
		</span>
		<span>
		 关于"<b>${keywords}</b>"检索条件共${page.totalRecords}条
		</span>
		
		
		
			
			
        
        
       </div>
       
        <div class="h10"></div>
        <div class="info-latest">
        <c:forEach var="item" items="${page.list}">
        <dl>
        <dt>
        <span class="cate">[<a href="information!channel.action?channelId=${item.channel_id}">${item.channelName}</a>]</span>
        <a target="_blank" href="information!show.action?id=${item.id}" class="b">${item.name}</a>
        </dt>
        <dd class="sum">
        <a title="ppt" class="fts f_ppt" href=""></a>
        ${item.intro} </dd>
        <dd class="c box">
        <span class="fl">贡献者： ${item.userName}&nbsp;&nbsp;上传于${item.upTime}</span>
        <span class="fr"><a target="_blank" href="/Books/show/id/196">浏览（${item.viewCount}）</a> 下载（${item.downCount}）
        <i class="icon star-big-${1<=item.aveScore?'on':'off'}"></i> <i class="icon star-big-${2<=item.aveScore?'on':'off'}"></i> <i class="icon star-big-${3<=item.aveScore?'on':'off'}"></i> <i
        class="icon star-big-${4<=item.aveScore?'on':'off'}"></i> <i class="icon star-big-${5<=item.aveScore?'on':'off'}"></i> 评论（${item.gradeCount}）</a>
        </span>
        </dd>
        </dl>
        </c:forEach>
        </div>

        <div class="info-page">
        <pg:pager url="information!search.action" items="${page.totalRecords}" maxPageItems="10" export="currentPageNumber=pageNumber">
        <pg:param name="keywords" value="${keywords}"/>
        <pg:param name="vip" value="${vip}"/>
        <pg:param name="cid" value="${cid}"/>
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
        <div class="right">


        <div class="h10"></div>
        <div class="fldh2">
        <div class="index_title">
        <ul>
        <li onmouseover="switchTag('_ed','_ed_list',1,2,'ss01','ss02');"
        class="ss01" id="_ed1">周</li>
        <li onmouseover="switchTag('_ed','_ed_list',2,2,'ss01','ss02');"
        class="ss02" id="_ed2">月</li>
        </ul>
        <strong>收益排行</strong>
        </div>
        <div class="indication2 fixed right_width">
        <div id="_ed_list1">
        <div class="earn_con">
        <ul>
        <li><span class="xb">72.6300</span><a target="_blank"
        href="#"
        title="点击看他/她还上传了哪些资料">tianebandeyazi</a>
        </li>

        </ul>
        </div>
        </div>
        <div class="Hidebox" id="_ed_list2">
        <div class="earn_con">
        <ul>
        <li><span class="xb">119.3600</span><a target="_blank"
        href="#"
        title="点击看他/她还上传了哪些资料">tianebandeyazi</a>
        </li>

        </ul>
        </div>
        </div>
        </div>
        </div>
        <div class="h10"></div>
        <div class="fldh2">
        <div class="index_title">
        <ul>
        <li onmouseover="switchTag('_ad','_ad_list',1,2,'ss01','ss02');"
        class="ss01" id="_ad1">周</li>
        <li onmouseover="switchTag('_ad','_ad_list',2,2,'ss01','ss02');"
        class="ss02" id="_ad2">月</li>
        </ul>
        <strong>上传排行榜</strong>
        </div>
        <div class="indication2 fixed">
        <div id="_ad_list1" class="showbox">
        <div class="earn_con">
        <ul>
        <li><span class="geshu">16874个</span><a target="_blank"
        href="#"
        title="点击看他/她还上传了哪些资料">ssover</a>
        </li>

        </ul>
        </div>
        </div>
        <div class="Hidebox" id="_ad_list2">
        <div class="earn_con">
        <ul>
        <li><span class="geshu">54312个</span><a target="_blank"
        href="#"
        title="点击看他/她还上传了哪些资料">ssover</a>
        </li>

        </ul>
        </div>
        </div>
        </div>
        </div>
        </div>
        </div>
        <div class="h10"></div>

        </div>


        <%@include file="../common/foot.jsp" %>
        </body>
        </html>