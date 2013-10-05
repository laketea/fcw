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
<link type="text/css" rel="stylesheet" href="../resource/css/reg.css" />
<link type="text/css" rel="stylesheet" href="../resource/css/login.css" />
<script src="../resource/js/jquery.js"></script>
<script src="../resource/js/login.js"></script>
</head>
<body>
	<%@include file="../common/top.jsp"%>
	<div id="login-main" class="center960">
		<div class="logo"></div>
		<div class="des"></div>
		<div class="content">
			<div class="ct">
				<div class="h41"></div>
				<!-- <form method="post" action="user!login.action" id="formReg"> -->
				<div class="right_m_login">
					<div class="login_icon">
						<span class="login_icon_i">欢迎登录房产资源网</span>
					</div>
					<dl>
						<dd>用户名：</dd>
						<dt>
							<input type="text"
								style="height: 31px; line-height: 31px;
                                    border: 1px solid #aaaaaa; width: 288px"
								id="txtName" name="user.email">
						</dt>
					</dl>
					<dl>
						<dd>密&nbsp;&nbsp;码：</dd>
						<dt>
							<input type="password"
								style="height: 31px;
                                    line-height: 31px; border: 1px solid #aaaaaa; width: 288px"
								id="txtPassword" name="user.password">
						</dt>
					</dl>
					<div class="login_y">
						<div class="yan_f fl">验证码：</div>
						<div class="yan_input fl">
							<input type="text"
								style="height: 31px; line-height: 31px;
                                    border: 1px solid #aaaaaa; width: 106px"
								id="txtVerifycode" name="code">
						</div>
						<div class="yan_font fl">
							<img width="65" height="34" src="rand.action"
								onclick="changeValidateCode(this)" alt="看不清？点击更换"
								title="看不清？点击更换" style="cursor: pointer;">

						</div>
						<script type="text/javascript">
							function changeValidateCode(obj) {
								//获取当前的时间作为参数，无具体意义   
								var timenow = new Date().getTime();
								//每次请求需要一个不同的参数，否则可能会返回同样的验证码   
								//这和浏览器的缓存机制有关系，也可以把页面设置为不缓存，这样就不用这个参数了。   
								obj.src = "rand.action?d=" + timenow;
							}
						</script>
					</div>
					<div class="yan_l">
						<%--<span style="padding-top: 4px;" class="fl"> <input--%>
							<%--type="checkbox" name="chk" id="chk"> </span><span class="fl">&nbsp;<label--%>
							<%--for="chk" style="cursor: pointer;">记住登录状态</label>&nbsp;&nbsp;<a--%>
							<%--target="_blank" style="color: #297DC5;" href="#">忘记密码？</a> </span>--%>
					</div>
					<div class="login_btn">
						<input type="image"
							style="height:35px;width:127px;border-width:0px;"
							src="../resource/img/Login_btn.gif" text="登录" id="btnSubmit">
						<span class="login_font"> <a target="_blank" href="reg.jsp"
							id="ypl_register">立即注册</a> </span>
					</div>
					<div style="padding-left: 59px;">
						<a
							style="background: url(../resource/img/SinaIco.gif) no-repeat;
                                color: #333; font-size: 14px; padding-left: 18px; padding-top: 4px;"
							href="javascript:__doPostBack('LinkButton1','')" title="使用新浪微博登录"
							id="LinkButton1">新浪微博登录</a> &nbsp; &nbsp; &nbsp; <a
							style="background: url(../resource/img/QQIco.gif) no-repeat;
                                color: #333; font-size: 14px; padding-left: 18px; padding-top: 4px;"
							href="javascript:__doPostBack('LinkButton2','')" title="使用QQ登录"
							id="LinkButton2">QQ登录</a>
					</div>
				</div>
				<!-- </form> -->
			</div>
		</div>
	</div>



	<div id="footer">
		<a href="http://help.dichan.com" target="_blank">新浪地产</a>┊<a
			href="http://help.dichan.com/help.html" target="_blank">网站帮助</a>┊<a
			href="http://union.dichan.com" target="_blank">房商推广联盟</a>┊<a
			href="http://passport.dichan.com/reg" target="_blank">会员注册</a>┊<a
			href="http://help.dichan.com/sitemap.html" target="_blank">网站地图</a>┊<a
			href="http://help.dichan.com/contact.html" target="_blank">联系我们</a>┊<a
			href="http://www.dichan.com/" target="_blank">房地产网址导航</a>┊<a
			href="http://help.dichan.com/lawyer1.html" target="_blank">网站律师</a>┊<a
			href="http://help.dichan.com/feedback.html" target="_blank">意见反馈</a><br>
		<a href="http://bj.house.sina.com.cn/sina-leju/lj_about.html"
			target="_blank">乐居简介</a>┊<a
			href="http://bj.house.sina.com.cn/sina-leju/lj_english.html"
			target="_blank">About Leju</a>┊<a href="http://www.leju.com/ads/"
			target="_blank">广告服务</a>┊<a
			href="http://bj.house.sina.com.cn/sina-leju/lj_job.html"
			target="_blank">诚聘英才</a>┊<a href="http://www.cric.com/"
			target="_blank">中国房产信息集团</a><br> Copyright @ 1996-2012 SINA
		Corporation, All Rights Reserved<br>
		乐居房产、家居产品用户服务、产品咨询购买、技术支持客服服务热线：400-606-6969
	</div>


</body>
</html>