<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page language="java" import="com.fcw.common.WebCfg"%>
<div id="top-main">
	<div id="top-logo">
		<a href="<%=WebCfg.SITE_URL.getValue()%>" ><img src="../resource/img/logo.png"></a>
	</div>
	<div id="top-search">
		<div id="tp-search">
			<div id="search-main">
				<input type="text" id="search-ipt" status="a" class="search-ipt-default" value="<%=WebCfg.RES_KEYWORD.getValue()%>"> <input id="tp-search-btn" type="image" src="../resource/img/tp-search-btn.png">
				<div id="search-tab">
					<ul>
						<li class="curTab" curType="1" value="<%=WebCfg.RES_KEYWORD.getValue()%>">资源</li>
						<li curType="2" value="<%=WebCfg.INFO_KEYWORD.getValue()%>">资料</li>
						<li curType="3" value="<%=WebCfg.BUSINESS_KEYWORD.getValue()%>">招标</li>
                         <li curType="4" value="<%=WebCfg.NEWS_KEYWORD.getValue()%>">资讯</li>
					</ul>
					<input type="hidden" id="curType" value="1">
				</div>
				<div id="holt-world">
    <c:forEach var="item" items="${topCache.hotKeyWordsLst}" varStatus="s">
    <a href="${item.url}" target="_bank">${item.name}</a>
    </c:forEach>
    </div>
			</div>

		</div>
	</div>
</div>

<div id="top-menu" class="ui-menu-content">
	<div class="center960" style="position:relative">

    

    <div id="top-cur-column" class="ui-cur-column"><a href="/sfw/resource!index.action">房产资源</a>

	<div id="top-exnav"  class="intr-menu explan-nav <c:if test="${1 eq isDefault}">isDefault</c:if>">
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
    <div class="force ftitle">${item.dfTitle}</div>
    <div class="force fline">${item.dfFirstLine}</div>
    <div class="force sline">${item.dfSecondLine}</div>
    <div class="force dfphoto"><img border="0" width="180" height="220" src="../${item.dfPhoto}"></div>
    </div>
    </div>
    </li>
    </c:forEach>
    </ul>
    </div>


		</div>
		<div id="top-menu-main">
			<ul>
				<li style="background: none; width: 60px;"><a href="/sfw/default!index.action">首页</a></li>
				<li><a href="/sfw/fcnews!index.action">房产资讯</a></li>
				<li><a href="/bbs">房产论坛</a></li>
				<li><a href="/blog">房产博客</a></li>
				<li><a href="/sfw/business!index.action">商务合作</a></li>
				<li><a href="/sfw/information!index.action">资料中心</a></li>
			</ul>
		</div>
	</div>
</div>
