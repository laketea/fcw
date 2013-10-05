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
</head>
<body>
	<%@include file="../common/top.jsp"%>
	<c:set var="channelName" value="资料中心" scope="request" />
	<%@include file="../common/head.jsp"%>
	<div id="top-grad"></div>

	<!-- 中间开始 -->


	<div id="all" class="center960">
		<div class="h10"></div>
		<div class="width960">
			<div class="location">
				<a href="#">首页</a> &gt;<a
					href="#"> ${channel.name}</a>
			</div>
			<div class="sc">
				<input type="hidden" value="2" id="hidtype" name="hidtype">
				<input type="hidden" value="17" id="hidclassid" name="hidclassid">
			</div>
		</div>
		<div class="h10"></div>
		<div class="width960">
			<div class="left">
				<div class="list_fl fixed">
					<div class="li_fltit">
						<div class="fl_left">
							${channel.name} <span>共15974个</span>
						</div>
						<div class="fl_right">
							<ul>
								<li class="save">[<a
									onclick="com_all_favoriteadd('scdiv1',300,150,this,0,-220,location.href,'软件/工具','6', 1)"
									style="cursor: pointer;">收藏</a>]</li>

							</ul>
						</div>
					</div>
					<div class="h10"></div>
					<div class="li_flcon">
						<ul>
						<c:forEach var="item" items="${channelLst}" varStatus="s">
							<li><a title="${item.name}"
								href="#">${item.name}</a> <span>(502)</span>
							</li>
						</c:forEach>
							
						</ul>
					</div>
					<div class="h10"></div>

				</div>
				<div class="h10"></div>
				<div id="cmiddAdIframe"></div>
				<div class="h10"></div>

				<div>
					<div class="title5">
						<ul>
							<li
								"="" onclick="location.href='#'"
								title="当前排序：从高到低" class="sa01 ">本栏精品</li>
							<li
								onclick="location.href='#'"
								title="当前排序：从高到低" class="sa02 ">按上传时间</li>
							<li
								onclick="location.href='#'"
								title="点击从低到高排序" class="sa02 ">按价格排行</li>
							<li
								onclick="location.href='#'"
								title="点击从低到高排序" class="sa02 ">按人气排行</li>
						</ul>
					</div>
					<div class="indicat fixed">
						<div id="Panel_Search_Result">

							<div class="con_c fixed">
								<c:forEach var="sitem" items="${inforLst}" varStatus="s">
								<div class="lihead">
									<div class="lihead_l2">
										<a title="" target="_blank"
											href="#">
											${sitem.name}</a>
									</div>
									<div class="lihead_r">
										<a target="_blank"
											href="#">查看全部<span
											class="red">0</span>条评论</a>
									</div>
								</div>
								<div class="h10"></div>
								<div class="licon">
									<div class="liconpic">
										<img width="50" height="50" title="rar" src="../resource/imgrar.gif">
									</div>
									<div class="liconwd">
										<ul>
											<li>上传时间：2013-01-11&nbsp;&nbsp; 大小：4.01MB &nbsp;&nbsp;
												价格：<span class="red">0.00</span> 积分</li>
											<li>资料等级：VIP<img width="11" height="11"
												src="../resource/imglittlestar.gif"><img width="11"
												height="11" src="../resource/imglittlestar.gif"><img
												width="11" height="11" src="../resource/imglittlestar.gif">
												&nbsp;&nbsp;用户评分：<span class="blu">80</span> &nbsp;&nbsp;
												关注人数：<span class="blu">0</span>
											</li>
											<li>上 传 者： <a target="_blank"
												href="#">
													youxinren</a> &nbsp;&nbsp;（<a target="_blank"
												href="#">去逛逛他的知识店铺</a>）</li>
										</ul>
									</div>
									<div class="licondw">
										<a title="立即下载qq透明皮肤文件包" target="_blank"
											href="#">
											立即下载</a>
									</div>
								</div>
								<div class="h10"></div>
								<div class="h10"></div>
								</c:forEach>

							</div>
							<div style="text-align: center; padding: 0px 10px;">
								<span id="lbl_pagebottom"><div class="kuang">
										<ul>
											<li class="next3"><a> 共12页/115条 </a>
											</li>
											<li class="current"><a>1</a></li>
											<li><a href="#">2</a>
											</li>
											<li><a href="#l">3</a>
											</li>
											<li><a href="#">4</a>
											</li>
											<li><a href="#">5</a>
											</li>
											<li><a href="#l">6</a>
											</li>
											<li class="two"><a
												href="#"
												title="下一页">&gt;</a>
											</li>
											<li class="two"><a
												href="#"
												title="最后页">&gt;&gt;</a>
											</li>
											<li><input type="text"
												onkeydown="if(event.keyCode==13)window.location.href='#' + escape(this.value) + '.html'"
												name="txtPageGo" class="next1" maxlength="4" value="">
											</li>
											<li class="next"><a
												onclick="javascript:window.location.href='#' + this.parentNode.parentNode.getElementsByTagName('input')[0].value + '.html';return false;"
												href="#">跳转</a>
											</li>
										</ul>
									</div>
								</span>
							</div>

						</div>


					</div>
				</div>
			</div>
			<div class="right">



				<div id="panel_HotTop">

					<div class="fldh2">
						<div class="fldh2_title2">
							<ul>
								<li onmouseover="switchTag('_ad','_ad_list',1,3,'s01','s02');"
									id="_ad1" class="s01">周</li>
								<li onmouseover="switchTag('_ad','_ad_list',2,3,'s01','s02');"
									id="_ad2" class="s02">月</li>
								<li onmouseover="switchTag('_ad','_ad_list',3,3,'s01','s02');"
									id="_ad3" class="s02">总</li>
							</ul>
							<strong>下载排行榜</strong>
						</div>
						<div class="clear"></div>
						<div class="indication2 fixed">
							<div class="showbox" id="_ad_list1">
								<div class="h_con">
									<ul>
										<li><a
											href="http://www.shangxueba.com/share/p3537340.html"
											title="4399造梦西游，造梦西游3 修改大师 V3.0.9.7 豪华版最新zip" target="_blank">4399造梦西游，造梦西游3
												修改大师 V3.0.9.7 豪华版最新zip</a>
										</li>
										
									</ul>
								</div>
							</div>
							<div class="Hidebox" id="_ad_list2">
								<div class="h_con">
									<ul>
										<li><a
											href="http://www.shangxueba.com/share/p3537340.html"
											title="4399造梦西游，造梦西游3 修改大师 V3.0.9.7 豪华版最新zip" target="_blank">4399造梦西游，造梦西游3
												修改大师 V3.0.9.7 豪华版最新zip</a>
										</li>
										
									</ul>
								</div>
							</div>
							<div class="Hidebox" id="_ad_list3">
								<div class="h_con">
									<ul>
										<li><a
											href="http://www.shangxueba.com/share/p3537340.html"
											title="4399造梦西游，造梦西游3 修改大师 V3.0.9.7 豪华版最新zip" target="_blank">4399造梦西游，造梦西游3
												修改大师 V3.0.9.7 豪华版最新zip</a>
										</li>
										
									</ul>
								</div>
							</div>


						</div>
					</div>
					<div class="h10"></div>

				</div>

			</div>
		</div>
		<div class="h10"></div>



	</div>




	<%@include file="../common/foot.jsp"%>
</body>
</html>