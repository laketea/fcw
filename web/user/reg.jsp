<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../common/include.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>房产网-用户注册</title>
<link type="text/css" rel="stylesheet"
	href="../resource/css/default.css" />
<link type="text/css" rel="stylesheet" href="../resource/css/common.css" />
<link type="text/css" rel="stylesheet"
	href="../resource/css/ui-default.css" />
<link type="text/css" rel="stylesheet" href="../resource/css/reg.css" />
<script src="../resource/js/jquery.js"></script>
<script src="../resource/js/reg.js"></script>
</head>
<body>

	<div id="reg-head" class="center960">
		<div class="logo fl"></div>
		<a href="#">房产网首页</a> <span></span>
	</div>

	<div id="reg-main" class="center960">
		<div id="main-contain" class="box">
			<div class="sub">
				<h6>
					<span>注册房产网</span>
				</h6>
			</div>

			<div class="l_m" id="content">
				<div class="n_form">
					<form method="post" action="user!reg.action" id="formReg">
						<ul>
							<li>
								<div class="noticew ml10">
									<em class="s_icon i_notice"></em>您可以直接注册成为具有商务交易功能的会员。
								</div>
							</li>
							<li><span class="f_sub">电子邮箱：<em>*</em> </span><input
								type="text" name="user.email" id="Email" class="tx ipt150"><span class="err_msg"></span>
								<p class="c_fgray tip">此电子邮箱将作为房产网登陆帐号,并作为密码找回邮箱，请认真填写。</p></li>
							<li><span class="f_sub">昵称：<em>*</em> </span><input
								type="text" name="user.nick" id="NID" maxlength="15"
								class="tx ipt100"><span class="err_msg"></span>
							<%--<li><span class="f_sub">用户类型：<em>*</em> </span><select--%>
								<%--name="user.userGroup">--%>
									<%--<option value="">请选择</option>--%>
									<%--<option value="0">个人用户</option>--%>
									<%--<option value="1">公司用户</option>--%>
							<%--</select><span class="err_msg"></span>--%>
							<li><span class="f_sub">公司：<em>*</em> </span><select
								name="userInfo.companyId" class="sltCompany">
									<option value="">请选择</option>
									<option value="1">武汉房产公司</option>
									<option value="2">武汉房产公司</option>
									<option value="0">其他</option>
							</select> <input type="text" name="userInfo.companyName" id="NID"
								maxlength="15" class="tx ipt100 iptcpName"><span class="err_msg"></span>
							<li><span class="f_sub">设定密码：<em>*</em> </span><input
								type="password" name="user.password" id="Password"
								maxlength="20" class="tx ipt150">
								<p class="tip">
									<span class="is0" id="pwDiv"></span>
								</p></li>
							<li><span class="f_sub">确认密码：<em>*</em> </span><input
								type="password" name="user.rePwd" id="PasswordAgain"
								maxlength="20" class="tx ipt150"><span class="err_msg"></span></li>
							<li><span class="f_sub">验证码：<em>*</em> </span><input
								type="text" maxlength="8" class="tx yz1 ipt60" name="code" id="code"><img
								height="26" align="middle"
								src="rand.action"
								onclick="changeValidateCode(this)" class="ml10 mr10"
								style="cursor: pointer; vertical-align: middle"
								alt="点击刷新验证码">
                                <span class="err_msg"></span>
                                </li>
								
								<script type="text/javascript">
							function changeValidateCode(obj) {
								//获取当前的时间作为参数，无具体意义   
								var timenow = new Date().getTime();
								//每次请求需要一个不同的参数，否则可能会返回同样的验证码   
								//这和浏览器的缓存机制有关系，也可以把页面设置为不缓存，这样就不用这个参数了。   
								obj.src = "rand.action?d=" + timenow;
							}
						</script>
							<li style="height: 1px;">&nbsp;</li>

							<li class="tip c_gray"><span class="b_submit mr10">
									<button id="regSubmit" type="submit">同意服务协议，提交注册</button> </span>已有账号？<a
								href="login.jsp">请登录</a></li>
							<%--<li class="tip"><a target="_blank" href="#">--%>
									<%--查看《房产网网站服务条款》</a></li>--%>
						</ul>
					</form>
				</div>
			</div>

			<div class="r_m">
				<h4>注册成为房产网用户：</h4>
				<ul class="dot_list">
					<li>速览每日最新最热房地产行业资讯</li>
					<li>参与房地产全产业链商务交易</li>
					<li>畅享<em class="c_red">800000份</em>报告资源下载</li>
					<li>查询国内最权威市场数据</li>
					<li>与<em class="c_red">1600000名</em>职业房地产人互动交流</li>
					<li>被近千名驻站行业猎头关注</li>
				</ul>
			</div>



		</div>

	</div>

	<%@include file="../common/foot.jsp"%>
</body>
<c:if test="${not empty errMsg}">
<script>
	showRtnMsg("${errMsg}");
</script>
</c:if>
</html>