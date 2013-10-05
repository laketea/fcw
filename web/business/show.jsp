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
<title>房产网-商务合作</title>
<link type="text/css" rel="stylesheet"
	href="../resource/css/default.css" />

<link type="text/css" rel="stylesheet" href="../resource/css/common.css" />
<link type="text/css" rel="stylesheet"
	href="../resource/css/ui-default.css" />
<link type="text/css" rel="stylesheet"
	href="../resource/css/default.css" />

<link type="text/css" rel="stylesheet" href="../resource/css/sidle.css" />
<link type="text/css" rel="stylesheet" href="../resource/css/jquery-ui.css" />
<link type="text/css" rel="stylesheet" href="../resource/css/swhz.css" />
<script type="text/javascript" src="../resource/js/jquery.js"></script>
<script type="text/javascript" src="../resource/js/jquery-ui.min.js"></script>
<script type="text/javascript" src="../resource/js/common.js"></script>
<script src="../resource/js/jquery.Xslider.js"></script>
</head>
<script type="text/javascript">
	$(document).ready(function() {
		// 焦点图片淡隐淡现
		$("#slider6").Xslider({
			affect : 'fade',
			ctag : 'div'
		});
	});
</script>
<body>

	<%@include file="../common/top.jsp"%>
	<c:set var="channelName" value="商务合作" scope="request" />
	<%@include file="../common/head.jsp"%>
	<div id="top-grad"></div>
	
<div id="swhz" class="wrap center960 box ">
    <div class="banner">
     <div class="business-adv">

				<div class="slider" id="slider6">
					<div class="conbox">
						<c:forEach var="item" items="${slideLst}">
							<div>
								<a href="${item.url}" target="_blank" title=""><img
									width="708" height="231" border="0" alt=""
									src="../${item.photo}" />
								</a>
							</div>
						</c:forEach>

					</div>
					<div class="switcher">
						<a href="#" class=""></a> <a href="#" class="cur"></a>
					</div>
				</div>

			</div>
    <div class="sw-login"></div>
    <div  class="sw-reg"></div>
    </div>
    <div class="content fl">
        <div class="title"><span>招标信息 >> ${tender.name}</span></div>
        <c:if test="${not empty errMsg }">
        	 <div id="err-content">
            <h3>${errMsg}</h3>
            <div class="detail-info box"> 
            </div>
            
        </div>
        </c:if>
         <c:if test="${empty errMsg}">
        <div id="zb-content">
            <h3>工程基本信息
            <c:if test="${tender.overdue eq 1}">
            <a >[ 已过期 ]</a>
            </c:if>
            <c:if test="${tender.overdue eq 0}">
            <a sid="${tender.id}" class="showTb">[立即投标]</a>
            </c:if>
            </h3>
            <div class="detail-info box">
                <span>招标编号:${tender.tenderNum}</span>
                <span>招标公司:${tender.company}</span>
                <span>招标项目:${tender.name}</span>
                <span>招标类别:${tender.tenderType}</span>
                <span>联系人:${tender.contact}</span>
                <span>联系电话:${tender.phone}</span>
                <span>发布时间:${tender.pbTime}</span>
                <span>有效期限:${tender.dffDate}</span>
            </div>
            <h3>招标内容</h3>
            <div class="zb-des"><p>
            	${tender.content}
            </p></div>
            
            <h3>招标留言</h3>
					<div class="zb-des">
						<ul class="zb-comment-ul">
							<c:if test="${empty guestPage.list}">
								<li style="height: 50px; line-height: 50px; text-algin: center">暂无留言</li>
							</c:if>
							<c:forEach items="${guestPage.list}" var="item" varStatus="status">
								<li>
									<div >
										<span style="font-weight:bold;float:clear;font-size:14px;padding-right:5px">${item.userName }:</span><span>${item.content}</span>
									</div>
									<div class="comment-time" style="font-size:12px;color:#999">发布与 ${item.guestTime}</div>
								</li>
							</c:forEach>
						</ul>
					</div>
            
        </div>
        </c:if>
   
   
    </div>
    <div id="zb-list" class=" sidebar fr">
        <h2>中标公告</h2>
        <div class="zb-bg"></div>
        <ul>
         <c:forEach var="litem" items="${sucessedLst}" >
            <li>
                <h3>${litem.name}</h3>
                <span>${litem.winnerName}</span>
            </li>
          </c:forEach>
        </ul>
    </div>



</div>
	
	<%@include file="../common/foot.jsp"%>
<div id="dialog-form" title="投标留言">
	<form>
	<fieldset>
		<label for="name">留言</label>
		<textarea id="ly-content" class="text ui-widget-content ui-corner-all" rows="8" cols="41" ></textarea>
		<input type="hidden" name="sid" id="sid" >
	</fieldset>
	</form>
</div>



</body>
</html>