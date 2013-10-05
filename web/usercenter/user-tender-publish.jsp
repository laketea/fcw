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
    <li ><a href="usertender!list.action">我发布的招标信息</a></li>
    <li ><a href="usertender!msglist.action">我的投标信息</a></li>
    <li  class="cur"><a href="user-tender-publish.jsp">发布招标</a></li>
    </ul>


    <p class="uc-c-nav">
    </p>
    </div>

    <div class="main-block">
    <div class="upload-warn">

    </div>

    <form action="usertender!publish.action" method="post">
    <input type="hidden" name="tender.status" value="0"  >

    <table class="data upload-data">
     <tbody>
        <tr>
            <th align="right">招标编号:</th>
            <td align="left">
        <input type="text" name="tender.tenderNum"  size="30" />
            </td>
        </tr>

    <tr>
    <th align="right">招标项目名称:</th>
    <td align="left">
    <input type="text" name="tender.name"  size="30" />
    </td>
    </tr>

    <tr>
    <th align="right">招标公司:</th>
    <td align="left">
    <input type="text" name="tender.company" class="required" size="30" />
    </td>
    </tr>

    <tr>
    <th align="right">招标类别:</th>
    <td align="left">
    <input type="text" name="tender.tenderType" class="required" size="30" />
    </td>
    </tr>

    <tr>
    <th align="right">联系人:</th>
    <td align="left">
    <input type="text" name="tender.contact" class="required" size="30" />
    </td>
    </tr>

    <tr>
    <th align="right">联系电话:</th>
    <td align="left">
    <input type="text" name="tender.phone" class="required" size="30" />
    </td>
    </tr>

    <tr>
    <th align="right">有效日期:</th>
    <td align="left">
    <input type="text" name="tender.dffDate" class="required" size="30" />
    </td>
    </tr>

    <tr>
    <th align="right">截至时间:</th>
    <td align="left">
    <input type="text" name="tender.endTime"   />
    </td>
    </tr>



    <tr>
    <th align="right">招标内容:</th>
    <td align="left">
    <textarea name="tender.content" cols="78" rows="5" ></textarea>
    </td>
    </tr>

    <tr>

    <td align="left" colspan="2" style="padding-left:160px;height:50px">
        <button class="blue-btn">发布</button>
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