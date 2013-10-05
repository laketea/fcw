<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>数字认证后台管理系统</title>

<link href="themes/default/style.css" rel="stylesheet" type="text/css"
	media="screen" />
<link href="themes/css/core.css" rel="stylesheet" type="text/css"
	media="screen" />
<link href="themes/css/ext.css" rel="stylesheet" type="text/css"
	media="screen" />
<link href="themes/css/print.css" rel="stylesheet" type="text/css"
	media="print" />
<link href="uploadify/css/uploadify.css" rel="stylesheet"
	type="text/css" media="screen" />
<!--[if IE]>
<link href="themes/css/ieHack.css" rel="stylesheet" type="text/css" media="screen"/>
<![endif]-->

<script src="js/speedup.js" type="text/javascript"></script>
<script src="js/jquery-1.7.2.js" type="text/javascript"></script>
<script src="js/jquery.cookie.js" type="text/javascript"></script>
<script src="js/jquery.validate.js" type="text/javascript"></script>
<script src="js/jquery.bgiframe.js" type="text/javascript"></script>
<script src="xheditor/xheditor-1.1.14-zh-cn.min.js"
	type="text/javascript"></script>
<script src="uploadify/scripts/swfobject.js" type="text/javascript"></script>
<script src="uploadify/scripts/jquery.uploadify.v2.1.0.js"
	type="text/javascript"></script>

<!-- svg图表  supports Firefox 3.0+, Safari 3.0+, Chrome 5.0+, Opera 9.5+ and Internet Explorer 6.0+ -->
<script type="text/javascript" src="chart/raphael.js"></script>
<script type="text/javascript" src="chart/g.raphael.js"></script>
<script type="text/javascript" src="chart/g.bar.js"></script>
<script type="text/javascript" src="chart/g.line.js"></script>
<script type="text/javascript" src="chart/g.pie.js"></script>
<script type="text/javascript" src="chart/g.dot.js"></script>

<script src="js/dwz.core.js" type="text/javascript"></script>
<script src="js/dwz.util.date.js" type="text/javascript"></script>
<script src="js/dwz.validate.method.js" type="text/javascript"></script>
<script src="js/dwz.regional.zh.js" type="text/javascript"></script>
<script src="js/dwz.barDrag.js" type="text/javascript"></script>
<script src="js/dwz.drag.js" type="text/javascript"></script>
<script src="js/dwz.tree.js" type="text/javascript"></script>
<script src="js/dwz.accordion.js" type="text/javascript"></script>
<script src="js/dwz.ui.js" type="text/javascript"></script>
<script src="js/dwz.theme.js" type="text/javascript"></script>
<script src="js/dwz.switchEnv.js" type="text/javascript"></script>
<script src="js/dwz.alertMsg.js" type="text/javascript"></script>
<script src="js/dwz.contextmenu.js" type="text/javascript"></script>
<script src="js/dwz.navTab.js" type="text/javascript"></script>
<script src="js/dwz.tab.js" type="text/javascript"></script>
<script src="js/dwz.resize.js" type="text/javascript"></script>
<script src="js/dwz.dialog.js" type="text/javascript"></script>
<script src="js/dwz.dialogDrag.js" type="text/javascript"></script>
<script src="js/dwz.sortDrag.js" type="text/javascript"></script>
<script src="js/dwz.cssTable.js" type="text/javascript"></script>
<script src="js/dwz.stable.js" type="text/javascript"></script>
<script src="js/dwz.taskBar.js" type="text/javascript"></script>
<script src="js/dwz.ajax.js" type="text/javascript"></script>
<script src="js/dwz.pagination.js" type="text/javascript"></script>
<script src="js/dwz.database.js" type="text/javascript"></script>
<script src="js/dwz.datepicker.js" type="text/javascript"></script>
<script src="js/dwz.effects.js" type="text/javascript"></script>
<script src="js/dwz.panel.js" type="text/javascript"></script>
<script src="js/dwz.checkbox.js" type="text/javascript"></script>
<script src="js/dwz.history.js" type="text/javascript"></script>
<script src="js/dwz.combox.js" type="text/javascript"></script>
<script src="js/dwz.print.js" type="text/javascript"></script>
<!--
<script src="bin/dwz.min.js" type="text/javascript"></script>
-->
<script src="js/dwz.regional.zh.js" type="text/javascript"></script>

