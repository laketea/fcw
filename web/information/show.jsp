
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../common/include.jsp"%>
<%
	String path = request.getRequestURI();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path;
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
	href="../resource/css/newscolumn.css" />
<link type="text/css" rel="stylesheet"
	href="../resource/css/download.css" />
<script src="../resource/js/jquery.js"></script>
 <script charset="utf-8" src="../resource/editor/kindeditor.js"></script>
<script charset="utf-8" src="../resource/editor/lang/zh_CN.js"></script>
<script src="../resource/js/jquery-ui.min.js"></script>
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
				当前位置:&nbsp;&nbsp;<a href="information!index.action">资料中心</a>
				<c:if test="${not empty pchannel}">
        >&nbsp;<a
						href="information!channel.action?channelId=${pchannel.id}">${pchannel.name}</a>
				</c:if>
				>&nbsp;<a href="information!channel.action?channelId=${channel.id}">${channel.name}</a>
			</div>
			<!-- 热门推荐 -->

			<div class="left">


				<div class="h10"></div>
				<div class="info-contain box">

					<h2>${infor.name}</h2>
					<div style="padding:0 10px 10px 10px">
						<div class="box" style="position:relative">
							<ul class="info-block">
								<li><b>发布者:</b>&nbsp;&nbsp;${infor.userName}</li>
								<!-- <li><b>发布时间:</b>&nbsp;&nbsp;{infor.userName}</li> -->
								<li><b>VIP:</b>&nbsp;&nbsp;${'1'eq infor.vip ?'VIP':'否'}</li>
								<li><b>文件类型:</b>&nbsp;&nbsp;${infor.fileType}</li>
								<li><b>类型:</b>&nbsp;&nbsp; <c:if
										test="${not empty pchannel}">
        >&nbsp;${pchannel.name}
        </c:if> >&nbsp;${channel.name}</li>
								<li><b>类别:</b>&nbsp;&nbsp;文档</li>
							</ul>
							<ul class="info-block lftb">
								<li><b>评分:</b>&nbsp;&nbsp; <i
									class="icon star-big-${1<=infor.aveScore?'on':'off'}"></i> <i
									class="icon star-big-${2<=infor.aveScore?'on':'off'}"></i> <i
									class="icon star-big-${3<=infor.aveScore?'on':'off'}"></i> <i
									class="icon star-big-${4<=infor.aveScore?'on':'off'}"></i> <i
									class="icon star-big-${5<=infor.aveScore?'on':'off'}"></i></li>
								<li><b>资源币:</b>&nbsp;&nbsp;${infor.coin}</li>
								<li><b>浏览次数:</b>&nbsp;&nbsp;${infor.viewCount}</li>
								<li><b>下载次数:</b>&nbsp;&nbsp;${infor.downCount}</li>
								<li><b>评论数:</b>&nbsp;&nbsp;${infor.gradeCount}</li>
							</ul>
							<div class="adv"></div>
						</div>
						<div class="info-down box">
							<div class="info-down-icon">
								<a href="download!info.action?id=${infor.id}" class="down-link"
									did="${infor.id}"><img border="0"
									src="../resource/img/down.jpg" width="38" height="39px">
								</a>
							</div>
							<div class="down-li">
								<a href="download!info.action?id=${infor.id}" class="down-link"
									did="${infor.id}">立即下载 （${infor.fileSize}）</a>
							</div>
							<div class="down-li">
								<strong>普通会员：</strong>${infor.coin} 币
							</div>
							<div class="down-li">收藏&nbsp;&nbsp;&nbsp;&nbsp;报错</div>
							<div class="down-li">
								<strong>VIP会员：</strong>${'1'eq infor.vip ?'0':infor.coin} 币
							</div>
							<div class="down-bc fl">欢迎您下载本站资源，本站资源下载权利归网友所有！</div>
						</div>
						<div class="info-des-title">资料介绍</div>
						<div class="info-des">${infor.intro}</div>
					</div>










				</div>
				<%--评论开始--%>
				<div class="news-recomment">
					<div class="recomment-title">资料评论</div>
					<ul class="comment-ul">
						<c:if test="${empty page.list}">
							<li style="height:50px;line-height:50px;text-algin:center">暂无评论</li>
						</c:if>
						<c:forEach items="${page.list}" var="item" varStatus="status">
							<li>
								<div>
									<a href="#">${item.userName }</a>:<span>${item.content}</span>
								</div>
								<div class="comment-time">发布与 ${item.pbTime}</div></li>
						</c:forEach>
					</ul>
					<div class="comment-page">

						<div class="cmt-page" style="padding-left:18px;">
							<pg:pager url="information!show.action"
								items="${page.totalRecords}" maxPageItems="10"
								export="currentPageNumber=pageNumber">
								<pg:param name="id" value="${id}" />
								<pg:first>

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

								</pg:last>
							</pg:pager>
						</div>

					</div>
					<div class="talk">
						<h2>发表评论</h2>
						<div class="box">
							<div class="fl cmt-pf">
								评分&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span class="icon-grp">
									<i sn="1" class="icon star1 star-big-on star-icon"></i> <i
									sn="2" class="icon star2 star-big-on star-icon"></i> <i sn="3"
									class="icon star3 star-big-on star-icon"></i> <i sn="4"
									class="icon star4 star-big-on star-icon"></i> <i sn="5"
									class="icon star5 star-big-on star-icon"></i> <span
									class="pl-core" style="padding-left:10px">5</span>分 </span>
							</div>
							<div class="fl comment-hd">评论内容</div>
							<div class="fl comment-txt">
								<c:if test="${empty login}">
									<div id="divNotLogin" class="NotLogin">
										您好，请登录后进行评论。点击 <a class="blue" id="commentLogin"
											href="../user/user!login.action">登录</a> 或 <a id="commentReg"
											class="blue" href="../user/reg.jsp"> 注册新账号</a>
									</div>
								</c:if>
								<c:if test="${not empty login}">
									<textarea style="" rows="4" id="txtContent" cols="80"
										name="content"></textarea>
									<input type="hidden" id="sourceId" value="${id}">
									<input type="hidden" id="typeId" value="2">
								</c:if>

							</div>
						</div>
						<div class="box">
							<input type="submit" name="" value="" id="commentSubmit"
								onClick="return syncTextArea();" style="margin-right: 63px;" class="btn_fabu">
						</div>
					</div>
				</div>
				<%--评论结束--%>


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
		
		</div>
		<div class="h10"></div>

	</div>


	<%@include file="../common/foot.jsp"%>
</body>
</html>