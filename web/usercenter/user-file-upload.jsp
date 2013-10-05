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
    <li  ><a href="userfile!list.action?exam=0">我的资料</a></li>
    <li ><a href="userfile!download.action">我的下载</a></li>
    <li><a href="userfile!list.action?exam=-1">审核管理</a></li>
    <li class="cur" ><a href="userfile!upload.action">上传资料</a></li>

    </ul>


    <p class="uc-c-nav">
    </p>
    </div>

    <div class="main-block">
    <div class="upload-warn">
    <h3>上传温馨提示:</h3>
    <ul>
    <li>A．上传的资料需经过管理员审核才能开通给网友下载。</li>
    <li>B．管理员对通过审核的资料评定星级和币值，并按资料质量奖励相应地产币，
    同时也按网友的好评度和下载量持续奖励地产币。<br>
    <a target="_blank" href="#">详细审核标准和时间请查看 &gt;&gt;&gt;</a></li>
    <li>C．同一资料不能重复上传，不得上传下载中心已有的资料，否则资料不会通过审核，并有可能扣除您50-100个地产币。<br>
    查看资料是否重复的方法：登录 <a target="_blank" href="#">http://xiazai.dichan.com/</a> 在搜索框输入资料的关键词进行查询。<br>
    <a target="_blank" href="#">详细奖励规则请点此查看&gt;&gt;&gt;</a></li>
    </ul>
    </div>

    <form action="userfileupload!upload.action" method="post" enctype="multipart/form-data">
    <input type="hidden" name="info.gradeCount" value="0" />
    <input type="hidden" name="info.score" value="0" />
    <input type="hidden" name="info.aveScore" value="0" />
    <input type="hidden" name="info.examine" value="0" />
    <input type="hidden" name="info.admin" value="0" />
    <input type="hidden" name="info.status" value="0" />

    <table class="data upload-data">
     <tbody>
        <tr>
            <th align="right">请上传文件:</th>
            <td align="left">
                <input type="file" name="myFile"  />
            </td>
        </tr>

    <tr>
    <th align="right">资料名称:</th>
    <td align="left">
    <input type="text" name="info.name"  size="60" />
    </td>
    </tr>

    <tr>
    <th align="right">资源币:</th>
    <td align="left">
    <input type="text" name="info.year"  size="15" />
    </td>
    </tr>

    <tr>
    <th align="right">资料分类:</th>
    <td align="left">
    <select  name="info.channelId" class="required" >
    <option value="-1">&nbsp;&nbsp;请选择&nbsp;&nbsp;</option>
    <c:forEach var="item" items="${chlList}" >
    <option value="${item.id}">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${item.name}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</option>
    <c:forEach var="child" items="${item.childChannels}" >
    <option value="${child.id}">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${child.name}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</option>
    </c:forEach>
    </c:forEach>
    </select>
    </td>
    </tr>

    <tr>
    <th align="right">地区:</th>
    <td align="left">
    <input type="text" name="info.area"  size="20" />
    </td>
    </tr>

    <tr>
    <th align="right">年份:</th>
    <td align="left">
    <input type="text" name="info.year"  size="20" />
    </td>
    </tr>



    <tr>
    <th align="right">简介:</th>
    <td align="left">
    <textarea name="info.intro" cols="78" rows="5" ></textarea>
    </td>
    </tr>

    <tr>

    <td align="left" colspan="2" style="padding-left:160px;height:50px">
        <button class="blue-btn">上传文件</button>
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