<script type="text/javascript">
	$(function() {
		DWZ.init("conf/dwz.frag.xml", {
			loginUrl : "common/login_dialog.jsp",
			loginTitle : "登录", // 弹出登录对话框
			//		loginUrl:"login.html",	// 跳到登录页面
			statusCode : {
				ok : 200,
				error : 300,
				timeout : 301
			}, //【可选】
			pageInfo : {
				pageNum : "pageNum",
				numPerPage : "numPerPage",
				orderField : "orderField",

				orderDirection : "orderDirection"
			}, //【可选】
			debug : false, // 调试模式 【true|false】
			callback : function() {
				initEnv();
				$("#themeList").theme({
					themeBase : "themes"
				}); // themeBase 相对于index页面的主题base路径
			}
		});
	});
	function auditNotPass() {
		setTimeout(function() {
			$.pdialog.open("demo_page4.html", "addOpinionDia", "填写不通过原因", {
				width : "600",

				height : "250"
			});
		}, 10)
		return false;
	}
</script>
</head>
<body scroll="no">
	<div id="layout">
		<div id="header">
			<div class="headerNav">
				<a class="logo" href="http://j-ui.com">标志</a>
				<ul class="nav">

					<li><a href="changepwd.html" target="dialog" width="600">设置</a>
					</li>
					<li><a href="admin!loginOut.action">退出</a>
					</li>
				</ul>
				<ul class="themeList" id="themeList">
					<li theme="default">
						<div class="selected">蓝色</div></li>
					<li theme="green">
						<div>绿色</div></li>
					<!--<li theme="red"><div>红色</div></li>-->
					<li theme="purple">
						<div>紫色</div></li>
					<li theme="silver">
						<div>银色</div></li>
					<li theme="azure">
						<div>天蓝</div></li>
				</ul>
			</div>

			<!-- navMenu -->
		</div>

		<div id="leftside">
			<div id="sidebar_s">
				<div class="collapse">
					<div class="toggleCollapse">
						<div></div>
					</div>
				</div>
			</div>
			<div id="sidebar">
				<div class="toggleCollapse">
					<h2>主菜单</h2>
					<div>收缩</div>
				</div>

				<div class="accordion" fillSpace="sidebar">
					<div class="accordionHeader">
						<h2>
							<span>Folder</span>功能菜单
						</h2>
					</div>
					<div class="accordionContent">
						<ul class="tree treeFolder">
							<li><a>用户管理</a>
								<ul>
									<li><a href="users!list.action" target="navTab"
										rel="usersList">用户帐号</a>
									</li>
									<li><a href="users!normallist.action" target="navTab"
										rel="usersList">普通用户</a>
									</li>
									<li><a href="users!companylist.action" target="navTab"
										rel="usersList">公司用户</a>
									</li>
									<li><a href="users!unveritylist.action" target="navTab"
										rel="usersList">待验证用户</a>
									</li>
									
								</ul>
							</li>
							<li><a>房产资讯</a>
								<ul>
									<li><a href="newsChannel!list.action"
										target="navTab" rel="newsChannelList">资讯分类</a>
									</li>
									<li><a href="news!list.action" target="navTab"
										rel="newsList">所有资讯</a>
									</li>
									<li><a href="news!dcxwlist.action" target="navTab"
										rel="newsList">地产新闻</a>
									</li>
									<li><a href="news!yjkdlist.action" target="navTab"
										rel="newsList">业界快递</a>
									</li>
									<li><a href="news!hdbblist.action" target="navTab"
										rel="newsList">活动播报</a>
									</li>
									<li><a href="news!rwljlist.action" target="navTab"
										rel="newsList">软文连接</a>
									</li>
									<li><a href="news!jlhdlist.action" target="navTab"
										rel="newsList">交流互动</a>
									</li>
									<li><a href="news!shxklist.action" target="navTab"
										rel="newsList">生活闲侃</a>
									</li>
									<li><a href="news!photolist.action" target="navTab"
										rel="newsList">图文新闻</a>
									</li>
									

								</ul>
							</li>
							<li><a>房产资源</a>
								<ul>
									<li><a href="resourceChannel!list.action"
										target="navTab" rel="resourceChannelList">房产资源分类</a>
									</li>
									<li><a href="resource!list.action"
										target="navTab" rel="resourceList">房产资源</a>
									</li>
									
									<li><a href="resourceVisit!list.action"
										target="navTab" rel="resourceVisitList">资源访客记录</a>
									</li>
								</ul>
							</li>
							<li><a>商务合作</a>
								<ul>
									<li><a href="tender!list.action"
										target="navTab" rel="tenderList">招标信息</a>
									</li>
									<li><a href="tenderGuest!list.action"
										target="navTab" rel="tenderGuestList">投标留言</a>
									</li>
									
								</ul>
							</li>
							<li><a>资料管理</a>
								<ul>
									<li><a href="inforChannel!list.action"
										target="navTab" rel="inforChannelList">资料分类</a>
									</li>
									<li><a href="information!list.action"
										target="navTab" rel="informationList">资料信息</a>
									</li>
									<li><a href="information!exlist.action"
										target="navTab" rel="informationList">待审核资料</a>
									</li>
    <li><a href="reward!list.action"
    target="navTab" rel="rewardList">悬赏信息</a>
    </li>
									<li><a href="downLoad!list.action"
										target="navTab" rel="downLoadList">资料评论</a>
									</li>
									
								</ul>
							</li>
							<li><a>博客管理</a>
								<ul>
									<li><a href="blogInfo!list.action"
										target="navTab" rel="blogInfoList">博客列表</a>
									</li>
									<li><a href="article!list.action"
										target="navTab" rel="articleList">日志列表</a>
									</li>
									<li><a href="artCatalog!list.action"
										target="navTab" rel="artCatalogList">日志分类</a>
									</li>
									<li><a href="blogComment!list.action"
										target="navTab" rel="blogCommentList">博文评论</a>
									</li>
									<li><a href="friend!list.action"
										target="navTab" rel="friendList">好友信息</a>
									</li>
									<li><a href="blogVisit!list.action"
										target="navTab" rel="blogVisitList">博客访问</a>
									</li>
									<li><a href="blogGuest!list.action"
										target="navTab" rel="blogGuestList">博客留言</a>
									</li>
									<li><a href="message!list.action"
										target="navTab" rel="messageList">站内信</a>
									</li>
									
								</ul>
							</li>
							<li><a>广告管理</a>
								<ul>
									<li><a href="adv!list.action"
										target="navTab" rel="advList">广告设置</a>
									</li>
								</ul>
							</li>
							<li><a>系统管理</a>
								<ul>
									<li><a href="mutliSite!list.action"
										target="navTab" rel="mutliSiteList">多站点设置</a>
									</li>
									<li><a href="cache!reflush.action"
										target="navTab" rel="cache">刷新缓存</a>
									</li>
									<li><a href="slide!list.action"
										target="navTab" rel="slideList">幻灯片设置</a>
									</li>
									<li><a href="webcfg!show.action"
										target="navTab" rel="webCfg">系统设置</a>
									</li>
									<li><a href="hotWords!list.action"
										target="navTab" rel="hotWordsList">热门关键字</a>
									</li>
									<li><a href="admin!list.action"
										target="navTab" rel="adminList">后台账户</a>
									</li>
									<li><a href="loginInfo!list.action"
										target="navTab" rel="loginInfoList">登录信息</a>
									</li>
									
								</ul>
							</li>

						</ul>
					</div>
					<div class="accordionHeader">
						<h2>
							<span>Folder</span>典型功能
						</h2>
					</div>
					<div class="accordionContent"></div>
					<div class="accordionHeader">
						<h2>
							<span>Folder</span>典型功能
						</h2>
					</div>
					<div class="accordionContent"></div>
				</div>
			</div>
		</div>
		<div id="container">
			<div id="navTab" class="tabsPage">
				<div class="tabsPageHeader">
					<div class="tabsPageHeaderContent">
						<!-- 显示左右控制时添加 

