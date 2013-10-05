<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page language="java" import="com.fcw.common.WebCfg"%>
<div id="top" class="ui-top">
    <div id="top-banner">
        <div id="top-login">欢迎光临 &nbsp; &nbsp;<span style="font-weight:bold;color:#FF6600;" class="ui-color-green"><%=WebCfg.SITE_NAME.getValue() %></span> &nbsp;
    <span class="ui-color-green swap-city"><a href="#">[切换城市]</a></span>
    <div id="city-pnl">
     <a href="#">成都</a>
    <a href="#">成都</a>
    <a href="#">成都</a>
    </div>
        </div>
        <div id="top-nav">
    <c:if test="${empty login}">
    <span><a href="../user/reg.jsp">注册</a></span><span class="mid-span">|</span><span><a href="../user/login.jsp">登录</a></span>
    </c:if>
    <c:if test="${not empty login}">
    <span><a href="#">VIP特权</a></span><span class="mid-span">|</span>
    <span class="has-menu"><a href="../user!loginOut.action">我的房资网</a>
    <div class="hd-menu" id="my-fzw">
    
    <a  href="userinfo!edit.action">我的博客</a>
    <a href="userfile!list.action?exam=0">资料下载</a>
    <a href="usertender!list.action">商务合作</a>
    <a href="../user!loginOut.action">推出登录</a>
    </div>
    </span
    ><span class="mid-span">|</span><span><a href="/sfw/usercenter/userinfo!edit.action">${user.nick}</a></span>
    </c:if>
    </div>
    </div>
</div>
