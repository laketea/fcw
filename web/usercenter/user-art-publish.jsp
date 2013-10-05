<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
<title>房产网-房产资源</title>
<link type="text/css" rel="stylesheet" href="../resource/css/default.css" />

<link type="text/css" rel="stylesheet" href="../resource/css/common.css" />
<link type="text/css" rel="stylesheet" href="../resource/css/ui-default.css" />
<link type="text/css" rel="stylesheet" href="../resource/css/company.css" />
<link type="text/css" rel="stylesheet" href="../resource/css/usercenter.css" />
<script type="text/javascript" src="../resource/js/jquery.js"></script>
<script type="text/javascript" src="../resource/js/blog.js"></script>
<script charset="utf-8" src="../resource/editor/kindeditor.js"></script>
<script charset="utf-8" src="../resource/editor/lang/zh_CN.js"></script>
</head>
<body>
	<%@include file="../common/top.jsp"%>
	<c:set var="channelName" value="房产资源" scope="request" />
	<%@include file="../common/head.jsp"%>
	<div id="top-grad"></div>

	<%--主体开始--%>


	<div id="user-center" class="wrap center960 box ">
		<div class="cur-nav">
			当前位置：<a href="resource!index.action">房资网</a> ><a href="#">用户中心</a>
		</div>
		<div class="user-center-container box">
			<!--左边导航开始-->
			<%@include file="../common/user-center-left.jsp"%>
			<!--左边导航结束-->



			<!--中间栏开始-->
			<div class="uc-main uc-main-style">
				

				<div class="main-block">
					<ul class="uc-nav box">
						<li ><a href="userart!others.action?flag=0">好友日志</a></li>
						<li ><a href="userart!my.action">我的日志</a></li>
						<li ><a href="userart!others.action?flag=1">随便看看</a></li>
						<li class="cur" class="a-btn"><a href="userart!publish.action">发布日志</a></li>
					</ul>
					<p class="uc-c-nav">
						
					</p>
				</div>
				
				<div class="main-block">
				<form action="userart!save.action" method="post" >
					<table class="pb-wz-table">
						<tr>
							<td class="left-td">标题:</td>
							<td><input type="text" name="art.title" size="60"></td>
						</tr>
						<tr>
							<td class="left-td">内容：</td>
							<td><textarea name="art.content" rows="15" cols="70" class=""></textarea></td>
						</tr>
						<tr>
							<td class="left-td" >分类：</td>
							<td><select name="art.catalogId">
									<option value="1">测试分类</option>
									<option value="2">测试分类</option>
									<option value="3">测试分类</option>
									<option value="4">测试分类</option>
							</select></td>
						</tr>
						<tr>
							<td class="left-td">标签：</td>
							<td><input type="text" size="40" ></td>
						</tr>
						<tr>
							<td class="left-td" >权限：</td>
							<td><select name="art.power" >
									<option value="1">仅自己可见</option>
									<option value="2">仅好友可见</option>
									<option value="3">测试分类</option>
									<option value="4">测试分类</option>
							</select></td>
						</tr>
						<tr style="height: 40px;">
							<td class="left-td"></td>
							<td>
								<input type="submit" value="发布日志">
							</td>
						</tr>
					</table>
				</form>
				</div>
				
			</div>
			
			
			<!--中间栏结束-->
			

		</div>

	</div>
	<%--主体结束--%>

	<%@include file="../common/foot.jsp"%>

</body>
</html>