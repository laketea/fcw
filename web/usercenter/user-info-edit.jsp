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
    <li  class="cur" ><a href="../userinfo!edit.action">基本信息</a></li>
    <li   ><a href="../userinfo!blog.action">博客信息</a></li>
    <li ><a href="../userinfo!edit.action">修改头像</a></li>

    </ul>


    <p class="uc-c-nav">
    </p>
    </div>

    <div class="main-block">
    <div class="upload-warn">

    </div>

    <form action="userinfo!save.action" method="post">
    <input type="hidden" name="userInfo.companyId" value="${userInfo.companyId}"  >
    <input type="hidden" name="userInfo.id" value="${userInfo.id}"  >
    <input type="hidden" name="userInfo.status" value="${userInfo.status}" />
    <input type="hidden" name="userInfo.score" value="${userInfo.score}" />

    <table class="data upload-data">
     <tbody>
        <tr>
            <th align="right">公司名称:</th>
            <td align="left">
    <input type="text" name="userInfo.companyName" value="${userInfo.companyName}" readOnly="true" size="30" />
            </td>
        </tr>

    <tr>
    <th align="right">真实名字:</th>
    <td align="left">
    <input type="text" name="userInfo.realName" value="${userInfo.realName}" class="required" size="30" />
    </td>
    </tr>

    <tr>
    <th align="right">性别：</th>
    <td align="left">
    <select  name="userInfo.male" >
    <option value="0"  ${'0' eq userInfo.male ? 'selected' : ''}>男</option>
    <option value="1" ${'1' eq userInfo.male ? 'selected' : ''}>女</option>
    </select>
    </td>
    </tr>

    <tr>
    <th align="right">年龄：</th>
    <td align="left">
    <input type="text" name="userInfo.age" value="${userInfo.age}" class="required" size="30" />
    </td>
    </tr>

    <tr>
    <th align="right">联系电话：</th>
    <td align="left">
    <input type="text" name="userInfo.phone" value="${userInfo.phone}" class="required" size="30" />
    </td>
    </tr>

    <tr>
    <th align="right">积分：</th>
    <td align="left">
    <input type="text"  value="${userInfo.score}" readOnly="true"  size="30" />
    </td>
    </tr>

    <tr>

    <td align="left" colspan="2" style="padding-left:160px;height:50px">
        <button class="blue-btn">修改</button>
    </td>
    </tr>

    </tbody>
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