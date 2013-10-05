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
        <!-- 热门推荐 -->
        <div class="left">
        <div class="index_recommend">
        <div class="index_recommend_title">
        <ul>
        <li class="sss01" id="_tj1"><a>普通推荐</a>
        </li>
        <li class="sss02" id="_tj2"><a>VIP推荐</a>
        </li>
        </ul>
        <span class="index_recommend_c fr"><a
        href="reward!index.action">[查看全部悬赏]</a>
        </span>
        </div>
        <div class="index_recommend_content">
        <div class="h10"></div>
        <div id="_tj_list1" class="showbox">
        <ul>
        <c:forEach var="item" items="${pdRecmdLst}" >
        <li><span class="index_list3 fl"
        style="BACKGROUND: url(../resource/images/typedoc.gif) no-repeat left center"><a
        target="_blank"
        href="information!show.action?id=${item.id}"
        title="${item.name}">${item.name}</a>
        </span><br>
        <span class="index_list_f">分类：${item.channelName}<a target="_blank"
        href="javascript:void" title=""
        class="idx_tit"></a> 上传者：<a
        href="#">${item.userName}</a>
        </span>
        </li>
        </c:forEach>
        </ul>
        </div>
        <div class="Hidebox" id="_tj_list2">
        <ul>
        <c:forEach var="ritem" items="${pdRecmdLst2}" >
        <li><span class="index_list3 fl"
        style="BACKGROUND: url(../resource/images/typedoc.gif) no-repeat left center"><a
        target="_blank"
        href="information!show.action?id=${item.id}"
        title="${item.name}">${item.name}</a>
        </span><br>
        <span class="index_list_f">分类：${item.channelName}<a target="_blank"
        href="javascript:void" title=""
        class="idx_tit"></a> 上传者：<a
        href="#">${item.userName}</a>
        </span>
        </li>
        </c:forEach>
        </ul>
        </div>
        </div>
        </div>
        <div class="h10"></div>
        <div class="index_class box">
        <div class="index_class_title">&nbsp;&nbsp;资料分类</div>
        <div>
        <ul>
        <c:forEach var="item" items="${channelLst}"  varStatus="status" >
        <li
        <c:if test="${2 eq status.index || 3 eq status.index  || 5 eq status.index || 6 eq status.index || 9 eq status.index    }" > class="index_class_bg"</c:if>
        <c:if test="${4 eq status.index}" > style="WIDTH: 673px"</c:if>


        ><span class="index_class_icon"><a target="_blank"
        href="information!channel.action?channelId=${item.id}"
        style="BACKGROUND-IMAGE: none">${item.name}</a> </span><br>
        <c:forEach var="child" items="${item.childChannels}" >
        <a target="_blank"
        href="information!channel.action?channelId=${child.id}">${child.name}</a>
        </c:forEach>
        <a target="_blank"
        href="information!channel.action?channelId=${item.id}"
        style="BACKGROUND-IMAGE: none; COLOR: #e56a02">查看全部&gt;&gt;</a>
        </li>
        </c:forEach>


        </ul>
        </div>
        </div>
        </div>
        <div class="right">

        <%--<div class="index_advise">--%>
        <%--<div class="index_title">--%>
        <%--<strong>网站公告</strong>--%>
        <%--</div>--%>
        <%--<div class="h10"></div>--%>
        <%--<div class="index_advise_f">--%>
        <%----%>
        <%--</div>--%>
        <%--</div>--%>
        <%--<div class="h10"></div>--%>
        <%--<div class="index_btn">--%>
        <%--<div class="h16"></div>--%>
        <%--<ul>--%>
        <%--<li class="index_btn_line"><a--%>
        <%--href="#"><span--%>
        <%--class="right_btn_p"><img src="../resource/img/right_btn_p1.gif">--%>
        <%--</span><span class="right_btn_f">免费注册</span>--%>
        <%--</a>--%>
        <%--</li>--%>
        <%--<li class="index_btn_line"><a--%>
        <%--href="#"><span--%>
        <%--class="right_btn_p"><img src="../resource/img/right_btn_p2.gif">--%>
        <%--</span><span class="right_btn_f">上传资料</span>--%>
        <%--</a>--%>
        <%--</li>--%>
        <%--<li><a--%>
        <%--href="#"><span--%>
        <%--class="right_btn_p"><img src="../resource/img/right_btn_p3.gif">--%>
        <%--</span><span class="right_btn_f">我的资料</span>--%>
        <%--</a>--%>
        <%--</li>--%>
        <%--</ul>--%>
        <%--<div class="h16"></div>--%>
        <%--<ul>--%>
        <%--<li class="index_btn_line"><a--%>
        <%--href="#"><span--%>
        <%--class="right_btn_p"><img src="../resource/img/right_btn_p4.gif">--%>
        <%--</span><span class="right_btn_f">学币充值</span>--%>
        <%--</a>--%>
        <%--</li>--%>
        <%--<li class="index_btn_line"><a--%>
        <%--href="#"><span--%>
        <%--class="right_btn_p"><img src="../resource/img/right_btn_p5.gif">--%>
        <%--</span><span class="right_btn_f">管理中心</span>--%>
        <%--</a>--%>
        <%--</li>--%>
        <%--<li><a--%>
        <%--href="#"><span--%>
        <%--class="right_btn_p"><img src="../resource/img/right_btn_p6.gif">--%>
        <%--</span><span class="right_btn_f">学币提现</span>--%>
        <%--</a>--%>
        <%--</li>--%>
        <%--</ul>--%>
        <%--</div>--%>
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