class="tabsPageHeaderMargin" -->
						<ul class="navTab-tab">
							<li tabid="main" class="main"><a href="javascript:;"><span><span
										class="home_icon">我的主页</span>
								</span>
							</a>
							</li>
						</ul>
					</div>
					<div class="tabsLeft">left</div>
					<!-- 禁用只需要添加一个样式 class="tabsLeft 

tabsLeftDisabled" -->
					<div class="tabsRight">right</div>
					<!-- 禁用只需要添加一个样式 

class="tabsRight tabsRightDisabled" -->
					<div class="tabsMore">more</div>
				</div>
				<ul class="tabsMoreList">
					<li><a href="javascript:;">后台管理主页</a>
					</li>
				</ul>
				<div class="navTab-panel tabsPageContent layoutBox">
					<div class="page unitBox">
						<div class="accountInfo">
							<div class="alertInfo">
								<h2></h2>
							</div>
							<div class="right"></div>
							<p>
								<span>数字认证后台管理</span>
							</p>
							<p></p>
						</div>
						<div class="pageFormContent" layoutH="80"
							style="margin- right: 230px">



							<div class="divider"></div>
							<h2>教程:</h2>
							<p></p>

							<div class="divider"></div>
							<h2></h2>

						</div>

						<div style="width: 230px; position: absolute; top: 60px; right: 0"
							layoutH="80">
							
						</div>
					</div>

				</div>
			</div>
		</div>

	</div>

	<div id="footer">Copyright &copy; 2012 Laketea Tel：028- 88888888
	</div>

</body>
</html>