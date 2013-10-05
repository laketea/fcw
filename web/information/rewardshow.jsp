
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<title>房产网-登录</title>
<link type="text/css" rel="stylesheet"
	href="../resource/css/default.css" />

<link type="text/css" rel="stylesheet" href="../resource/css/common.css" />
<link type="text/css" rel="stylesheet"
	href="../resource/css/ui-default.css" />
<link type="text/css" rel="stylesheet"

	href="../resource/css/download.css" />
	 <link type="text/css" rel="stylesheet" href="../resource/css/newscolumn.css" />
<script src="../resource/js/jquery.js"></script>
 <script charset="utf-8" src="../resource/editor/kindeditor.js"></script>
<script charset="utf-8" src="../resource/editor/lang/zh_CN.js"></script>
<script src="../resource/js/common.js"></script>
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
	<%@include file="../common/top.jsp"%>
	<c:set var="channelName" value="资料中心" scope="request" />
	<%@include file="../common/head.jsp"%>
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
						<a href="#"><img width="163" height="37"
							src="../resource/img/banner_btn.jpg"> </a>
					</dt>
				</dl>
			</div>
		</div>

		<div class="h10"></div>
		<div class="width960">
			<div class="info-top-nav">
				当前位置:><a href="reward!index.action">资料悬赏</a>
			</div>
			<!-- 热门推荐 -->
			<div class="left">
				<%--<div class="info-search"></div>--%>
				<div class="h10"></div>

				<div class="reward-container">
					<div style="padding:10px 20px">
						<div class="reward-detail">
							<h2>${reward.title}</h2>
							<div class="con_f1">
								<span class="con_icon">资源币：</span> <span class="r_shop_c_b2">${reward.gold}</span>&nbsp;&nbsp;&nbsp;&nbsp;种类：${reward.typeName}&nbsp;&nbsp;&nbsp;&nbsp;求购者：${reward.userName}&nbsp;&nbsp;&nbsp;&nbsp;浏览数：${reward.viewCount}&nbsp;&nbsp;&nbsp;&nbsp;发布时间：${reward.pbTime}
							</div>
							<div class="rwd-content">${reward.content}</div>
						</div>


						<div class="rwd-rpl-ctn">&nbsp;&nbsp;回复列表</div>
						<ul class="rwd-rpl-list">
							<c:if test="${empty page.list}">
								<li class="box">
									<div style="height: 50px;line-height:30px">暂无回复</div>
					</div>
					</li>
					</c:if>
					<c:forEach var="item" items="${page.list}">
						<li class="box">
							<div class="flr">
								<a href="#"><img src="#">
								</a>
								<div>${item.userName}</div>
							</div>
							<div class="frr">
								<h3>${item.pbTime}</h3>
								<p>${item.content}</p>
								<a href="${item.url}">${item.url}</a>
							</div></li>
					</c:forEach>
					<c:if test="${not empty page.list}">
						<div class="info-page" style="padding-left:10px">
							<pg:pager url="reward!show.action" items="${page.totalRecords}"
								maxPageItems="3" export="currentPageNumber=pageNumber">
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
											<a> <font color="red">${pageNumber }</font>
											</a>
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
					
				<div class="rwd-rpl-ctn">&nbsp;&nbsp;我来回复</div>	
        <div class="talk">
           
        <div class="box">
        <div class="fl comment-hd">内容:</div>
        <div class="fl comment-txt">
        <c:if test="${empty login}" >
        <div id="divNotLogin" class="NotLogin">
        您好，请登录后进行评论。点击 <a class="blue" id="commentLogin" href="../user/user!login.action">登录</a> 或 <a id="commentReg" class="blue"  href="../user/reg.jsp"> 注册新账号</a></div>
        </c:if>
         <c:if test="${not empty login}" >
        <textarea style="width:320px;height:100px;" id="txtContent"  name="content"></textarea>
        <input type="hidden" id="sourceId" value="${id}">
        <input type="hidden" id="typeId" value="10">
        </c:if>
        
        </div>
        </div>
        <div class="box" style="margin-top:10px">
        <div class="fl comment-hd">链接:</div>
        <div class="fl comment-txt"><input type="text" name="url" id="txtUrl" size="80"></div>
        </div>
        <div class="box"><input type="submit" style="margin-right:35px"  id="commentSubmit" value="" onClick="return syncTextArea();" class="btn_fabu"></div>
        
        
				</div>



			</div>






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
										href="#" title="点击看他/她还上传了哪些资料">tianebandeyazi</a></li>

								</ul>
							</div>
						</div>
						<div class="Hidebox" id="_ed_list2">
							<div class="earn_con">
								<ul>
									<li><span class="xb">119.3600</span><a target="_blank"
										href="#" title="点击看他/她还上传了哪些资料">tianebandeyazi</a></li>

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
										href="#" title="点击看他/她还上传了哪些资料">ssover</a></li>

								</ul>
							</div>
						</div>
						<div class="Hidebox" id="_ad_list2">
							<div class="earn_con">
								<ul>
									<li><span class="geshu">54312个</span><a target="_blank"
										href="#" title="点击看他/她还上传了哪些资料">ssover</a></li>

								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>
	
	<div class="h10"></div>

	</div>


	<%@include file="../common/foot.jsp"%>
</body>
</html>